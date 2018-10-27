package com.ry.xk.main.service;

import com.ry.xk.request.bo.AuthInfoApiReqeust;
import com.ry.xk.request.bo.WxInitApiReqeust;
import com.ry.xk.response.bo.WeChatJsSdkInitParameterModel;

/**
 * 授权业务接口
 * 
 * @ClassName: IAuthService
 * @author 幸仁强
 * @date 2018年5月29日
 */
public interface IAuthService
{
    /**
     * 获取token授权信息
     * 
     * @Title: getJWTAuth
     * @author 幸仁强
     * @return
     * @throws Exception
     */
    public String getTokenStr(AuthInfoApiReqeust authInfoApiReqeust)
        throws Exception;

    /**
     * 获取微信网页JSSDK 初始化参数
     * 
     * @Title: getWeChatJsSdkInfo
     * @author 幸仁强
     * @param request
     * @return
     * @throws Exception
     */
    public WeChatJsSdkInitParameterModel getWeChatJsSdkInfo(WxInitApiReqeust request)
        throws Exception;
}
