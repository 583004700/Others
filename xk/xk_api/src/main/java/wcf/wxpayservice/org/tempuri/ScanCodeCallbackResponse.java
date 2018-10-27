
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfScanCodeCallbackResultzDDmiR8T;

/**
 * <p>anonymous complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ScanCodeCallbackResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResultOfScanCodeCallbackResultzDDmiR8T" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"scanCodeCallbackResult"})
@XmlRootElement(name = "ScanCodeCallbackResponse")
public class ScanCodeCallbackResponse
{

    @XmlElementRef(name = "ScanCodeCallbackResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T> scanCodeCallbackResult;

    /**
     * 获取scanCodeCallbackResult属性的值。
     * 
     * @return possible object is {@link JAXBElement
     *         }{@code <}{@link ServiceResultOfScanCodeCallbackResultzDDmiR8T }{@code >}
     */
    public JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T> getScanCodeCallbackResult()
    {
        return scanCodeCallbackResult;
    }

    /**
     * 设置scanCodeCallbackResult属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement
     *            }{@code <}{@link ServiceResultOfScanCodeCallbackResultzDDmiR8T }{@code >}
     */
    public void setScanCodeCallbackResult(JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T> value)
    {
        this.scanCodeCallbackResult = value;
    }

}
