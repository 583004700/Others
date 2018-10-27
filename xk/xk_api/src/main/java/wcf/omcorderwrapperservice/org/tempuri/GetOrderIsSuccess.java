
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.QueryOrderParamSection;


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
 *         &lt;element name="queryOrder" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model}QueryOrderParamSection" minOccurs="0"/&gt;
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
    "queryOrder"
})
@XmlRootElement(name = "GetOrderIsSuccess")
public class GetOrderIsSuccess {

    @XmlElementRef(name = "queryOrder", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<QueryOrderParamSection> queryOrder;

    /**
     * 获取queryOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QueryOrderParamSection }{@code >}
     *     
     */
    public JAXBElement<QueryOrderParamSection> getQueryOrder() {
        return queryOrder;
    }

    /**
     * 设置queryOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QueryOrderParamSection }{@code >}
     *     
     */
    public void setQueryOrder(JAXBElement<QueryOrderParamSection> value) {
        this.queryOrder = value;
    }

}
