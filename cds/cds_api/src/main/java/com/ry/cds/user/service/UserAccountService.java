package com.ry.cds.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.MQSender;
import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.common.CommonConst;
import com.ry.cds.common.CommonUtils;
import com.ry.cds.print.bo.Cluster;
import com.ry.cds.print.bo.PrintTask;
import com.ry.cds.print.service.IClusterService;
import com.ry.cds.print.service.IPrinterService;
import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintInput;
import com.ry.cds.user.bo.DocumentPrintOutput;
import com.ry.cds.user.bo.DocumentPrintRecord;
import com.ry.cds.user.bo.PrintBusyConfig;
import com.ry.cds.user.bo.SchoolPriceConfig;
import com.ry.cds.user.bo.User;
import com.ry.cds.user.bo.UserAccount;
import com.ry.cds.user.dao.IPrintBusyConfigDao;
import com.ry.cds.user.dao.ISchoolPriceConfigDao;
import com.ry.cds.user.dao.IUserAccountDao;
import com.ry.cds.user.dao.IUserDao;
import com.ry.cds.utils.CryptogramHelper;
import com.ry.cds.utils.DateUtil;
import com.ry.cds.utils.ListHelper;

@Service
public class UserAccountService implements IUserAccountService {
	private static final Logger log = LoggerFactory.getLogger(UserAccountService.class);
	@Autowired
	IUserDao userDao;
	@Autowired
	IDocumentService documentService;
	@Autowired
	IUserAccountDao userAccountDao;
	@Autowired
	ISchoolPriceConfigDao schoolPriceConfigDao;
	@Autowired
	IPrinterService printTaskService;
	@Autowired
	IPrintBusyConfigDao printBusyConfigDao;
	@Autowired
	IClusterService clusterService;
	@Autowired
	MQSender mqSender;

	@Override
	public DocumentPrintOutput print(DocumentPrintInput documentPrintInput) throws Exception {
		User user = userDao.getByCardNo(documentPrintInput.getCardNo());
		if (user == null) {
			log.error(String.format("根据卡号%s未找到有效用户", documentPrintInput.getCardNo()));
			return fitFailDocumentPrintOutput(String.format("根据卡号%s未找到有效用户", documentPrintInput.getCardNo()), "2");
		}

		long totalPrice = 0;
		int totalPage = 0;
		List<Document> documents = new ArrayList<Document>();
		for (String documentNo : documentPrintInput.getList()) {
			long documentID = Long.parseLong(CryptogramHelper.decryptThreeDESECB(documentNo, CommonConst.DESKEY));
			Document document = documentService.get(documentID);
			if (null == document) {
				return fitFailDocumentPrintOutput(String.format("未找到您要打印的文档%s", documentNo), "2");
			}
			if (CommonConst.PRINT_STATUS_TO_BE_PRINTED != document.getPrintStatus()) {
				return fitFailDocumentPrintOutput(String.format("文档%s已被打印或者打印失败", document.getDocumentName()), "2");
			}
			documents.add(document);
			totalPage += document.getPageCount();
		}
		SchoolPriceConfig schoolPriceConfig = schoolPriceConfigDao.get(user.getSchoolID());
		if (schoolPriceConfig.getSaleTypeID() == 1) {
			totalPrice = schoolPriceConfig.getPrice() * totalPage;
		} else {
			totalPrice = schoolPriceConfig.getPrice() * documents.size();
		}
		UserAccount userAccount = userAccountDao.get(user.getUserID(), 1);
		if (userAccount.getAmount() < totalPrice) {
			return fitFailDocumentPrintOutput("余额不足", "3");
		}
		printProcess(totalPrice, user, documents, schoolPriceConfig);
		return fitSuccDocumentPrintOutput(totalPrice);
	}

	/**
	 * 更新账户表缓存，插入打印记录和打印任务,更新文档状态
	 * 
	 * @param user
	 * @param documents
	 * @param schoolPriceConfig
	 * @throws Exception
	 */
	private void printProcess(long totalPrice, User user, List<Document> documents, SchoolPriceConfig schoolPriceConfig)
			throws Exception {
		updateCacheAndSendMQForUserAccount(user.getUserID(), totalPrice);
		long clusterID = getClusterID(user);
		for (Document document : documents) {
			DocumentPrintRecord documentPrintRecord = new DocumentPrintRecord();
			documentPrintRecord.setCreateUserID(user.getUserID());
			documentPrintRecord.setDocumentID(document.getDocumentID());
			if (schoolPriceConfig.getSaleTypeID() == 1) {
				documentPrintRecord.setTotalPrice(schoolPriceConfig.getPrice() * document.getPageCount());
				documentPrintRecord.setUnitPrice(schoolPriceConfig.getPrice());
			} else {
				documentPrintRecord.setTotalPrice(schoolPriceConfig.getPrice());
				documentPrintRecord.setUnitPrice(
						schoolPriceConfig.getPrice() / (document.getPageCount() > 0 ? document.getPageCount() : 1));
			}
			documentPrintRecord.setStatusFlag(1);
			documentPrintRecord.setPrintStatus(document.getPrintStatus());
			documentPrintRecord.setPrintPageCount(document.getPageCount());
			long printRecodeID = documentService.insertPrintRecode(documentPrintRecord);
			if (printRecodeID > 0) {
				int insertPrintTaskResult = insertPrintTask(printRecodeID, user, document, clusterID);
				if (insertPrintTaskResult > 0) {
					documentPrintStatusChange(document.getDocumentID());
				}
			}
		}
	}

