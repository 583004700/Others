
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PayMode;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TradeTypeEnum;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.omcsystem_services_servicecontract package. 
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

    private final static QName _OrderSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OrderSection");
    private final static QName _ArrayOfOrderProductSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ArrayOfOrderProductSection");
    private final static QName _OrderProductSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OrderProductSection");
    private final static QName _AgainOrderSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "AgainOrderSection");
    private final static QName _QueryOrderParamSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "QueryOrderParamSection");
    private final static QName _OrderPayTrade_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OrderPayTrade");
    private final static QName _OrderProductSectionProductInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ProductInfo");
    private final static QName _OrderProductSectionProductName_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ProductName");
    private final static QName _OrderProductSectionProductNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ProductNumber");
    private final static QName _OrderProductSectionProductPicture_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ProductPicture");
    private final static QName _OrderPayTradeOrderNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OrderNumber");
    private final static QName _AgainOrderSectionOpenID_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OpenID");
    private final static QName _AgainOrderSectionSpbillCreateIp_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "SpbillCreateIp");
    private final static QName _OrderSectionOrderDes_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "OrderDes");
    private final static QName _OrderSectionPaymentingMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "PaymentingMode");
    private final static QName _OrderSectionProductInfos_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "ProductInfos");
    private final static QName _OrderSectionSalseReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "SalseReference");
    private final static QName _OrderSectionSourcePlantCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "SourcePlantCode");
    private final static QName _OrderSectionTradingType_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", "TradingType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.omcsystem_services_servicecontract
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderSection }
     * 
     */
    public OrderSection createOrderSection() {
        return new OrderSection();
    }

    /**
     * Create an instance of {@link AgainOrderSection }
     * 
     */
    public AgainOrderSection createAgainOrderSection() {
        return new AgainOrderSection();
    }

    /**
     * Create an instance of {@link QueryOrderParamSection }
     * 
     */
    public QueryOrderParamSection createQueryOrderParamSection() {
        return new QueryOrderParamSection();
    }

    /**
     * Create an instance of {@link OrderPayTrade }
     * 
     */
    public OrderPayTrade createOrderPayTrade() {
        return new OrderPayTrade();
    }

    /**
     * Create an instance of {@link ArrayOfOrderProductSection }
     * 
     */
    public ArrayOfOrderProductSection createArrayOfOrderProductSection() {
        return new ArrayOfOrderProductSection();
    }

    /**
     * Create an instance of {@link OrderProductSection }
     * 
     */
    public OrderProductSection createOrderProductSection() {
        return new OrderProductSection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderSection")
    public JAXBElement<OrderSection> createOrderSection(OrderSection value) {
        return new JAXBElement<OrderSection>(_OrderSection_QNAME, OrderSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderProductSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ArrayOfOrderProductSection")
    public JAXBElement<ArrayOfOrderProductSection> createArrayOfOrderProductSection(ArrayOfOrderProductSection value) {
        return new JAXBElement<ArrayOfOrderProductSection>(_ArrayOfOrderProductSection_QNAME, ArrayOfOrderProductSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderProductSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderProductSection")
    public JAXBElement<OrderProductSection> createOrderProductSection(OrderProductSection value) {
        return new JAXBElement<OrderProductSection>(_OrderProductSection_QNAME, OrderProductSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgainOrderSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "AgainOrderSection")
    public JAXBElement<AgainOrderSection> createAgainOrderSection(AgainOrderSection value) {
        return new JAXBElement<AgainOrderSection>(_AgainOrderSection_QNAME, AgainOrderSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrderParamSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "QueryOrderParamSection")
    public JAXBElement<QueryOrderParamSection> createQueryOrderParamSection(QueryOrderParamSection value) {
        return new JAXBElement<QueryOrderParamSection>(_QueryOrderParamSection_QNAME, QueryOrderParamSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPayTrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderPayTrade")
    public JAXBElement<OrderPayTrade> createOrderPayTrade(OrderPayTrade value) {
        return new JAXBElement<OrderPayTrade>(_OrderPayTrade_QNAME, OrderPayTrade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ProductInfo", scope = OrderProductSection.class)
    public JAXBElement<String> createOrderProductSectionProductInfo(String value) {
        return new JAXBElement<String>(_OrderProductSectionProductInfo_QNAME, String.class, OrderProductSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ProductName", scope = OrderProductSection.class)
    public JAXBElement<String> createOrderProductSectionProductName(String value) {
        return new JAXBElement<String>(_OrderProductSectionProductName_QNAME, String.class, OrderProductSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ProductNumber", scope = OrderProductSection.class)
    public JAXBElement<String> createOrderProductSectionProductNumber(String value) {
        return new JAXBElement<String>(_OrderProductSectionProductNumber_QNAME, String.class, OrderProductSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ProductPicture", scope = OrderProductSection.class)
    public JAXBElement<String> createOrderProductSectionProductPicture(String value) {
        return new JAXBElement<String>(_OrderProductSectionProductPicture_QNAME, String.class, OrderProductSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderNumber", scope = OrderPayTrade.class)
    public JAXBElement<String> createOrderPayTradeOrderNumber(String value) {
        return new JAXBElement<String>(_OrderPayTradeOrderNumber_QNAME, String.class, OrderPayTrade.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderNumber", scope = QueryOrderParamSection.class)
    public JAXBElement<String> createQueryOrderParamSectionOrderNumber(String value) {
        return new JAXBElement<String>(_OrderPayTradeOrderNumber_QNAME, String.class, QueryOrderParamSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OpenID", scope = AgainOrderSection.class)
    public JAXBElement<String> createAgainOrderSectionOpenID(String value) {
        return new JAXBElement<String>(_AgainOrderSectionOpenID_QNAME, String.class, AgainOrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderNumber", scope = AgainOrderSection.class)
    public JAXBElement<String> createAgainOrderSectionOrderNumber(String value) {
        return new JAXBElement<String>(_OrderPayTradeOrderNumber_QNAME, String.class, AgainOrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "SpbillCreateIp", scope = AgainOrderSection.class)
    public JAXBElement<String> createAgainOrderSectionSpbillCreateIp(String value) {
        return new JAXBElement<String>(_AgainOrderSectionSpbillCreateIp_QNAME, String.class, AgainOrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OpenID", scope = OrderSection.class)
    public JAXBElement<String> createOrderSectionOpenID(String value) {
        return new JAXBElement<String>(_AgainOrderSectionOpenID_QNAME, String.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "OrderDes", scope = OrderSection.class)
    public JAXBElement<String> createOrderSectionOrderDes(String value) {
        return new JAXBElement<String>(_OrderSectionOrderDes_QNAME, String.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "PaymentingMode", scope = OrderSection.class)
    public JAXBElement<PayMode> createOrderSectionPaymentingMode(PayMode value) {
        return new JAXBElement<PayMode>(_OrderSectionPaymentingMode_QNAME, PayMode.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderProductSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "ProductInfos", scope = OrderSection.class)
    public JAXBElement<ArrayOfOrderProductSection> createOrderSectionProductInfos(ArrayOfOrderProductSection value) {
        return new JAXBElement<ArrayOfOrderProductSection>(_OrderSectionProductInfos_QNAME, ArrayOfOrderProductSection.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "SalseReference", scope = OrderSection.class)
    public JAXBElement<String> createOrderSectionSalseReference(String value) {
        return new JAXBElement<String>(_OrderSectionSalseReference_QNAME, String.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "SourcePlantCode", scope = OrderSection.class)
    public JAXBElement<String> createOrderSectionSourcePlantCode(String value) {
        return new JAXBElement<String>(_OrderSectionSourcePlantCode_QNAME, String.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "SpbillCreateIp", scope = OrderSection.class)
    public JAXBElement<String> createOrderSectionSpbillCreateIp(String value) {
        return new JAXBElement<String>(_AgainOrderSectionSpbillCreateIp_QNAME, String.class, OrderSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TradeTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model", name = "TradingType", scope = OrderSection.class)
    public JAXBElement<TradeTypeEnum> createOrderSectionTradingType(TradeTypeEnum value) {
        return new JAXBElement<TradeTypeEnum>(_OrderSectionTradingType_QNAME, TradeTypeEnum.class, OrderSection.class, value);
    }

}
