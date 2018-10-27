
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>PayJsApiRequest complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PayJsApiRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Appkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NonceStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Package" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaySign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SignType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayJsApiRequest", propOrder = {"appId", "appkey", "nonceStr", "_package", "paySign", "signType", "timeStamp"})
public class PayJsApiRequest
{

    @XmlElementRef(name = "AppId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> appId;

    @XmlElementRef(name = "Appkey", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> appkey;

    @XmlElementRef(name = "NonceStr", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> nonceStr;

    @XmlElementRef(name = "Package", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> _package;

    @XmlElementRef(name = "PaySign", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> paySign;

    @XmlElementRef(name = "SignType", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> signType;

    @XmlElementRef(name = "TimeStamp", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> timeStamp;

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
     * 获取appkey属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getAppkey()
    {
        return appkey;
    }

    /**
     * 设置appkey属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setAppkey(JAXBElement<String> value)
    {
        this.appkey = value;
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
     * 获取package属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getPackage()
    {
        return _package;
    }

    /**
     * 设置package属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setPackage(JAXBElement<String> value)
    {
        this._package = value;
    }

    /**
     * 获取paySign属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getPaySign()
    {
        return paySign;
    }

    /**
     * 设置paySign属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setPaySign(JAXBElement<String> value)
    {
        this.paySign = value;
    }

    /**
     * 获取signType属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getSignType()
    {
        return signType;
    }

    /**
     * 设置signType属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setSignType(JAXBElement<String> value)
    {
        this.signType = value;
    }

    /**
     * 获取timeStamp属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getTimeStamp()
    {
        return timeStamp;
    }

    /**
     * 设置timeStamp属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setTimeStamp(JAXBElement<String> value)
    {
        this.timeStamp = value;
    }

}
