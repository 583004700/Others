
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring;


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
 *         &lt;element name="CreateOrderResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResultOfstring" minOccurs="0"/&gt;
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
    "createOrderResult"
})
@XmlRootElement(name = "CreateOrderResponse")
public class CreateOrderResponse {

    @XmlElementRef(name = "CreateOrderResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResultOfstring> createOrderResult;

    /**
     * 获取createOrderResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}
     *     
     */
    public JAXBElement<ServiceResultOfstring> getCreateOrderResult() {
        return createOrderResult;
    }

    /**
     * 设置createOrderResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}
     *     
     */
    public void setCreateOrderResult(JAXBElement<ServiceResultOfstring> value) {
        this.createOrderResult = value;
    }

}
