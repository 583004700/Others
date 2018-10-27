package com.ry.cds.user.controller;

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
import com.ry.cds.user.bo.DocumentPrintInput;
import com.ry.cds.user.bo.DocumentPrintOutput;
import com.ry.cds.user.bo.ResultBase;
import com.ry.cds.user.bo.SyncDocumentInput;
import com.ry.cds.user.bo.SyncDocumentOutput;
import com.ry.cds.user.bo.UpdateDocumentInput;
import com.ry.cds.user.service.DocumentService;
import com.ry.cds.user.service.IUserAccountService;
import com.ry.cds.utils.CryptogramHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/document")
@Api("Document相关api")
public class DocumentController {
	private static final Logger log = LoggerFactory.getLogger(DocumentController.class);
	@Autowired
	DocumentService documentService;
	@Autowired
	IUserAccountService userAccountService;

	@ApiOperation("同步文档接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "syncDocumentInput", dataType = "SyncDocumentInput", required = true, value = "同步文档的入参实体") })
	@RequestMapping(value = "/synchronous", method = RequestMethod.POST)
	public SyncDocumentOutput synchronous(@RequestBody @Validated SyncDocumentInput syncDocumentInput,
			BindingResult result) {
		if (result.hasErrors()) {
			return new SyncDocumentOutput(CommonConst.RESULT_N, false, null,
					CommonUtils.getAllValidateError(result.getAllErrors()));
		}
		try {
			return documentService.synchronous(syncDocumentInput);
		} catch (Exception e) {
			log.error(String.format("文件名%s文件ID为%s的文档同步失败", syncDocumentInput.getDocumentName(),
					syncDocumentInput.getDocumentId()), e);
			return new SyncDocumentOutput(CommonConst.RESULT_N, false, null, "文档同步失败");

		}
	}

	@ApiOperation("打印文档接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "documentPrintInput", dataType = "DocumentPrintInput", required = true, value = "打印文档的入参实体") })
	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public DocumentPrintOutput print(@RequestBody @Validated DocumentPrintInput documentPrintInput,
			BindingResult result) {
		DocumentPrintOutput documentPrintOutput = null;
		if (result.hasErrors()) {
			log.error(String.format("卡号为%s打印任务入参校验失败", documentPrintInput.getCardNo()),
					CommonUtils.getAllValidateError(result.getAllErrors()));
			documentPrintOutput = new DocumentPrintOutput();
			documentPrintOutput.setResult(CommonConst.RESULT_N);
			documentPrintOutput.setSuccess(false);
			documentPrintOutput.setComfrimResult("2");
			documentPrintOutput.setErrorMsg(CommonUtils.getAllValidateError(result.getAllErrors()));
			return documentPrintOutput;
		}
		try {
			return userAccountService.print(documentPrintInput);
		} catch (Exception e) {
			log.error(String.format("卡号为%s的用户打印文档异常", documentPrintInput.getCardNo()), e);
			documentPrintOutput = new DocumentPrintOutput();
			documentPrintOutput.setResult(CommonConst.RESULT_N);
			documentPrintOutput.setSuccess(false);
			documentPrintOutput.setComfrimResult("2");
			documentPrintOutput.setErrorMsg(e.getMessage());
			return documentPrintOutput;
		}
	}

	@ApiOperation("更新文档接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "updateDocumentInput", dataType = "UpdateDocumentInput", required = true, value = "更新文档的入参实体") })
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBase update(@RequestBody @Validated UpdateDocumentInput updateDocumentInput, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.error(
						String.format("文档ID为%s的文档转换PRN后回调接口入参校验失败", CryptogramHelper
								.decryptThreeDESECB(updateDocumentInput.getDocumentID(), CommonConst.DESKEY)),
						CommonUtils.getAllValidateError(result.getAllErrors()));
				return new ResultBase(2, CommonUtils.getAllValidateError(result.getAllErrors()), false);
			}
			ResultBase resultBase = documentService.updateByReportInfo(updateDocumentInput);
			return resultBase;
		} catch (Exception e) {
			return new ResultBase(2, String.format("文档ID密串为%s的文档转换PRN后回调接口入参校验失败", updateDocumentInput.getDocumentID(),
					CommonConst.DESKEY), false);
		}
	}
}