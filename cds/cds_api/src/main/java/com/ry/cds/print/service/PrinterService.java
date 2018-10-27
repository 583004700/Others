package com.ry.cds.print.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.MQSender;
import com.ry.cds.amqp.bo.FileDataFormat;
import com.ry.cds.common.CommonConst;
import com.ry.cds.common.PrinterType;
import com.ry.cds.print.bo.Cluster;
import com.ry.cds.print.bo.PrintResultNotificationInput;
import com.ry.cds.print.bo.PrintTask;
import com.ry.cds.print.bo.Printer;
import com.ry.cds.print.bo.PrinterGetTaskInput;
import com.ry.cds.print.bo.PrinterGetTaskOutput;
import com.ry.cds.print.bo.PrinterReportRecord;
import com.ry.cds.print.bo.PrinterStateReportInput;
import com.ry.cds.print.dao.IClusterDao;
import com.ry.cds.print.dao.IPrintTaskDao;
import com.ry.cds.print.dao.IPrinterDao;
import com.ry.cds.user.bo.CommonOutput;
import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;
import com.ry.cds.user.bo.SystemConfig;
import com.ry.cds.user.service.IDocumentService;
import com.ry.cds.user.service.IPartnerService;
import com.ry.cds.user.service.SystemConfigService;
import com.ry.cds.utils.CryptogramHelper;
import com.ry.cds.utils.DateUtil;

@Service
public class PrinterService implements IPrinterService {
	private static final Logger log = LoggerFactory.getLogger(PrinterService.class);
	@Autowired
	IPrintTaskDao printTaskDao;
	@Autowired
	IPrinterDao printerDao;
	@Autowired
	IClusterDao clusterDao;
	@Autowired
	IDocumentService documentService;
	@Autowired
	IPartnerService partnerService;
	@Autowired
	SystemConfigService systemConfigService;

	@Autowired
	MQSender mqSender;

	@Override
	public int insert(PrintTask printTask) {
		return printTaskDao.insert(printTask);
	}

	@Override
	public int update(PrintTask printTask) throws Exception {
		return printTaskDao.update(printTask);
	}

	@Override
	public PrintTask get(long printTaskID) {
		return printTaskDao.get(printTaskID);
	}

	@Override
	public int getRetryCount(long printTaskID) {
		return printTaskDao.getRetryCount(printTaskID);
	}

	@Override
	public CommonOutput printResultNotification(PrintResultNotificationInput input) throws Exception {
		long printTaskID = Long
				.parseLong(CryptogramHelper.decryptThreeDESECB(input.getExtOrderNo(), CommonConst.DESKEY));
		PrintTask printTask = get(printTaskID);
		boolean reTryUsedUpOrSuccess = callBackPrintTaskAndReturnCheck(input, printTaskID);
		if (reTryUsedUpOrSuccess) {
			callBackDocument(input, printTask);
			callBackDocumentPrintRecode(input, printTask);
		}
		return fitCommonOutPut(input.getPartner(), CommonConst.RESULT_Y);
	}

	/**
	 * 回填打印任务表信息并且返回是否用完了重试次数或者成功
	 * 
	 * @param input
	 * @param printTaskID
	 * @return
	 * @throws Exception
	 */
	private boolean callBackPrintTaskAndReturnCheck(PrintResultNotificationInput input, long printTaskID)
			throws Exception {
		boolean reTryUsedUpOrSuccess = false;
		int retryCount = this.getRetryCount(printTaskID);
		SystemConfig systemConfig = systemConfigService.systemConfigs();
		PrintTask printTask = new PrintTask();
		printTask.setPrintTaskID(printTaskID);
		if (CommonConst.PRINT_STATUS_REPORT_SUC.equals(input.getStatus())) {
			reTryUsedUpOrSuccess = true;
			printTask.setTaskStatus(CommonConst.TASK_STATUS_PRINTED);
			printTask.setPrintedPageCount(input.getSuccCount());
			printTask.setPrintedEndPage(input.getSuccCount());
		} else {
			if (systemConfig.getRetryCount() == retryCount) {
				reTryUsedUpOrSuccess = true;
				printTask.setTaskStatus(CommonConst.TASK_STATUS_PRINT_FAILED);
			} else {
				printTask.setTaskStatus(CommonConst.TASK_STATUS_TO_BE_PRINTED);
			}
			printTask.setFailedMessage(input.getErrorCode());
			printTask.setRetryCount(retryCount + 1);
		}
		this.update(printTask);
		return reTryUsedUpOrSuccess;
	}

