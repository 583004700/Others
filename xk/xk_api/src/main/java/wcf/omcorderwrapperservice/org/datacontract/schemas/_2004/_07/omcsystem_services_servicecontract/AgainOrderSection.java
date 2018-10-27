
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PayMode;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TradeTypeEnum;


/**
 * <p>AgainOrderSection complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AgainOrderSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OpenID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PayUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PaymentingMode" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}PayMode" minOccurs="0"/&gt;
 *         &lt;element name="SpbillCreateIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TradingType" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}TradeTypeEnum" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgainOrderSection", propOrder = {
    "openID",
    "orderFrom",
    "orderNumber",
    "payUserId",
    "paymentingMode",
    "spbillCreateIp",
    "tradingType"
})
public class AgainOrderSection {

    @XmlElementRef(name = "OpenID", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> openID;
    @XmlElement(name = "OrderFrom")
    protected Integer orderFrom;
    @XmlElementRef(name = "OrderNumber", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> orderNumber;
    @XmlElement(name = "PayUserId")
    protected Integer payUserId;
    @XmlElement(name = "PaymentingMode")
    @XmlSchemaType(name = "string")
    protected PayMode paymentingMode;
    @XmlElementRef(name = "SpbillCreateIp", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> spbillCreateIp;
    @XmlElement(name = "TradingType")
    @XmlSchemaType(name = "string")
    protected TradeTypeEnum tradingType;

    /**
     * 获取openID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOpenID() {
        return openID;
    }

    /**
     * 设置openID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpenID(JAXBElement<String> value) {
        this.openID = value;
    }

    /**
     * 获取orderFrom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderFrom() {
        return orderFrom;
    }

    /**
     * 设置orderFrom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderFrom(Integer value) {
        this.orderFrom = value;
    }

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
     * 获取paymentingMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayMode }
     *     
     */
    public PayMode getPaymentingMode() {
        return paymentingMode;
    }

    /**
     * 设置paymentingMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayMode }
     *     
     */
    public void setPaymentingMode(PayMode value) {
        this.paymentingMode = value;
    }

    /**
     * 获取spbillCreateIp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpbillCreateIp() {
        return spbillCreateIp;
    }

    /**
     * 设置spbillCreateIp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpbillCreateIp(JAXBElement<String> value) {
        this.spbillCreateIp = value;
    }

    /**
     * 获取tradingType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TradeTypeEnum }
     *     
     */
    public TradeTypeEnum getTradingType() {
        return tradingType;
    }

    /**
     * 设置tradingType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TradeTypeEnum }
     *     
     */
    public void setTradingType(TradeTypeEnum value) {
        this.tradingType = value;
    }

}
