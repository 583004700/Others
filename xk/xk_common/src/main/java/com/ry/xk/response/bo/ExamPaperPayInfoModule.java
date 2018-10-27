package com.ry.xk.response.bo;

/**
 * 获取购买试卷支付信息 <描述类的作用>
 * 
 * @ClassName: PaperPayInfoModule
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaperPayInfoModule
{
    /**
     * 获取结果，0失败 1成功
     */
    private int result;

    /**
     * 公众号ID
     */
    private String appId;

    /**
     * 随机串
     */
    private String nonceStr;

    /**
     * 时间戳
     */
    private String timeStamp;

    /**
     * 订单详情扩展字符串
     */
    private String packageEx;

    /**
     * 签名方式
     */
    private String signType;

    /**
     * 微信签名
     */
    private String paySign;

    public int getResult()
    {

        return result;
    }

    public String getTimeStamp()
    {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp)
    {

        this.timeStamp = timeStamp;
    }

    public void setResult(int result)
    {

        this.result = result;
    }

    public String getAppId()
    {

        return appId;
    }

    public void setAppId(String appId)
    {

        this.appId = appId;
    }

    public String getNonceStr()
    {

        return nonceStr;
    }

    public void setNonceStr(String nonceStr)
    {

        this.nonceStr = nonceStr;
    }

    public String getPackageEx()
    {

        return packageEx;
    }

    public void setPackageEx(String packageEx)
    {

        this.packageEx = packageEx;
    }

    public String getSignType()
    {

        return signType;
    }

    public void setSignType(String signType)
    {

        this.signType = signType;
    }

    public String getPaySign()
    {

        return paySign;
    }

    public void setPaySign(String paySign)
    {

        this.paySign = paySign;
    }

    public ExamPaperPayInfoModule()
    {}

    public ExamPaperPayInfoModule(int result, String appId, String nonceStr, String timeStamp, String packageEx, String signType, String paySign)
    {
        this.result = result;
        this.appId = appId;
        this.nonceStr = nonceStr;
        this.timeStamp = timeStamp;
        this.packageEx = packageEx;
        this.signType = signType;
        this.paySign = paySign;
    }

}
