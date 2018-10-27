
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPayJsApiRequestzDDmiR8T;


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
 *         &lt;element name="GetJsApiParametersResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResultOfPayJsApiRequestzDDmiR8T" minOccurs="0"/&gt;
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
    "getJsApiParametersResult"
})
@XmlRootElement(name = "GetJsApiParametersResponse")
public class GetJsApiParametersResponse {

    @XmlElementRef(name = "GetJsApiParametersResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T> getJsApiParametersResult;

    /**
     * 获取getJsApiParametersResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfPayJsApiRequestzDDmiR8T }{@code >}
     *     
     */
    public JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T> getGetJsApiParametersResult() {
        return getJsApiParametersResult;
    }

    /**
     * 设置getJsApiParametersResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResultOfPayJsApiRequestzDDmiR8T }{@code >}
     *     
     */
    public void setGetJsApiParametersResult(JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T> value) {
        this.getJsApiParametersResult = value;
    }

}
