
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderstatusChangeLog;


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
 *         &lt;element name="log" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models}OrderstatusChangeLog" minOccurs="0"/&gt;
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
    "log"
})
@XmlRootElement(name = "AddOrderStatusChangeLog")
public class AddOrderStatusChangeLog {

    @XmlElementRef(name = "log", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<OrderstatusChangeLog> log;

    /**
     * 获取log属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderstatusChangeLog }{@code >}
     *     
     */
    public JAXBElement<OrderstatusChangeLog> getLog() {
        return log;
    }

    /**
     * 设置log属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderstatusChangeLog }{@code >}
     *     
     */
    public void setLog(JAXBElement<OrderstatusChangeLog> value) {
        this.log = value;
    }

}
