
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfboolean;


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
 *         &lt;element name="SendFreeOrderSuccessEventResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResultOfboolean" minOccurs="0"/&gt;
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
    "sendFreeOrderSuccessEventResult"
})
@XmlRootElement(name = "SendFreeOrderSuccessEventResponse")
public class SendFreeOrderSuccessEventResponse {

    @XmlElementRef(name = "SendFreeOrderSuccessEventResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResultOfboolean> sendFreeOrderSuccessEventResult;

    /**
     * 获取sendFreeOrderSuccessEventResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfboolean }{@code >}
     *     
     */
    public JAXBElement<ServiceResultOfboolean> getSendFreeOrderSuccessEventResult() {
        return sendFreeOrderSuccessEventResult;
    }

    /**
     * 设置sendFreeOrderSuccessEventResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfboolean }{@code >}
     *     
     */
    public void setSendFreeOrderSuccessEventResult(JAXBElement<ServiceResultOfboolean> value) {
        this.sendFreeOrderSuccessEventResult = value;
    }

}
