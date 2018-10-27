package com.ry.cds.user.controller;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ry.cds.common.CommonConst;
import com.ry.cds.common.CommonUtils;
import com.ry.cds.print.bo.PrintListOutput;
import com.ry.cds.user.bo.SyncUserInput;
import com.ry.cds.user.bo.SyncUserOutput;
import com.ry.cds.user.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api("user相关api")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;

	@ApiOperation("同步用户接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "syncUserInput", dataType = "SyncUserInput", required = true, value = "同步用户的入参实体") })
	@RequestMapping(value = "/synchronous", method = RequestMethod.POST)
	public SyncUserOutput synchronous(@RequestBody @Validated SyncUserInput syncUserInput, BindingResult result) {
		SyncUserOutput syncUserOutput = null;
		if (result.hasErrors()) {
			syncUserOutput = new SyncUserOutput();
			syncUserOutput.setResult(CommonConst.RESULT_N);
			syncUserOutput.setSuccess(false);
			syncUserOutput.setFailureCount(0);
			syncUserOutput.setSuccessCount(0);
			syncUserOutput.setErrorMsg(CommonUtils.getAllValidateError(result.getAllErrors()));
			log.error("同步用户接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
			return syncUserOutput;
		}
		try {
			syncUserOutput = userService.synchronous(syncUserInput);
		} catch (Exception e) {
			syncUserOutput = new SyncUserOutput();
			syncUserOutput.setResult(CommonConst.RESULT_N);
			syncUserOutput.setSuccess(false);
			syncUserOutput.setFailureCount(0);
			syncUserOutput.setSuccessCount(0);
			syncUserOutput.setErrorMsg("同步用户接口异常");
			log.error("同步用户接口异常：", e);
		}
		return syncUserOutput;
	}

	@ApiOperation("获取用户打印列表及基础信息接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "cardNo", dataType = "String", required = true, value = "卡号") })
	@RequestMapping(value = "/printList", method = RequestMethod.POST)
	public PrintListOutput printList(@RequestParam("cardNo") String cardNo) {
		PrintListOutput printListOutput = null;
		try {
			printListOutput = userService.printList(cardNo);
		} catch (Exception e) {
			printListOutput = new PrintListOutput();
			printListOutput.setResult(CommonConst.RESULT_N);
			printListOutput.setSuccess(false);
			printListOutput.setErrorMsg("根据卡号为{0}获取用户打印列表及基础信息接口异常");
			log.error(MessageFormat.format("根据卡号为{0}获取用户打印列表及基础信息接口异常：", cardNo), e);
		}
		return printListOutput;
	}
}