	/**
	 * 回填文档表信息
	 * 
	 * @param input
	 * @param printTask
	 * @return
	 */
	private int callBackDocument(PrintResultNotificationInput input, PrintTask printTask) throws Exception {

		Document document = new Document();
		document.setDocumentID(printTask.getDocumentID());
		if (CommonConst.PRINT_STATUS_REPORT_SUC.equals(input.getPrintStatus())) {
			document.setPrintStatus(CommonConst.PRINT_STATUS_PRINTED);
		} else {
			document.setPrintStatus(CommonConst.PRINT_STATUS_PRINT_FAILED);
		}
		return documentService.update(document);
	}

	/**
	 * 回填文档打印记录信息
	 * 
	 * @param input
	 * @param printTask
	 * @return
	 */
	private int callBackDocumentPrintRecode(PrintResultNotificationInput input, PrintTask printTask) {
		DocumentPrintRecord documentPrintRecord = new DocumentPrintRecord();
		documentPrintRecord.setPrintRecordID(printTask.getPrintRecordID());
		documentPrintRecord.setPrintPageCount(input.getSuccCount());
		documentPrintRecord.setFailedMessage(input.getErrorCode());
		if (CommonConst.PRINT_STATUS_REPORT_SUC.equals(input.getPrintStatus())) {
			documentPrintRecord.setPrintStatus(CommonConst.PRINT_STATUS_PRINTED);
		} else {
			documentPrintRecord.setPrintStatus(CommonConst.PRINT_STATUS_PRINT_FAILED);
		}
		return documentService.updatePrintRecode(documentPrintRecord);
	}

	@Override
	public PrinterGetTaskOutput printerGetTask(PrinterGetTaskInput printerGetTaskInput) throws Exception {
		PrintTask printTask = null;
		long printerID = this.getPrimaryByPrintSN(printerGetTaskInput.getPrintDevSn());
		if (printerID <= 0) {
			return fitPrinterGetTaskOutput(printTask, printerGetTaskInput.getPartner(), CommonConst.RESULT_N);
		}
		long clusterID = printerDao.getClusterIDByPrinterID(printerID);
		if (clusterID <= 0) {
			return fitPrinterGetTaskOutput(printTask, printerGetTaskInput.getPartner(), CommonConst.RESULT_N);
		}
		Cluster cluster = clusterDao.get(clusterID);
		if (null == cluster) {
			return fitPrinterGetTaskOutput(printTask, printerGetTaskInput.getPartner(), CommonConst.RESULT_N);
		}
		// 如果是演示群组的打印机，则根据群组ID去打印任务表拿任务
		if (CommonConst.CLUSTERTYPEID_DEMO == cluster.getClusterTypeID()) {
			printTask = printTaskDao.getAndUpdateByClusterID(clusterID, printerID);
		}
		if (null == printTask) {
			long schoolID = clusterDao.getSchoolIDByClusterID(clusterID);
			printTask = printTaskDao.getAndUpdateBySchoolID(schoolID, printerID);
		}
		if (null == printTask) {
			return fitPrinterGetTaskOutput(printTask, printerGetTaskInput.getPartner(), CommonConst.RESULT_N);
		}
		return fitPrinterGetTaskOutput(printTask, printerGetTaskInput.getPartner(), CommonConst.RESULT_Y);
	}

	@Override
	public PrinterGetTaskOutput fitPrinterGetTaskOutput(PrintTask printTask, String partnerKey, String result) {
		PrinterGetTaskOutput printerGetTaskOutput = new PrinterGetTaskOutput();
		printerGetTaskOutput.setResult(result);
		if (CommonConst.RESULT_Y.equals(result)) {
			try {
				SystemConfig systemConfig = systemConfigService.systemConfigs();
				printerGetTaskOutput.setExtOrderNo(CryptogramHelper
						.encryptThreeDESECB(String.valueOf(printTask.getPrintTaskID()), CommonConst.DESKEY));

				Document document = documentService.get(printTask.getDocumentID());
				printerGetTaskOutput.setPrintDataUrl(document.getPrintUrl());
				printerGetTaskOutput.setNotifyUrl(systemConfig.getPrintResultReportApiUrl());
				printerGetTaskOutput.setCopyCount("1");
				printerGetTaskOutput.setPrintCount(printTask.getPrintEndPage() - printTask.getPrintStartPage() + "");
			} catch (Exception e) {
				log.error("组装返回数据时异常：", e);
				printerGetTaskOutput.setResult(CommonConst.RESULT_N);
			}
		}
		String secret = partnerService.getSecretByKey(partnerKey);
		if (StringUtils.isNotBlank(secret)) {
			String signStr = CryptogramHelper.sign(CryptogramHelper.beanToMap(printerGetTaskOutput), secret);
			printerGetTaskOutput.setSignStr(signStr);
		}
		return printerGetTaskOutput;
	}

