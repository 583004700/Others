
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PayMode;


/**
 * <p>OrderPayTrade complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OrderPayTrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PayMode" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}PayMode" minOccurs="0"/&gt;
 *         &lt;element name="PayUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="TradingType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderPayTrade", propOrder = {
    "orderNumber",
    "payMode",
    "payUserId",
    "tradingType"
})
public class OrderPayTrade {

    @XmlElementRef(name = "OrderNumber", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> orderNumber;
    @XmlElement(name = "PayMode")
    @XmlSchemaType(name = "string")
    protected PayMode payMode;
    @XmlElement(name = "PayUserId")
    protected Integer payUserId;
    @XmlElement(name = "TradingType")
    protected Integer tradingType;

    /**
     * 获取orderNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置orderNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNumber(JAXBElement<String> value) {
        this.orderNumber = value;
    }

    /**
     * 获取payMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayMode }
     *     
     */
    public PayMode getPayMode() {
        return payMode;
    }

    /**
     * 设置payMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayMode }
     *     
     */
    public void setPayMode(PayMode value) {
        this.payMode = value;
    }

    /**
     * 获取payUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPayUserId() {
        return payUserId;
    }

    /**
     * 设置payUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPayUserId(Integer value) {
        this.payUserId = value;
    }

    /**
     * 获取tradingType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTradingType() {
        return tradingType;
    }

    /**
     * 设置tradingType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTradingType(Integer value) {
        this.tradingType = value;
    }

}
