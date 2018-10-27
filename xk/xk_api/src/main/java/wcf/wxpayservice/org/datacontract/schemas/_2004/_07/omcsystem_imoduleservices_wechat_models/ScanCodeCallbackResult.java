
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ScanCodeCallbackResult complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ScanCodeCallbackResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ErrCodeDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NonceStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrePayId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReturnMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScanCodeCallbackResult", propOrder = {"appId", "errCodeDes", "mchId", "nonceStr", "prePayId", "resultCode", "returnCode", "returnMsg", "sign"})
public class ScanCodeCallbackResult
{

    @XmlElementRef(name = "AppId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> appId;

    @XmlElementRef(name = "ErrCodeDes", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> errCodeDes;

    @XmlElementRef(name = "MchId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> mchId;

    @XmlElementRef(name = "NonceStr", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> nonceStr;

    @XmlElementRef(name = "PrePayId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> prePayId;

    @XmlElementRef(name = "ResultCode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> resultCode;

    @XmlElementRef(name = "ReturnCode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> returnCode;

    @XmlElementRef(name = "ReturnMsg", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> returnMsg;

    @XmlElementRef(name = "Sign", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> sign;

    /**
     * 获取appId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getAppId()
    {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setAppId(JAXBElement<String> value)
    {
        this.appId = value;
    }

    /**
     * 获取errCodeDes属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getErrCodeDes()
    {
        return errCodeDes;
    }

    /**
     * 设置errCodeDes属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setErrCodeDes(JAXBElement<String> value)
    {
        this.errCodeDes = value;
    }

    /**
     * 获取mchId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getMchId()
    {
        return mchId;
    }

    /**
     * 设置mchId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setMchId(JAXBElement<String> value)
    {
        this.mchId = value;
    }

    /**
     * 获取nonceStr属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getNonceStr()
    {
        return nonceStr;
    }

    /**
     * 设置nonceStr属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setNonceStr(JAXBElement<String> value)
    {
        this.nonceStr = value;
    }

    /**
     * 获取prePayId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getPrePayId()
    {
        return prePayId;
    }

    /**
     * 设置prePayId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setPrePayId(JAXBElement<String> value)
    {
        this.prePayId = value;
    }

    /**
     * 获取resultCode属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getResultCode()
    {
        return resultCode;
    }

    /**
     * 设置resultCode属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setResultCode(JAXBElement<String> value)
    {
        this.resultCode = value;
    }

    /**
     * 获取returnCode属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getReturnCode()
    {
        return returnCode;
    }

    /**
     * 设置returnCode属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setReturnCode(JAXBElement<String> value)
    {
        this.returnCode = value;
    }

    /**
     * 获取returnMsg属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getReturnMsg()
    {
        return returnMsg;
    }

    /**
     * 设置returnMsg属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setReturnMsg(JAXBElement<String> value)
    {
        this.returnMsg = value;
    }

    /**
     * 获取sign属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getSign()
    {
        return sign;
    }

    /**
     * 设置sign属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setSign(JAXBElement<String> value)
    {
        this.sign = value;
    }

}
