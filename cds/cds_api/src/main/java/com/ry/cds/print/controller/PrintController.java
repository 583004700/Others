package com.ry.cds.print.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ry.cds.common.CommonConst;
import com.ry.cds.common.CommonUtils;
import com.ry.cds.print.bo.PrintResultNotificationInput;
import com.ry.cds.print.bo.PrinterGetTaskInput;
import com.ry.cds.print.bo.PrinterGetTaskOutput;
import com.ry.cds.print.bo.PrinterStateReportInput;
import com.ry.cds.print.service.IPrinterService;
import com.ry.cds.user.bo.CommonOutput;
import com.ry.cds.user.service.IDocumentService;
import com.ry.cds.user.service.IPartnerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/printer")
@Api("Printer相关api")
public class PrintController {
	private static final Logger log = LoggerFactory.getLogger(PrintController.class);
	@Autowired
	IDocumentService documentService;

	@Autowired
	IPrinterService printerService;

	@Autowired
	IPartnerService partnerService;

	@ApiOperation("打印结果通知接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "printResultNotificationInput", dataType = "PrintResultNotificationInput", required = true, value = "打印结果通知的入参实体") })
	@RequestMapping(value = "/printResultNotification", method = RequestMethod.POST)
	public CommonOutput printResultNotification(
			@RequestBody @Validated PrintResultNotificationInput printResultNotificationInput, BindingResult result) {
		CommonOutput commonOutput = null;
		try {
			if (result.hasErrors()) {
				log.error("打印结果通知接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
				return printerService.fitCommonOutPut(printResultNotificationInput.getPartner(), CommonConst.RESULT_N);
			}
			commonOutput = printerService.printResultNotification(printResultNotificationInput);
		} catch (Exception e) {
			log.error(String.format("%s打印结果通知接口异常：", printResultNotificationInput.getExtOrderNo()), e);
			printerService.fitCommonOutPut(printResultNotificationInput.getPartner(), CommonConst.RESULT_N);
		}
		return commonOutput;
	}

	@ApiOperation("打印机状态上报接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "printerStateReportInput", dataType = "PrinterStateReportInput", required = true, value = "打印机状态上报的入参实体") })
	@RequestMapping(value = "/stateReport", method = RequestMethod.POST)
	public CommonOutput printerStateReport(@RequestBody @Validated PrinterStateReportInput printerStateReportInput,
			BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.error("打印结果通知接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
				return printerService.fitCommonOutPut(printerStateReportInput.getPartner(), CommonConst.RESULT_N);
			}
			return printerService.stateReport(printerStateReportInput);
		} catch (Exception e) {
			log.error(String.format("序列号为%s的打印机状态上报异常：", printerStateReportInput.getPrintDevSn()), e);
			return printerService.fitCommonOutPut(printerStateReportInput.getPartner(), CommonConst.RESULT_N);

		}
	}

	@ApiOperation("打印机获取任务接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "printerGetTaskInput", dataType = "PrinterGetTaskInput", required = true, value = "打印机设备序列号") })
	@RequestMapping(value = "/getTask", method = RequestMethod.POST)
	public PrinterGetTaskOutput getTask(@RequestBody @Validated PrinterGetTaskInput printerGetTaskInput,
			BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.error("打印机获取任务接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
				return printerService.fitPrinterGetTaskOutput(null, printerGetTaskInput.getPartner(),
						CommonConst.RESULT_N);
			}
			return printerService.printerGetTask(printerGetTaskInput);
		} catch (Exception e) {
			log.error(String.format("序列号为%s的打印机获取任务异常：", printerGetTaskInput.getPrintDevSn()), e);
			return printerService.fitPrinterGetTaskOutput(null, printerGetTaskInput.getPartner(), CommonConst.RESULT_N);
		}
	}

}