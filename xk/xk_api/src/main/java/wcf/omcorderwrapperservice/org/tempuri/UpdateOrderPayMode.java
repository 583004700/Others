
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderPayTrade;


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
 *         &lt;element name="orderPayTrade" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model}OrderPayTrade" minOccurs="0"/&gt;
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
    "orderPayTrade"
})
@XmlRootElement(name = "UpdateOrderPayMode")
public class UpdateOrderPayMode {

    @XmlElementRef(name = "orderPayTrade", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<OrderPayTrade> orderPayTrade;

    /**
     * 获取orderPayTrade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderPayTrade }{@code >}
     *     
     */
    public JAXBElement<OrderPayTrade> getOrderPayTrade() {
        return orderPayTrade;
    }

    /**
     * 设置orderPayTrade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderPayTrade }{@code >}
     *     
     */
    public void setOrderPayTrade(JAXBElement<OrderPayTrade> value) {
        this.orderPayTrade = value;
    }

}