	/**
	 * 获取机组ID
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private long getClusterID(User user) throws Exception {
		boolean isBusy = isBusy(user.getSchoolID());
		long clusterID = 0;
		List<Cluster> clusters = clusterService.getBySchoolID(user.getSchoolID());
		if (ListHelper.isEmpty(clusters)) {
			return 0;
		}
		for (Cluster cluster : clusters) {
			if (CommonConst.PRINT_FLAG_DEMOACCOUNT == user.getPrintFlag()) {
				if (CommonConst.CLUSTERTYPEID_DEMO != cluster.getClusterTypeID()) {
					continue;
				}
				clusterID = cluster.getClusterID();
				break;
			}
			if (isBusy && CommonConst.CLUSTERTYPEID_PRINTCENTER == cluster.getClusterTypeID()) {
				clusterID = cluster.getClusterID();
				break;
			}
		}
		return clusterID;
	}

	/**
	 * 根据学校ID校验是否忙时，如果是忙时则走打印中心
	 * @param schoolID
	 * @return
	 * @throws Exception
	 */
	private boolean isBusy(long schoolID) throws Exception {
		PrintBusyConfig printBusyConfig = printBusyConfigDao.getBySchoolID(schoolID);
		if (null != printBusyConfig && StringUtils.isNotBlank(printBusyConfig.getStartDateTime())
				&& StringUtils.isNotBlank(printBusyConfig.getEndDateTime())) {
			return DateUtil.currentBetweenParamDate(printBusyConfig.getStartDateTime(),
					printBusyConfig.getEndDateTime());
		}
		return false;

	}

	/**
	 * 更新couchbase 缓存，发送MQ更新数据库
	 * 
	 * @param totalPrice
	 * @throws Exception
	 */
	private void updateCacheAndSendMQForUserAccount(long userID, long totalPrice) throws Exception {
		UserAccountChange userAccountChange = new UserAccountChange();
		userAccountChange.setUserID(userID);
		userAccountChange.setAccountTypeID(1);
		userAccountChange.setHandelType(1);
		userAccountChange.setPrice(totalPrice);
		userAccountDao.updateCacheForUserAccount(userAccountChange);
		mqSender.send(userAccountChange);
	}

	/**
	 * 插入打印任务表
	 * 
	 * @throws Exception
	 */
	private int insertPrintTask(long printRecodeID, User user, Document document, long clusterID) throws Exception {

		PrintTask printTask = new PrintTask();
		printTask.setPrintRecordID(printRecodeID);
		printTask.setCardNo(user.getCardNo());
		printTask.setDocumentID(document.getDocumentID());
		printTask.setSchoolID(user.getSchoolID());
		printTask.setTaskStatus(CommonConst.PRINT_STATUS_TO_BE_PRINTED);
		printTask.setPrintedPageCount(0);
		printTask.setPrintedStartPage(0);
		printTask.setPrintedEndPage(0);
		printTask.setPrintPageCount(document.getPageCount());
		printTask.setPrintStartPage(0);
		printTask.setPrintEndPage(document.getPageCount());
		printTask.setRetryCount(0);
		printTask.setClusterID(clusterID);

		return printTaskService.insert(printTask);
	}

	/**
	 * 更新文档打印状态，更新为已创建打印任务
	 * 
	 * @param documentID
	 * @throws Exception
	 */
	private void documentPrintStatusChange(long documentID) throws Exception {
		Document document = new Document();
		document.setPrintStatus(CommonConst.PRINT_STATUS_CREATED_PRINTTASK);
		document.setDocumentID(documentID);
		documentService.update(document);
	}

	/**
	 * 失败时装配返回实体
	 * 
	 * @param documentPrintOutput
	 * @param errorMsg
	 */
	private DocumentPrintOutput fitFailDocumentPrintOutput(String errorMsg, String comfrimResult) {
		DocumentPrintOutput documentPrintOutput = new DocumentPrintOutput();
		documentPrintOutput.setResult(CommonConst.RESULT_N);
		documentPrintOutput.setSuccess(false);
		documentPrintOutput.setComfrimResult(comfrimResult);
		documentPrintOutput.setErrorMsg(errorMsg);
		documentPrintOutput.setFreezeAmount(0.00);
		return documentPrintOutput;
	}

	/**
	 * 失败时装配返回实体
	 * 
	 * @param documentPrintOutput
	 * @param errorMsg
	 */
	private DocumentPrintOutput fitSuccDocumentPrintOutput(long totalPrice) {
		DocumentPrintOutput documentPrintOutput = new DocumentPrintOutput();
		documentPrintOutput.setResult(CommonConst.RESULT_Y);
		documentPrintOutput.setSuccess(true);
		documentPrintOutput.setComfrimResult("1");
		documentPrintOutput.setFreezeAmount(CommonUtils.amountConvertYuan(totalPrice));
		return documentPrintOutput;
	}
}