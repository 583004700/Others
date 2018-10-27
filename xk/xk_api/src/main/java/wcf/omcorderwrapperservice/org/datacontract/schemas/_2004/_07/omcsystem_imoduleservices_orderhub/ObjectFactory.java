
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TransactionType;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrderPayResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderPayResult");
    private final static QName _QueryOrdersParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "QueryOrdersParam");
    private final static QName _ArrayOfOrder_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ArrayOfOrder");
    private final static QName _Order_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "Order");
    private final static QName _ArrayOfOrderProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ArrayOfOrderProduct");
    private final static QName _OrderProduct_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderProduct");
    private final static QName _QueryOrderQuantityParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "QueryOrderQuantityParam");
    private final static QName _ArrayOfOrderStatusQuantity_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ArrayOfOrderStatusQuantity");
    private final static QName _OrderStatusQuantity_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderStatusQuantity");
    private final static QName _OrderstatusChangeLog_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderstatusChangeLog");
    private final static QName _ArrayOfOrderPayMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ArrayOfOrderPayMode");
    private final static QName _OrderPayMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderPayMode");
    private final static QName _OrderFilterParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderFilterParam");
    private final static QName _OrderPayModeDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "Description");
    private final static QName _OrderPayModePayModeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "PayModeName");
    private final static QName _OrderProductProductInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ProductInfo");
    private final static QName _OrderProductProductName_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ProductName");
    private final static QName _OrderProductProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ProductNumber");
    private final static QName _OrderProductProductPicture_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ProductPicture");
    private final static QName _OrderOrderCodeUrl_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderCodeUrl");
    private final static QName _OrderOrderDes_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderDes");
    private final static QName _OrderOrderNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderNumber");
    private final static QName _OrderOrderNumberStamp_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderNumberStamp");
    private final static QName _OrderOrderPayCreateDateTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderPayCreateDateTime");
    private final static QName _OrderOrderTotalPrice_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderTotalPrice");
    private final static QName _OrderPaymentDateTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "PaymentDateTime");
    private final static QName _OrderPaymentMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "PaymentMode");
    private final static QName _OrderPrePayID_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "PrePayID");
    private final static QName _OrderProducts_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "Products");
    private final static QName _OrderReferenceOpenID_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ReferenceOpenID");
    private final static QName _OrderReferenceOrderNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ReferenceOrderNumber");
    private final static QName _OrderSalseReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "SalseReference");
    private final static QName _OrderTradeType_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "TradeType");
    private final static QName _OrderFilterParamBeginTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "BeginTime");
    private final static QName _OrderFilterParamEndTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "EndTime");
    private final static QName _OrderFilterParamSourcePlantCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "SourcePlantCode");
    private final static QName _OrderFilterParamUserIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "UserIds");
    private final static QName _OrderstatusChangeLogErrorCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ErrorCode");
    private final static QName _OrderstatusChangeLogErrorMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ErrorMessage");
    private final static QName _QueryOrderQuantityParamOrderStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderStatus");
    private final static QName _QueryOrderQuantityParamProductGroupIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "ProductGroupIds");
    private final static QName _QueryOrdersParamOrderStatusTypeID_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", "OrderStatusTypeID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryOrdersParam }
     * 
     */
    public QueryOrdersParam createQueryOrdersParam() {
        return new QueryOrdersParam();
    }

    /**
     * Create an instance of {@link QueryOrderQuantityParam }
     * 
     */
    public QueryOrderQuantityParam createQueryOrderQuantityParam() {
        return new QueryOrderQuantityParam();
    }

    /**
     * Create an instance of {@link OrderstatusChangeLog }
     * 
     */
    public OrderstatusChangeLog createOrderstatusChangeLog() {
        return new OrderstatusChangeLog();
    }

    /**
     * Create an instance of {@link OrderFilterParam }
     * 
     */
    public OrderFilterParam createOrderFilterParam() {
        return new OrderFilterParam();
    }

    /**
     * Create an instance of {@link OrderPayResult }
     * 
     */
    public OrderPayResult createOrderPayResult() {
        return new OrderPayResult();
    }

    /**
     * Create an instance of {@link ArrayOfOrder }
     * 
     */
    public ArrayOfOrder createArrayOfOrder() {
        return new ArrayOfOrder();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link ArrayOfOrderProduct }
     * 
     */
    public ArrayOfOrderProduct createArrayOfOrderProduct() {
        return new ArrayOfOrderProduct();
    }

    /**
     * Create an instance of {@link OrderProduct }
     * 
     */
    public OrderProduct createOrderProduct() {
        return new OrderProduct();
    }

    /**
     * Create an instance of {@link ArrayOfOrderStatusQuantity }
     * 
     */
    public ArrayOfOrderStatusQuantity createArrayOfOrderStatusQuantity() {
        return new ArrayOfOrderStatusQuantity();
    }

    /**
     * Create an instance of {@link OrderStatusQuantity }
     * 
     */
    public OrderStatusQuantity createOrderStatusQuantity() {
        return new OrderStatusQuantity();
    }

    /**
     * Create an instance of {@link ArrayOfOrderPayMode }
     * 
     */
    public ArrayOfOrderPayMode createArrayOfOrderPayMode() {
        return new ArrayOfOrderPayMode();
    }

    /**
     * Create an instance of {@link OrderPayMode }
     * 
     */
    public OrderPayMode createOrderPayMode() {
        return new OrderPayMode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPayResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderPayResult")
    public JAXBElement<OrderPayResult> createOrderPayResult(OrderPayResult value) {
        return new JAXBElement<OrderPayResult>(_OrderPayResult_QNAME, OrderPayResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrdersParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "QueryOrdersParam")
    public JAXBElement<QueryOrdersParam> createQueryOrdersParam(QueryOrdersParam value) {
        return new JAXBElement<QueryOrdersParam>(_QueryOrdersParam_QNAME, QueryOrdersParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ArrayOfOrder")
    public JAXBElement<ArrayOfOrder> createArrayOfOrder(ArrayOfOrder value) {
        return new JAXBElement<ArrayOfOrder>(_ArrayOfOrder_QNAME, ArrayOfOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "Order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ArrayOfOrderProduct")
    public JAXBElement<ArrayOfOrderProduct> createArrayOfOrderProduct(ArrayOfOrderProduct value) {
        return new JAXBElement<ArrayOfOrderProduct>(_ArrayOfOrderProduct_QNAME, ArrayOfOrderProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderProduct")
    public JAXBElement<OrderProduct> createOrderProduct(OrderProduct value) {
        return new JAXBElement<OrderProduct>(_OrderProduct_QNAME, OrderProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrderQuantityParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "QueryOrderQuantityParam")
    public JAXBElement<QueryOrderQuantityParam> createQueryOrderQuantityParam(QueryOrderQuantityParam value) {
        return new JAXBElement<QueryOrderQuantityParam>(_QueryOrderQuantityParam_QNAME, QueryOrderQuantityParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderStatusQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ArrayOfOrderStatusQuantity")
    public JAXBElement<ArrayOfOrderStatusQuantity> createArrayOfOrderStatusQuantity(ArrayOfOrderStatusQuantity value) {
        return new JAXBElement<ArrayOfOrderStatusQuantity>(_ArrayOfOrderStatusQuantity_QNAME, ArrayOfOrderStatusQuantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderStatusQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderStatusQuantity")
    public JAXBElement<OrderStatusQuantity> createOrderStatusQuantity(OrderStatusQuantity value) {
        return new JAXBElement<OrderStatusQuantity>(_OrderStatusQuantity_QNAME, OrderStatusQuantity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderstatusChangeLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderstatusChangeLog")
    public JAXBElement<OrderstatusChangeLog> createOrderstatusChangeLog(OrderstatusChangeLog value) {
        return new JAXBElement<OrderstatusChangeLog>(_OrderstatusChangeLog_QNAME, OrderstatusChangeLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderPayMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ArrayOfOrderPayMode")
    public JAXBElement<ArrayOfOrderPayMode> createArrayOfOrderPayMode(ArrayOfOrderPayMode value) {
        return new JAXBElement<ArrayOfOrderPayMode>(_ArrayOfOrderPayMode_QNAME, ArrayOfOrderPayMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPayMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderPayMode")
    public JAXBElement<OrderPayMode> createOrderPayMode(OrderPayMode value) {
        return new JAXBElement<OrderPayMode>(_OrderPayMode_QNAME, OrderPayMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderFilterParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderFilterParam")
    public JAXBElement<OrderFilterParam> createOrderFilterParam(OrderFilterParam value) {
        return new JAXBElement<OrderFilterParam>(_OrderFilterParam_QNAME, OrderFilterParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "Description", scope = OrderPayMode.class)
    public JAXBElement<String> createOrderPayModeDescription(String value) {
        return new JAXBElement<String>(_OrderPayModeDescription_QNAME, String.class, OrderPayMode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "PayModeName", scope = OrderPayMode.class)
    public JAXBElement<String> createOrderPayModePayModeName(String value) {
        return new JAXBElement<String>(_OrderPayModePayModeName_QNAME, String.class, OrderPayMode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductInfo", scope = OrderProduct.class)
    public JAXBElement<String> createOrderProductProductInfo(String value) {
        return new JAXBElement<String>(_OrderProductProductInfo_QNAME, String.class, OrderProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductName", scope = OrderProduct.class)
    public JAXBElement<String> createOrderProductProductName(String value) {
        return new JAXBElement<String>(_OrderProductProductName_QNAME, String.class, OrderProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductNumber", scope = OrderProduct.class)
    public JAXBElement<String> createOrderProductProductNumber(String value) {
        return new JAXBElement<String>(_OrderProductProductNumber_QNAME, String.class, OrderProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductPicture", scope = OrderProduct.class)
    public JAXBElement<String> createOrderProductProductPicture(String value) {
        return new JAXBElement<String>(_OrderProductProductPicture_QNAME, String.class, OrderProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderCodeUrl", scope = Order.class)
    public JAXBElement<String> createOrderOrderCodeUrl(String value) {
        return new JAXBElement<String>(_OrderOrderCodeUrl_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderDes", scope = Order.class)
    public JAXBElement<String> createOrderOrderDes(String value) {
        return new JAXBElement<String>(_OrderOrderDes_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderNumber", scope = Order.class)
    public JAXBElement<String> createOrderOrderNumber(String value) {
        return new JAXBElement<String>(_OrderOrderNumber_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderNumberStamp", scope = Order.class)
    public JAXBElement<String> createOrderOrderNumberStamp(String value) {
        return new JAXBElement<String>(_OrderOrderNumberStamp_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderPayCreateDateTime", scope = Order.class)
    public JAXBElement<XMLGregorianCalendar> createOrderOrderPayCreateDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OrderOrderPayCreateDateTime_QNAME, XMLGregorianCalendar.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderTotalPrice", scope = Order.class)
    public JAXBElement<BigDecimal> createOrderOrderTotalPrice(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OrderOrderTotalPrice_QNAME, BigDecimal.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "PaymentDateTime", scope = Order.class)
    public JAXBElement<XMLGregorianCalendar> createOrderPaymentDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OrderPaymentDateTime_QNAME, XMLGregorianCalendar.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "PaymentMode", scope = Order.class)
    public JAXBElement<Byte> createOrderPaymentMode(Byte value) {
        return new JAXBElement<Byte>(_OrderPaymentMode_QNAME, Byte.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "PrePayID", scope = Order.class)
    public JAXBElement<String> createOrderPrePayID(String value) {
        return new JAXBElement<String>(_OrderPrePayID_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "Products", scope = Order.class)
    public JAXBElement<ArrayOfOrderProduct> createOrderProducts(ArrayOfOrderProduct value) {
        return new JAXBElement<ArrayOfOrderProduct>(_OrderProducts_QNAME, ArrayOfOrderProduct.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ReferenceOpenID", scope = Order.class)
    public JAXBElement<String> createOrderReferenceOpenID(String value) {
        return new JAXBElement<String>(_OrderReferenceOpenID_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ReferenceOrderNumber", scope = Order.class)
    public JAXBElement<String> createOrderReferenceOrderNumber(String value) {
        return new JAXBElement<String>(_OrderReferenceOrderNumber_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "SalseReference", scope = Order.class)
    public JAXBElement<String> createOrderSalseReference(String value) {
        return new JAXBElement<String>(_OrderSalseReference_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "TradeType", scope = Order.class)
    public JAXBElement<String> createOrderTradeType(String value) {
        return new JAXBElement<String>(_OrderTradeType_QNAME, String.class, Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderNumber", scope = OrderPayResult.class)
    public JAXBElement<String> createOrderPayResultOrderNumber(String value) {
        return new JAXBElement<String>(_OrderOrderNumber_QNAME, String.class, OrderPayResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "BeginTime", scope = OrderFilterParam.class)
    public JAXBElement<XMLGregorianCalendar> createOrderFilterParamBeginTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OrderFilterParamBeginTime_QNAME, XMLGregorianCalendar.class, OrderFilterParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "EndTime", scope = OrderFilterParam.class)
    public JAXBElement<XMLGregorianCalendar> createOrderFilterParamEndTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OrderFilterParamEndTime_QNAME, XMLGregorianCalendar.class, OrderFilterParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductName", scope = OrderFilterParam.class)
    public JAXBElement<String> createOrderFilterParamProductName(String value) {
        return new JAXBElement<String>(_OrderProductProductName_QNAME, String.class, OrderFilterParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "SourcePlantCode", scope = OrderFilterParam.class)
    public JAXBElement<String> createOrderFilterParamSourcePlantCode(String value) {
        return new JAXBElement<String>(_OrderFilterParamSourcePlantCode_QNAME, String.class, OrderFilterParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "UserIds", scope = OrderFilterParam.class)
    public JAXBElement<ArrayOfint> createOrderFilterParamUserIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_OrderFilterParamUserIds_QNAME, ArrayOfint.class, OrderFilterParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ErrorCode", scope = OrderstatusChangeLog.class)
    public JAXBElement<String> createOrderstatusChangeLogErrorCode(String value) {
        return new JAXBElement<String>(_OrderstatusChangeLogErrorCode_QNAME, String.class, OrderstatusChangeLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ErrorMessage", scope = OrderstatusChangeLog.class)
    public JAXBElement<String> createOrderstatusChangeLogErrorMessage(String value) {
        return new JAXBElement<String>(_OrderstatusChangeLogErrorMessage_QNAME, String.class, OrderstatusChangeLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderStatus", scope = QueryOrderQuantityParam.class)
    public JAXBElement<ArrayOfint> createQueryOrderQuantityParamOrderStatus(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QueryOrderQuantityParamOrderStatus_QNAME, ArrayOfint.class, QueryOrderQuantityParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductGroupIds", scope = QueryOrderQuantityParam.class)
    public JAXBElement<ArrayOfint> createQueryOrderQuantityParamProductGroupIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QueryOrderQuantityParamProductGroupIds_QNAME, ArrayOfint.class, QueryOrderQuantityParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "OrderStatusTypeID", scope = QueryOrdersParam.class)
    public JAXBElement<TransactionType> createQueryOrdersParamOrderStatusTypeID(TransactionType value) {
        return new JAXBElement<TransactionType>(_QueryOrdersParamOrderStatusTypeID_QNAME, TransactionType.class, QueryOrdersParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "ProductGroupIds", scope = QueryOrdersParam.class)
    public JAXBElement<ArrayOfint> createQueryOrdersParamProductGroupIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QueryOrderQuantityParamProductGroupIds_QNAME, ArrayOfint.class, QueryOrdersParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", name = "SourcePlantCode", scope = QueryOrdersParam.class)
    public JAXBElement<String> createQueryOrdersParamSourcePlantCode(String value) {
        return new JAXBElement<String>(_OrderFilterParamSourcePlantCode_QNAME, String.class, QueryOrdersParam.class, value);
    }

}
