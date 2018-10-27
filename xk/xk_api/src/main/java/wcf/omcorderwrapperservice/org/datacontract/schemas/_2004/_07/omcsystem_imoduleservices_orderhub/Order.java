
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Order complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Order"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CallBackStatus" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
 *         &lt;element name="IsPayByOther" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OrderCodeUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderCreateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrderCreateUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderExpireDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrderExpireTotalSeconds" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="OrderFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumberStamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderPayCreateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrderStatusTypeId" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
 *         &lt;element name="OrderTotalPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="OrderUpdateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="PayTag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PayUserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PaymentDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMode" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
 *         &lt;element name="PrePayID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Products" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models}ArrayOfOrderProduct" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceOpenID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SalseReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SourcePlantId" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
 *         &lt;element name="TargetUserID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="TradeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
    "callBackStatus",
    "isPayByOther",
    "orderCodeUrl",
    "orderCreateDateTime",
    "orderCreateUserId",
    "orderDes",
    "orderExpireDateTime",
    "orderExpireTotalSeconds",
    "orderFrom",
    "orderID",
    "orderNumber",
    "orderNumberStamp",
    "orderPayCreateDateTime",
    "orderStatusTypeId",
    "orderTotalPrice",
    "orderUpdateDateTime",
    "payTag",
    "payUserId",
    "paymentDateTime",
    "paymentMode",
    "prePayID",
    "products",
    "referenceOpenID",
    "referenceOrderNumber",
    "salseReference",
    "sourcePlantId",
    "targetUserID",
    "tradeType"
})
public class Order {

