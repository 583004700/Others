
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatTicketInfoView;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetWeChatTicketResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View}WeChatTicketInfoView" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getWeChatTicketResult"
})
@XmlRootElement(name = "GetWeChatTicketResponse")
public class GetWeChatTicketResponse {

    @XmlElementRef(name = "GetWeChatTicketResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<WeChatTicketInfoView> getWeChatTicketResult;

    /**
     * 获取getWeChatTicketResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WeChatTicketInfoView }{@code >}
     *     
     */
    public JAXBElement<WeChatTicketInfoView> getGetWeChatTicketResult() {
        return getWeChatTicketResult;
    }

    /**
     * 设置getWeChatTicketResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WeChatTicketInfoView }{@code >}
     *     
     */
    public void setGetWeChatTicketResult(JAXBElement<WeChatTicketInfoView> value) {
        this.getWeChatTicketResult = value;
    }

}