	@Override
	public CommonOutput stateReport(PrinterStateReportInput printerStateReportInput) throws Exception {
		Printer printer = printerDao.getByPrintSN(printerStateReportInput.getPrintDevSn());
		String partnerKey = printerStateReportInput.getPartner();
		if (null == printer || printer.getPrinterID() <= 0) {
			return fitCommonOutPut(partnerKey, CommonConst.RESULT_N);
		}
		updateByReportInfo(printerStateReportInput, printer);
		fitReportRecordAndSendMQ(printer);
		return fitCommonOutPut(partnerKey, CommonConst.RESULT_Y);
	}

	/**
	 * 组装MQ消息体并发送至MQ服务器
	 * 
	 * @param printer
	 * @throws IOException
	 */
	private void fitReportRecordAndSendMQ(Printer printer) throws IOException {
		PrinterReportRecord printerReportRecord = new PrinterReportRecord();
		printerReportRecord.setReportDateTime(DateUtil.getDateString("yyyy-MM-dd HH:mm:ss"));
		printerReportRecord.setPrinterID(printer.getPrinterID());
		printerReportRecord.setPrinterStatus(printer.getPrinterStatus());
		printerReportRecord.setStatusCode(printer.getStatusCode());
		printerReportRecord.setPrintedTotalPageCount(0);
		printerReportRecord.setErrorPaperCount(0);
		printerReportRecord.setCarryPaperCount(0);
		printerReportRecord.setPaperBoxRemain(printer.getPaperBoxRemain());
		printerReportRecord.setTonerRemain(0);
		printerReportRecord.setWasteRemain(0);
		printerReportRecord.setDrumRemain(0);
		printerReportRecord.setInkboxPrintedCount(0);
		printerReportRecord.setInkboxReaminPrintCount(0);
		printerReportRecord.setInkboxSN(printer.getInkboxSN());
		printerReportRecord.setInkboxStatus(printer.getInkboxStatus());
		printerReportRecord.setIp(printer.getIp());
		printerReportRecord.setWifiSsid(printer.getWifiSsid());
		printerReportRecord.setWifiPassword(printer.getWifiPassword());
		printerReportRecord.setLng(printer.getLng());
		printerReportRecord.setLat(printer.getLat());
		List<String> dataLines = new ArrayList<String>();
		dataLines.add(printerReportRecord.toString());
		mqSender.send(new FileDataFormat(dataLines, true, 1, 2, "printerreportrecord",
				DateUtil.getDateString("yyyy-MM-dd HH:mm:ss")));
	}

	@Override
	public CommonOutput fitCommonOutPut(String partnerKey, String result) {
		CommonOutput commonOutput = new CommonOutput();
		commonOutput.setResult(result);
		String secret = partnerService.getSecretByKey(partnerKey);
		if (StringUtils.isNotBlank(secret)) {
			String signStr = CryptogramHelper.sign(CryptogramHelper.beanToMap(commonOutput), secret);
			commonOutput.setSignStr(signStr);
		}
		return commonOutput;
	}

	/**
	 * 根据上报信息更新打印机信息
	 * 
	 * @param printerStateReportInput
	 * @param printerID
	 * @return
	 * @throws Exception
	 */
	private int updateByReportInfo(PrinterStateReportInput printerStateReportInput, Printer printer) throws Exception {
		int printerStatus = CommonConst.PRINTER_ERRORCODE_ERROR.equals(printerStateReportInput.getErrorCode())
				? CommonConst.PRINTER_STATUS_ERROR
				: CommonConst.PRINTER_STATUS_NORMAL;
		if (printerStatus == printer.getPrinterStatus()
				&& printerStateReportInput.getPrintStatus().equals(printer.getStatusCode())) {
			return 0;
		} else {
			printer.setPrinterStatus(printerStatus);
			printer.setStatusCode(printerStateReportInput.getPrintStatus());
			if (PrinterType.EC.name().equals(printerStateReportInput.getPrinterType())) {
				printer.setPrinterType(PrinterType.EC.getIndex());
			} else if (PrinterType.EM.name().equals(printerStateReportInput.getPrinterType())) {
				printer.setPrinterType(PrinterType.EM.getIndex());
			} else if (PrinterType.EC.name().equals(printerStateReportInput.getPrinterType())) {
				printer.setPrinterType(PrinterType.EC.getIndex());
			}
			return this.update(printer);
		}
	}

	@Override
	public int update(Printer printer) throws Exception {
		return printerDao.update(printer);
	}

	@Override
	public long getPrimaryByPrintSN(String printSN) {
		return printerDao.getPrimaryByPrintSN(printSN);
	}
}