package com.ry.xk.main.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ry.xk.IgnoreToken;
import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.main.service.IAuthService;
import com.ry.xk.request.bo.AuthInfoApiReqeust;
import com.ry.xk.request.bo.WxInitApiReqeust;
import com.ry.xk.response.bo.WeChatGrantLoginModel;
import com.ry.xk.response.bo.WeChatJsSdkInitParameterModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
@Api("授权相关api")
public class AuthController
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    IAuthService authService;

    @ApiOperation("获取微信网页JSSDK 初始化参数")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "wxInitApiReqeust", dataType = "WxInitApiReqeust", required = true, value = "获取微信网页JSSDK 初始化参数入参实体")})
    @RequestMapping(value = "/getWeChatJsSdkInfo", method = RequestMethod.POST)
    public ResponseBase<WeChatJsSdkInitParameterModel> getWeChatJsSdkInfo(@RequestBody @Valid WxInitApiReqeust wxInitApiReqeust, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("获取微信网页JSSDK 初始化参数接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<WeChatJsSdkInitParameterModel>(CommonConst.RT_FAIL, "入参校验失败", null);
            }
            WeChatJsSdkInitParameterModel weChatJsSdkInitParameterModel = authService.getWeChatJsSdkInfo(wxInitApiReqeust);
            return new ResponseBase<WeChatJsSdkInitParameterModel>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, weChatJsSdkInitParameterModel);
        }
        catch (Exception e)
        {
            log.error(String.format("获取微信网页JSSDK 初始化参数异常,partnerId为%s", wxInitApiReqeust.getPartnerId()), e);
            return new ResponseBase<WeChatJsSdkInitParameterModel>(CommonConst.RT_FAIL, "获取jssdk参数异常", null);
        }
    }

    @IgnoreToken
    @ApiOperation("获取JWT授权")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "authInfoApiReqeust", dataType = "AuthInfoApiReqeust", required = true, value = "获取JWT授权入参实体")})
    @RequestMapping(value = "/getWeChatJWTAuth", method = RequestMethod.POST)
    public ResponseBase<WeChatGrantLoginModel> getJWTAuth(@RequestBody @Valid AuthInfoApiReqeust authInfoApiReqeust, BindingResult result, HttpServletResponse response)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("获取JWT授权入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                throw new NullPointerException("code为空");
            }
            String token = authService.getTokenStr(authInfoApiReqeust);
            return new ResponseBase<WeChatGrantLoginModel>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, new WeChatGrantLoginModel(token));
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return new ResponseBase<WeChatGrantLoginModel>(CommonConst.RT_FAIL, "授权失败", null);
        }
    }
}