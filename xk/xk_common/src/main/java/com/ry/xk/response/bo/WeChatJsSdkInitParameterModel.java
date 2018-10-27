package com.ry.xk.response.bo;

/**
 * 获取微信网页JSSDK 初始化参数输出实体类 <描述类的作用>
 * 
 * @ClassName: WxInitOutput
 * @author DELL
 * @date 2018年5月22日
 */
public class WeChatJsSdkInitParameterModel
{
    private String appId;

    private String timestamp;

    private String nonceStr;

    private String signature;

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {

        this.appId = appId;
    }

    public String getTimestamp()
    {

        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {

        this.timestamp = timestamp;
    }

    public String getNonceStr()
    {

        return nonceStr;
    }

    public void setNonceStr(String nonceStr)
    {

        this.nonceStr = nonceStr;
    }

    public String getSignature()
    {

        return signature;
    }

    public void setSignature(String signature)
    {

        this.signature = signature;
    }
}
