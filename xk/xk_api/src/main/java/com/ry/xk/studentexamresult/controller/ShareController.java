package com.ry.xk.studentexamresult.controller;

import com.alibaba.fastjson.JSONException;
import com.ry.xk.IgnoreToken;
import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.main.service.IShareService;
import com.ry.xk.request.bo.ShareUrlRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/share")
@Api("分享相关api")
public class ShareController
{

    @Autowired
    IShareService shareService;

    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(ShareController.class);

    @ApiOperation("邀请好友分享")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "shareUrlRequest", dataType = "ShareUrlRequest", required = true, value = "入参")})
    @RequestMapping(value = "/pleaseFriend", method = RequestMethod.POST)
    @IgnoreToken
    public ResponseBase<String> generateExamData(@RequestBody @Valid ShareUrlRequest shareUrlRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        String imageAddress = "";
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int type = shareUrlRequest.getType();
                imageAddress = shareService.getShareImage(shareUrlRequest.getPartnerId(), type);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (JSONException j)
        {
            log.error("解析拓展字段json异常", j);
        }
        catch (Exception e)
        {
            log.error("邀请好友分享异常", e);
        }
        ResponseBase<String> rb = new ResponseBase<String>(resultType, "", imageAddress);
        return rb;
    }
}