    @XmlElement(name = "CallBackStatus")
    protected Byte callBackStatus;
    @XmlElement(name = "IsPayByOther")
    protected Boolean isPayByOther;
    @XmlElementRef(name = "OrderCodeUrl", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> orderCodeUrl;
    @XmlElement(name = "OrderCreateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderCreateDateTime;
    @XmlElement(name = "OrderCreateUserId")
    protected Integer orderCreateUserId;
    @XmlElementRef(name = "OrderDes", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> orderDes;
    @XmlElement(name = "OrderExpireDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderExpireDateTime;
    @XmlElement(name = "OrderExpireTotalSeconds")
    protected Double orderExpireTotalSeconds;
    @XmlElement(name = "OrderFrom")
    protected Integer orderFrom;
    @XmlElement(name = "OrderID")
    protected Long orderID;
    @XmlElementRef(name = "OrderNumber", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> orderNumber;
    @XmlElementRef(name = "OrderNumberStamp", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> orderNumberStamp;
    @XmlElementRef(name = "OrderPayCreateDateTime", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> orderPayCreateDateTime;
    @XmlElement(name = "OrderStatusTypeId")
    protected Byte orderStatusTypeId;
    @XmlElementRef(name = "OrderTotalPrice", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> orderTotalPrice;
    @XmlElement(name = "OrderUpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderUpdateDateTime;
    @XmlElement(name = "PayTag")
    protected Integer payTag;
    @XmlElement(name = "PayUserId")
    protected Integer payUserId;
    @XmlElementRef(name = "PaymentDateTime", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> paymentDateTime;
    @XmlElementRef(name = "PaymentMode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<Byte> paymentMode;
    @XmlElementRef(name = "PrePayID", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> prePayID;
    @XmlElementRef(name = "Products", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOrderProduct> products;
    @XmlElementRef(name = "ReferenceOpenID", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> referenceOpenID;
    @XmlElementRef(name = "ReferenceOrderNumber", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> referenceOrderNumber;
    @XmlElementRef(name = "SalseReference", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> salseReference;
    @XmlElement(name = "SourcePlantId")
    protected Byte sourcePlantId;
    @XmlElement(name = "TargetUserID")
    protected Integer targetUserID;
    @XmlElementRef(name = "TradeType", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> tradeType;

    /**
     * 获取callBackStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getCallBackStatus() {
        return callBackStatus;
    }

    /**
     * 设置callBackStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setCallBackStatus(Byte value) {
        this.callBackStatus = value;
    }

    /**
     * 获取isPayByOther属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPayByOther() {
        return isPayByOther;
    }

    /**
     * 设置isPayByOther属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPayByOther(Boolean value) {
        this.isPayByOther = value;
    }

    /**
     * 获取orderCodeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderCodeUrl() {
        return orderCodeUrl;
    }

    /**
     * 设置orderCodeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderCodeUrl(JAXBElement<String> value) {
        this.orderCodeUrl = value;
    }

    /**
     * 获取orderCreateDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderCreateDateTime() {
        return orderCreateDateTime;
    }

    /**
     * 设置orderCreateDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderCreateDateTime(XMLGregorianCalendar value) {
        this.orderCreateDateTime = value;
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
     * 获取orderExpireDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderExpireDateTime() {
        return orderExpireDateTime;
    }

    /**
     * 设置orderExpireDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderExpireDateTime(XMLGregorianCalendar value) {
        this.orderExpireDateTime = value;
    }

    /**
     * 获取orderExpireTotalSeconds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOrderExpireTotalSeconds() {
        return orderExpireTotalSeconds;
    }

    /**
     * 设置orderExpireTotalSeconds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOrderExpireTotalSeconds(Double value) {
        this.orderExpireTotalSeconds = value;
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
     * 获取orderID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderID() {
        return orderID;
    }

    /**
     * 设置orderID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderID(Long value) {
        this.orderID = value;
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
     * 获取orderNumberStamp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNumberStamp() {
        return orderNumberStamp;
    }

    /**
     * 设置orderNumberStamp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNumberStamp(JAXBElement<String> value) {
        this.orderNumberStamp = value;
    }

    /**
     * 获取orderPayCreateDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getOrderPayCreateDateTime() {
        return orderPayCreateDateTime;
    }

    /**
     * 设置orderPayCreateDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setOrderPayCreateDateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.orderPayCreateDateTime = value;
    }

    /**
     * 获取orderStatusTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getOrderStatusTypeId() {
        return orderStatusTypeId;
    }

    /**
     * 设置orderStatusTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setOrderStatusTypeId(Byte value) {
        this.orderStatusTypeId = value;
    }

    /**
     * 获取orderTotalPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getOrderTotalPrice() {
        return orderTotalPrice;
    }

    /**
     * 设置orderTotalPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setOrderTotalPrice(JAXBElement<BigDecimal> value) {
        this.orderTotalPrice = value;
    }

    /**
     * 获取orderUpdateDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderUpdateDateTime() {
        return orderUpdateDateTime;
    }

    /**
     * 设置orderUpdateDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderUpdateDateTime(XMLGregorianCalendar value) {
        this.orderUpdateDateTime = value;
    }

    /**
     * 获取payTag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPayTag() {
        return payTag;
    }

    /**
     * 设置payTag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPayTag(Integer value) {
        this.payTag = value;
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
     * 获取paymentDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getPaymentDateTime() {
        return paymentDateTime;
    }

    /**
     * 设置paymentDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setPaymentDateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.paymentDateTime = value;
    }

    /**
     * 获取paymentMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Byte }{@code >}
     *     
     */
    public JAXBElement<Byte> getPaymentMode() {
        return paymentMode;
    }

    /**
     * 设置paymentMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Byte }{@code >}
     *     
     */
    public void setPaymentMode(JAXBElement<Byte> value) {
        this.paymentMode = value;
    }

    /**
     * 获取prePayID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrePayID() {
        return prePayID;
    }

    /**
     * 设置prePayID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrePayID(JAXBElement<String> value) {
        this.prePayID = value;
    }

    /**
     * 获取products属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderProduct }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOrderProduct> getProducts() {
        return products;
    }

    /**
     * 设置products属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderProduct }{@code >}
     *     
     */
    public void setProducts(JAXBElement<ArrayOfOrderProduct> value) {
        this.products = value;
    }

    /**
     * 获取referenceOpenID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReferenceOpenID() {
        return referenceOpenID;
    }

    /**
     * 设置referenceOpenID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReferenceOpenID(JAXBElement<String> value) {
        this.referenceOpenID = value;
    }

    /**
     * 获取referenceOrderNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReferenceOrderNumber() {
        return referenceOrderNumber;
    }

    /**
     * 设置referenceOrderNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReferenceOrderNumber(JAXBElement<String> value) {
        this.referenceOrderNumber = value;
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
     * 获取sourcePlantId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getSourcePlantId() {
        return sourcePlantId;
    }

    /**
     * 设置sourcePlantId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setSourcePlantId(Byte value) {
        this.sourcePlantId = value;
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
     * 获取tradeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTradeType() {
        return tradeType;
    }

    /**
     * 设置tradeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTradeType(JAXBElement<String> value) {
        this.tradeType = value;
    }

}
