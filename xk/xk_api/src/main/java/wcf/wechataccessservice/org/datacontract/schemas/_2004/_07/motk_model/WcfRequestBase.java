
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetAuthorizeUrlRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatAccessTokenRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatEncryptRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatPayRequestBase;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatProcessRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatRequestBase;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat.GetMaterialRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat.WechatTransferRequest;


/**
 * <p>WcfRequestBase complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WcfRequestBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}RequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EncodeUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RequestTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WcfRequestBase", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", propOrder = {
    "encodeUserId",
    "requestTag"
})
@XmlSeeAlso({
    GetWeChatAccessTokenRequest.class,
    WeChatProcessRequest.class,
    WeChatPayRequestBase.class,
    WeChatEncryptRequest.class,
    GetAuthorizeUrlRequest.class,
    WeChatRequestBase.class,
    WechatTransferRequest.class,
    GetMaterialRequest.class
})
public class WcfRequestBase
    extends RequestBase
{

    @XmlElementRef(name = "EncodeUserId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", type = JAXBElement.class)
    protected JAXBElement<String> encodeUserId;
    @XmlElementRef(name = "RequestTag", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", type = JAXBElement.class)
    protected JAXBElement<String> requestTag;

    /**
     * 获取encodeUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncodeUserId() {
        return encodeUserId;
    }

    /**
     * 设置encodeUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncodeUserId(JAXBElement<String> value) {
        this.encodeUserId = value;
    }

    /**
     * 获取requestTag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRequestTag() {
        return requestTag;
    }

    /**
     * 设置requestTag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRequestTag(JAXBElement<String> value) {
        this.requestTag = value;
    }

}
