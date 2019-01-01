
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.WcfRequestBase;


/**
 * <p>WeChatEncryptRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatEncryptRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}WcfRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EncodingAesKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEncrypt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="XmlMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatEncryptRequest", propOrder = {
    "appId",
    "encodingAesKey",
    "isEncrypt",
    "token",
    "xmlMsg"
})
public class WeChatEncryptRequest
    extends WcfRequestBase
{

    @XmlElementRef(name = "AppId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> appId;
    @XmlElementRef(name = "EncodingAesKey", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> encodingAesKey;
    @XmlElement(name = "IsEncrypt")
    protected Boolean isEncrypt;
    @XmlElementRef(name = "Token", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> token;
    @XmlElementRef(name = "XmlMsg", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> xmlMsg;

    /**
     * 获取appId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppId() {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppId(JAXBElement<String> value) {
        this.appId = value;
    }

    /**
     * 获取encodingAesKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncodingAesKey() {
        return encodingAesKey;
    }

    /**
     * 设置encodingAesKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncodingAesKey(JAXBElement<String> value) {
        this.encodingAesKey = value;
    }

    /**
     * 获取isEncrypt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEncrypt() {
        return isEncrypt;
    }

    /**
     * 设置isEncrypt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEncrypt(Boolean value) {
        this.isEncrypt = value;
    }

    /**
     * 获取token属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToken() {
        return token;
    }

    /**
     * 设置token属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToken(JAXBElement<String> value) {
        this.token = value;
    }

    /**
     * 获取xmlMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getXmlMsg() {
        return xmlMsg;
    }

    /**
     * 设置xmlMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setXmlMsg(JAXBElement<String> value) {
        this.xmlMsg = value;
    }

}