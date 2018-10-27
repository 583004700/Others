
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SendWeChatTextMessageRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SendWeChatTextMessageRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request}WeChatRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OpenId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendWeChatTextMessageRequest", propOrder = {
    "openId",
    "text"
})
public class SendWeChatTextMessageRequest
    extends WeChatRequestBase
{

    @XmlElementRef(name = "OpenId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> openId;
    @XmlElementRef(name = "Text", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request", type = JAXBElement.class)
    protected JAXBElement<String> text;

    /**
     * 获取openId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOpenId() {
        return openId;
    }

    /**
     * 设置openId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpenId(JAXBElement<String> value) {
        this.openId = value;
    }

    /**
     * 获取text属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getText() {
        return text;
    }

    /**
     * 设置text属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setText(JAXBElement<String> value) {
        this.text = value;
    }

}
