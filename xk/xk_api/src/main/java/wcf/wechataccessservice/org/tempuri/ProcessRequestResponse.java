
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatResponseView;


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
 *         &lt;element name="ProcessRequestResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View}WeChatResponseView" minOccurs="0"/&gt;
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
    "processRequestResult"
})
@XmlRootElement(name = "ProcessRequestResponse")
public class ProcessRequestResponse {

    @XmlElementRef(name = "ProcessRequestResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<WeChatResponseView> processRequestResult;

    /**
     * 获取processRequestResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WeChatResponseView }{@code >}
     *     
     */
    public JAXBElement<WeChatResponseView> getProcessRequestResult() {
        return processRequestResult;
    }

    /**
     * 设置processRequestResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WeChatResponseView }{@code >}
     *     
     */
    public void setProcessRequestResult(JAXBElement<WeChatResponseView> value) {
        this.processRequestResult = value;
    }

}
