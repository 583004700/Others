
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetWeChatAuthorizationInfoRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetWeChatAuthorizationInfoRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request}WeChatRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppSecret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GrantType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetWeChatAuthorizationInfoRequest", propOrder = {
    "appKey",
    "appSecret",
    "code",
    "grantType"
})
public class GetWeChatAuthorizationInfoRequest
    extends WeChatRequestBase
{

    @XmlElementRef(name = "AppKey", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> appKey;
    @XmlElementRef(name = "AppSecret", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> appSecret;
    @XmlElementRef(name = "Code", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> code;
    @XmlElementRef(name = "GrantType", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> grantType;

    /**
     * 获取appKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppKey() {
        return appKey;
    }

    /**
     * 设置appKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppKey(JAXBElement<String> value) {
        this.appKey = value;
    }

    /**
     * 获取appSecret属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppSecret() {
        return appSecret;
    }

    /**
     * 设置appSecret属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppSecret(JAXBElement<String> value) {
        this.appSecret = value;
    }

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCode(JAXBElement<String> value) {
        this.code = value;
    }

    /**
     * 获取grantType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGrantType() {
        return grantType;
    }

    /**
     * 设置grantType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGrantType(JAXBElement<String> value) {
        this.grantType = value;
    }

}
