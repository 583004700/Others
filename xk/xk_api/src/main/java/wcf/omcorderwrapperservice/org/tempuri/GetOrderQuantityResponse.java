
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe;


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
 *         &lt;element name="GetOrderQuantityResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResultOfArrayOfOrderStatusQuantitydN_PiHdpe" minOccurs="0"/&gt;
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
    "getOrderQuantityResult"
})
@XmlRootElement(name = "GetOrderQuantityResponse")
public class GetOrderQuantityResponse {

    @XmlElementRef(name = "GetOrderQuantityResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe> getOrderQuantityResult;

    /**
     * 获取getOrderQuantityResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe }{@code >}
     *     
     */
    public JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe> getGetOrderQuantityResult() {
        return getOrderQuantityResult;
    }

    /**
     * 设置getOrderQuantityResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe }{@code >}
     *     
     */
    public void setGetOrderQuantityResult(JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe> value) {
        this.getOrderQuantityResult = value;
    }

}
