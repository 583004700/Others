
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PayMode;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TradeTypeEnum;


/**
 * <p>OrderSection complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OrderSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClientId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OpenID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderCreateUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderTotalPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="PaymentingMode" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}PayMode" minOccurs="0"/&gt;
 *         &lt;element name="ProductInfos" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model}ArrayOfOrderProductSection" minOccurs="0"/&gt;
 *         &lt;element name="SalseReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SourcePlantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SourcePlantId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SpbillCreateIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TargetUserID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "OrderSection", propOrder = {
    "clientId",
    "openID",
    "orderCreateUserId",
    "orderDes",
    "orderTotalPrice",
    "paymentingMode",
    "productInfos",
    "salseReference",
    "sourcePlantCode",
    "sourcePlantId",
    "spbillCreateIp",
    "targetUserID",
    "tradingType"
})
public class OrderSection {

    @XmlElement(name = "ClientId")
    protected Integer clientId;
    @XmlElementRef(name = "OpenID", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> openID;
    @XmlElement(name = "OrderCreateUserId")
    protected Integer orderCreateUserId;
    @XmlElementRef(name = "OrderDes", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> orderDes;
    @XmlElement(name = "OrderTotalPrice")
    protected BigDecimal orderTotalPrice;
    @XmlElementRef(name = "PaymentingMode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<PayMode> paymentingMode;
    @XmlElementRef(name = "ProductInfos", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOrderProductSection> productInfos;
    @XmlElementRef(name = "SalseReference", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> salseReference;
    @XmlElementRef(name = "SourcePlantCode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> sourcePlantCode;
    @XmlElement(name = "SourcePlantId")
    protected Integer sourcePlantId;
    @XmlElementRef(name = "SpbillCreateIp", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<String> spbillCreateIp;
    @XmlElement(name = "TargetUserID")
    protected Integer targetUserID;
    @XmlElementRef(name = "TradingType", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", type = JAXBElement.class)
    protected JAXBElement<TradeTypeEnum> tradingType;

    /**
     * 获取clientId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * 设置clientId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClientId(Integer value) {
        this.clientId = value;
    }

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
     * 获取orderCreateUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderCreateUserId() {
        return orderCreateUserId;
    }

    /**
     * 设置orderCreateUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderCreateUserId(Integer value) {
        this.orderCreateUserId = value;
    }

    /**
     * 获取orderDes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderDes() {
        return orderDes;
    }

    /**
     * 设置orderDes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderDes(JAXBElement<String> value) {
        this.orderDes = value;
    }

    /**
     * 获取orderTotalPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    /**
     * 设置orderTotalPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderTotalPrice(BigDecimal value) {
        this.orderTotalPrice = value;
    }

    /**
     * 获取paymentingMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PayMode }{@code >}
     *     
     */
    public JAXBElement<PayMode> getPaymentingMode() {
        return paymentingMode;
    }

    /**
     * 设置paymentingMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PayMode }{@code >}
     *     
     */
    public void setPaymentingMode(JAXBElement<PayMode> value) {
        this.paymentingMode = value;
    }

    /**
     * 获取productInfos属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderProductSection }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOrderProductSection> getProductInfos() {
        return productInfos;
    }

    /**
     * 设置productInfos属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderProductSection }{@code >}
     *     
     */
    public void setProductInfos(JAXBElement<ArrayOfOrderProductSection> value) {
        this.productInfos = value;
    }

    /**
     * 获取salseReference属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSalseReference() {
        return salseReference;
    }

    /**
     * 设置salseReference属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalseReference(JAXBElement<String> value) {
        this.salseReference = value;
    }

    /**
     * 获取sourcePlantCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourcePlantCode() {
        return sourcePlantCode;
    }

    /**
     * 设置sourcePlantCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourcePlantCode(JAXBElement<String> value) {
        this.sourcePlantCode = value;
    }

    /**
     * 获取sourcePlantId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourcePlantId() {
        return sourcePlantId;
    }

    /**
     * 设置sourcePlantId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourcePlantId(Integer value) {
        this.sourcePlantId = value;
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
     * 获取targetUserID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTargetUserID() {
        return targetUserID;
    }

    /**
     * 设置targetUserID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTargetUserID(Integer value) {
        this.targetUserID = value;
    }

    /**
     * 获取tradingType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TradeTypeEnum }{@code >}
     *     
     */
    public JAXBElement<TradeTypeEnum> getTradingType() {
        return tradingType;
    }

    /**
     * 设置tradingType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TradeTypeEnum }{@code >}
     *     
     */
    public void setTradingType(JAXBElement<TradeTypeEnum> value) {
        this.tradingType = value;
    }

}
