
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ScanCodeCallbackParam complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ScanCodeCallbackParam"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsSubscribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NonceStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OpenId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProductId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScanCodeCallbackParam", propOrder = {"appId", "clientId", "ipAddress", "isSubscribe", "mchId", "nonceStr", "openId", "productId", "sign"})
public class ScanCodeCallbackParam
{

    @XmlElementRef(name = "AppId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> appId;

    @XmlElementRef(name = "ClientId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> clientId;

    @XmlElementRef(name = "IpAddress", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> ipAddress;

    @XmlElementRef(name = "IsSubscribe", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> isSubscribe;

    @XmlElementRef(name = "MchId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> mchId;

    @XmlElementRef(name = "NonceStr", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> nonceStr;

    @XmlElementRef(name = "OpenId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> openId;

    @XmlElementRef(name = "ProductId", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> productId;

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
     * 获取clientId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getClientId()
    {
        return clientId;
    }

    /**
     * 设置clientId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setClientId(JAXBElement<String> value)
    {
        this.clientId = value;
    }

    /**
     * 获取ipAddress属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getIpAddress()
    {
        return ipAddress;
    }

    /**
     * 设置ipAddress属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setIpAddress(JAXBElement<String> value)
    {
        this.ipAddress = value;
    }

    /**
     * 获取isSubscribe属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getIsSubscribe()
    {
        return isSubscribe;
    }

    /**
     * 设置isSubscribe属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setIsSubscribe(JAXBElement<String> value)
    {
        this.isSubscribe = value;
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
     * 获取openId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getOpenId()
    {
        return openId;
    }

    /**
     * 设置openId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setOpenId(JAXBElement<String> value)
    {
        this.openId = value;
    }

    /**
     * 获取productId属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getProductId()
    {
        return productId;
    }

    /**
     * 设置productId属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setProductId(JAXBElement<String> value)
    {
        this.productId = value;
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
