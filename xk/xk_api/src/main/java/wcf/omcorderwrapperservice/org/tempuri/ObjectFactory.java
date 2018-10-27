
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfArrayOfOrderPayModedNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderPayResultdNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPageOfOrderdNPiHdpem06JEnuP;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfTransactionType5Y56Hjij;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfboolean;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderFilterParam;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderstatusChangeLog;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.QueryOrderQuantityParam;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.QueryOrdersParam;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.ChangeOrderStatusRequest;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.CheckProductExistsOrderRequest;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.CloseOrderRequest;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.GetOrderPayUrlRequest;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.GetProductOrderNumberRequest;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.AgainOrderSection;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderPayTrade;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderSection;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.QueryOrderParamSection;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _CreateOrderOrderSection_QNAME = new QName("http://tempuri.org/", "orderSection");
    private final static QName _CreateOrderResponseCreateOrderResult_QNAME = new QName("http://tempuri.org/", "CreateOrderResult");
    private final static QName _CreateOmcOrderResponseCreateOmcOrderResult_QNAME = new QName("http://tempuri.org/", "CreateOmcOrderResult");
    private final static QName _AgainCreateOrderResponseAgainCreateOrderResult_QNAME = new QName("http://tempuri.org/", "AgainCreateOrderResult");
    private final static QName _GetOrdersByQueryParamsPParams_QNAME = new QName("http://tempuri.org/", "pParams");
    private final static QName _GetOrdersByQueryParamsResponseGetOrdersByQueryParamsResult_QNAME = new QName("http://tempuri.org/", "GetOrdersByQueryParamsResult");
    private final static QName _GetOrderByNumberOrderNumber_QNAME = new QName("http://tempuri.org/", "orderNumber");
    private final static QName _GetOrderByNumberResponseGetOrderByNumberResult_QNAME = new QName("http://tempuri.org/", "GetOrderByNumberResult");
    private final static QName _GetOrderByIdResponseGetOrderByIdResult_QNAME = new QName("http://tempuri.org/", "GetOrderByIdResult");
    private final static QName _GetOrderQuantityParam_QNAME = new QName("http://tempuri.org/", "param");
    private final static QName _GetOrderQuantityResponseGetOrderQuantityResult_QNAME = new QName("http://tempuri.org/", "GetOrderQuantityResult");
    private final static QName _NoticeCallBackSuccessResponseNoticeCallBackSuccessResult_QNAME = new QName("http://tempuri.org/", "NoticeCallBackSuccessResult");
    private final static QName _CloseExpireOrderResponseCloseExpireOrderResult_QNAME = new QName("http://tempuri.org/", "CloseExpireOrderResult");
    private final static QName _AddOrderStatusChangeLogLog_QNAME = new QName("http://tempuri.org/", "log");
    private final static QName _AddOrderStatusChangeLogResponseAddOrderStatusChangeLogResult_QNAME = new QName("http://tempuri.org/", "AddOrderStatusChangeLogResult");
    private final static QName _GetOrderIsSuccessQueryOrder_QNAME = new QName("http://tempuri.org/", "queryOrder");
    private final static QName _GetOrderIsSuccessResponseGetOrderIsSuccessResult_QNAME = new QName("http://tempuri.org/", "GetOrderIsSuccessResult");
    private final static QName _GetOrderInfoByNumberResponseGetOrderInfoByNumberResult_QNAME = new QName("http://tempuri.org/", "GetOrderInfoByNumberResult");
    private final static QName _NoticeOrderFailureResponseNoticeOrderFailureResult_QNAME = new QName("http://tempuri.org/", "NoticeOrderFailureResult");
    private final static QName _NoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult_QNAME = new QName("http://tempuri.org/", "NoticeOrderTradeSuccessResult");
    private final static QName _ChangeStatusRequest_QNAME = new QName("http://tempuri.org/", "request");
    private final static QName _CheckProductExistsOrderResponseCheckProductExistsOrderResult_QNAME = new QName("http://tempuri.org/", "CheckProductExistsOrderResult");
    private final static QName _GetOrderScanCodePayUrlResponseGetOrderScanCodePayUrlResult_QNAME = new QName("http://tempuri.org/", "GetOrderScanCodePayUrlResult");
    private final static QName _GetOrderScanCodePayShortUrlResponseGetOrderScanCodePayShortUrlResult_QNAME = new QName("http://tempuri.org/", "GetOrderScanCodePayShortUrlResult");
    private final static QName _GetOrderPayModeResponseGetOrderPayModeResult_QNAME = new QName("http://tempuri.org/", "GetOrderPayModeResult");
    private final static QName _CloseOrderResponseCloseOrderResult_QNAME = new QName("http://tempuri.org/", "CloseOrderResult");
    private final static QName _UpdateOrderPayUserIdResponseUpdateOrderPayUserIdResult_QNAME = new QName("http://tempuri.org/", "UpdateOrderPayUserIdResult");
    private final static QName _GetProductOrderNumberResponseGetProductOrderNumberResult_QNAME = new QName("http://tempuri.org/", "GetProductOrderNumberResult");
    private final static QName _SendFreeOrderSuccessEventOrderNo_QNAME = new QName("http://tempuri.org/", "orderNo");
    private final static QName _SendFreeOrderSuccessEventResponseSendFreeOrderSuccessEventResult_QNAME = new QName("http://tempuri.org/", "SendFreeOrderSuccessEventResult");
    private final static QName _GetOrdersByFilterParamsOParams_QNAME = new QName("http://tempuri.org/", "oParams");
    private final static QName _GetOrdersByFilterParamsResponseGetOrdersByFilterParamsResult_QNAME = new QName("http://tempuri.org/", "GetOrdersByFilterParamsResult");
    private final static QName _UpdateOrderPayModeOrderPayTrade_QNAME = new QName("http://tempuri.org/", "orderPayTrade");
    private final static QName _UpdateOrderPayModeResponseUpdateOrderPayModeResult_QNAME = new QName("http://tempuri.org/", "UpdateOrderPayModeResult");
    private final static QName _GetExistsOrderByProductResponseGetExistsOrderByProductResult_QNAME = new QName("http://tempuri.org/", "GetExistsOrderByProductResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link CreateOmcOrder }
     * 
     */
    public CreateOmcOrder createCreateOmcOrder() {
        return new CreateOmcOrder();
    }

    /**
     * Create an instance of {@link CreateOmcOrderResponse }
     * 
     */
    public CreateOmcOrderResponse createCreateOmcOrderResponse() {
        return new CreateOmcOrderResponse();
    }

    /**
     * Create an instance of {@link AgainCreateOrder }
     * 
     */
    public AgainCreateOrder createAgainCreateOrder() {
        return new AgainCreateOrder();
    }

    /**
     * Create an instance of {@link AgainCreateOrderResponse }
     * 
     */
    public AgainCreateOrderResponse createAgainCreateOrderResponse() {
        return new AgainCreateOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrdersByQueryParams }
     * 
     */
    public GetOrdersByQueryParams createGetOrdersByQueryParams() {
        return new GetOrdersByQueryParams();
    }

    /**
     * Create an instance of {@link GetOrdersByQueryParamsResponse }
     * 
     */
    public GetOrdersByQueryParamsResponse createGetOrdersByQueryParamsResponse() {
        return new GetOrdersByQueryParamsResponse();
    }

    /**
     * Create an instance of {@link GetOrderByNumber }
     * 
     */
    public GetOrderByNumber createGetOrderByNumber() {
        return new GetOrderByNumber();
    }

    /**
     * Create an instance of {@link GetOrderByNumberResponse }
     * 
     */
    public GetOrderByNumberResponse createGetOrderByNumberResponse() {
        return new GetOrderByNumberResponse();
    }

    /**
     * Create an instance of {@link GetOrderById }
     * 
     */
    public GetOrderById createGetOrderById() {
        return new GetOrderById();
    }

    /**
     * Create an instance of {@link GetOrderByIdResponse }
     * 
     */
    public GetOrderByIdResponse createGetOrderByIdResponse() {
        return new GetOrderByIdResponse();
    }

    /**
     * Create an instance of {@link GetOrderQuantity }
     * 
     */
    public GetOrderQuantity createGetOrderQuantity() {
        return new GetOrderQuantity();
    }

    /**
     * Create an instance of {@link GetOrderQuantityResponse }
     * 
     */
    public GetOrderQuantityResponse createGetOrderQuantityResponse() {
        return new GetOrderQuantityResponse();
    }

    /**
     * Create an instance of {@link NoticeCallBackSuccess }
     * 
     */
    public NoticeCallBackSuccess createNoticeCallBackSuccess() {
        return new NoticeCallBackSuccess();
    }

    /**
     * Create an instance of {@link NoticeCallBackSuccessResponse }
     * 
     */
    public NoticeCallBackSuccessResponse createNoticeCallBackSuccessResponse() {
        return new NoticeCallBackSuccessResponse();
    }

    /**
     * Create an instance of {@link CloseExpireOrder }
     * 
     */
    public CloseExpireOrder createCloseExpireOrder() {
        return new CloseExpireOrder();
    }

    /**
     * Create an instance of {@link CloseExpireOrderResponse }
     * 
     */
    public CloseExpireOrderResponse createCloseExpireOrderResponse() {
        return new CloseExpireOrderResponse();
    }

    /**
     * Create an instance of {@link AddOrderStatusChangeLog }
     * 
     */
    public AddOrderStatusChangeLog createAddOrderStatusChangeLog() {
        return new AddOrderStatusChangeLog();
    }

    /**
     * Create an instance of {@link AddOrderStatusChangeLogResponse }
     * 
     */
    public AddOrderStatusChangeLogResponse createAddOrderStatusChangeLogResponse() {
        return new AddOrderStatusChangeLogResponse();
    }

    /**
     * Create an instance of {@link GetOrderIsSuccess }
     * 
     */
    public GetOrderIsSuccess createGetOrderIsSuccess() {
        return new GetOrderIsSuccess();
    }

    /**
     * Create an instance of {@link GetOrderIsSuccessResponse }
     * 
     */
    public GetOrderIsSuccessResponse createGetOrderIsSuccessResponse() {
        return new GetOrderIsSuccessResponse();
    }

    /**
     * Create an instance of {@link GetOrderInfoByNumber }
     * 
     */
    public GetOrderInfoByNumber createGetOrderInfoByNumber() {
        return new GetOrderInfoByNumber();
    }

    /**
     * Create an instance of {@link GetOrderInfoByNumberResponse }
     * 
     */
    public GetOrderInfoByNumberResponse createGetOrderInfoByNumberResponse() {
        return new GetOrderInfoByNumberResponse();
    }

    /**
     * Create an instance of {@link NoticeOrderFailure }
     * 
     */
    public NoticeOrderFailure createNoticeOrderFailure() {
        return new NoticeOrderFailure();
    }

    /**
     * Create an instance of {@link NoticeOrderFailureResponse }
     * 
     */
    public NoticeOrderFailureResponse createNoticeOrderFailureResponse() {
        return new NoticeOrderFailureResponse();
    }

    /**
     * Create an instance of {@link NoticeOrderTradeSuccess }
     * 
     */
    public NoticeOrderTradeSuccess createNoticeOrderTradeSuccess() {
        return new NoticeOrderTradeSuccess();
    }

    /**
     * Create an instance of {@link NoticeOrderTradeSuccessResponse }
     * 
     */
    public NoticeOrderTradeSuccessResponse createNoticeOrderTradeSuccessResponse() {
        return new NoticeOrderTradeSuccessResponse();
    }

    /**
     * Create an instance of {@link ChangeStatus }
     * 
     */
    public ChangeStatus createChangeStatus() {
        return new ChangeStatus();
    }

    /**
     * Create an instance of {@link ChangeStatusResponse }
     * 
     */
    public ChangeStatusResponse createChangeStatusResponse() {
        return new ChangeStatusResponse();
    }

    /**
     * Create an instance of {@link CheckProductExistsOrder }
     * 
     */
    public CheckProductExistsOrder createCheckProductExistsOrder() {
        return new CheckProductExistsOrder();
    }

    /**
     * Create an instance of {@link CheckProductExistsOrderResponse }
     * 
     */
    public CheckProductExistsOrderResponse createCheckProductExistsOrderResponse() {
        return new CheckProductExistsOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrderScanCodePayUrl }
     * 
     */
    public GetOrderScanCodePayUrl createGetOrderScanCodePayUrl() {
        return new GetOrderScanCodePayUrl();
    }

    /**
     * Create an instance of {@link GetOrderScanCodePayUrlResponse }
     * 
     */
    public GetOrderScanCodePayUrlResponse createGetOrderScanCodePayUrlResponse() {
        return new GetOrderScanCodePayUrlResponse();
    }

    /**
     * Create an instance of {@link GetOrderScanCodePayShortUrl }
     * 
     */
    public GetOrderScanCodePayShortUrl createGetOrderScanCodePayShortUrl() {
        return new GetOrderScanCodePayShortUrl();
    }

    /**
     * Create an instance of {@link GetOrderScanCodePayShortUrlResponse }
     * 
     */
    public GetOrderScanCodePayShortUrlResponse createGetOrderScanCodePayShortUrlResponse() {
        return new GetOrderScanCodePayShortUrlResponse();
    }

    /**
     * Create an instance of {@link GetOrderPayMode }
     * 
     */
    public GetOrderPayMode createGetOrderPayMode() {
        return new GetOrderPayMode();
    }

    /**
     * Create an instance of {@link GetOrderPayModeResponse }
     * 
     */
    public GetOrderPayModeResponse createGetOrderPayModeResponse() {
        return new GetOrderPayModeResponse();
    }

    /**
     * Create an instance of {@link CloseOrder }
     * 
     */
    public CloseOrder createCloseOrder() {
        return new CloseOrder();
    }

    /**
     * Create an instance of {@link CloseOrderResponse }
     * 
     */
    public CloseOrderResponse createCloseOrderResponse() {
        return new CloseOrderResponse();
    }

    /**
     * Create an instance of {@link UpdateOrderPayUserId }
     * 
     */
    public UpdateOrderPayUserId createUpdateOrderPayUserId() {
        return new UpdateOrderPayUserId();
    }

    /**
     * Create an instance of {@link UpdateOrderPayUserIdResponse }
     * 
     */
    public UpdateOrderPayUserIdResponse createUpdateOrderPayUserIdResponse() {
        return new UpdateOrderPayUserIdResponse();
    }

    /**
     * Create an instance of {@link GetProductOrderNumber }
     * 
     */
    public GetProductOrderNumber createGetProductOrderNumber() {
        return new GetProductOrderNumber();
    }

    /**
     * Create an instance of {@link GetProductOrderNumberResponse }
     * 
     */
    public GetProductOrderNumberResponse createGetProductOrderNumberResponse() {
        return new GetProductOrderNumberResponse();
    }

    /**
     * Create an instance of {@link SendFreeOrderSuccessEvent }
     * 
     */
    public SendFreeOrderSuccessEvent createSendFreeOrderSuccessEvent() {
        return new SendFreeOrderSuccessEvent();
    }

    /**
     * Create an instance of {@link SendFreeOrderSuccessEventResponse }
     * 
     */
    public SendFreeOrderSuccessEventResponse createSendFreeOrderSuccessEventResponse() {
        return new SendFreeOrderSuccessEventResponse();
    }

    /**
     * Create an instance of {@link GetOrdersByFilterParams }
     * 
     */
    public GetOrdersByFilterParams createGetOrdersByFilterParams() {
        return new GetOrdersByFilterParams();
    }

    /**
     * Create an instance of {@link GetOrdersByFilterParamsResponse }
     * 
     */
    public GetOrdersByFilterParamsResponse createGetOrdersByFilterParamsResponse() {
        return new GetOrdersByFilterParamsResponse();
    }

    /**
     * Create an instance of {@link UpdateOrderPayMode }
     * 
     */
    public UpdateOrderPayMode createUpdateOrderPayMode() {
        return new UpdateOrderPayMode();
    }

    /**
     * Create an instance of {@link UpdateOrderPayModeResponse }
     * 
     */
    public UpdateOrderPayModeResponse createUpdateOrderPayModeResponse() {
        return new UpdateOrderPayModeResponse();
    }

    /**
     * Create an instance of {@link GetExistsOrderByProduct }
     * 
     */
    public GetExistsOrderByProduct createGetExistsOrderByProduct() {
        return new GetExistsOrderByProduct();
    }

    /**
     * Create an instance of {@link GetExistsOrderByProductResponse }
     * 
     */
    public GetExistsOrderByProductResponse createGetExistsOrderByProductResponse() {
        return new GetExistsOrderByProductResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderSection", scope = CreateOrder.class)
    public JAXBElement<OrderSection> createCreateOrderOrderSection(OrderSection value) {
        return new JAXBElement<OrderSection>(_CreateOrderOrderSection_QNAME, OrderSection.class, CreateOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreateOrderResult", scope = CreateOrderResponse.class)
    public JAXBElement<ServiceResultOfstring> createCreateOrderResponseCreateOrderResult(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_CreateOrderResponseCreateOrderResult_QNAME, ServiceResultOfstring.class, CreateOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderSection", scope = CreateOmcOrder.class)
    public JAXBElement<OrderSection> createCreateOmcOrderOrderSection(OrderSection value) {
        return new JAXBElement<OrderSection>(_CreateOrderOrderSection_QNAME, OrderSection.class, CreateOmcOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreateOmcOrderResult", scope = CreateOmcOrderResponse.class)
    public JAXBElement<ServiceResultOfstring> createCreateOmcOrderResponseCreateOmcOrderResult(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_CreateOmcOrderResponseCreateOmcOrderResult_QNAME, ServiceResultOfstring.class, CreateOmcOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgainOrderSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderSection", scope = AgainCreateOrder.class)
    public JAXBElement<AgainOrderSection> createAgainCreateOrderOrderSection(AgainOrderSection value) {
        return new JAXBElement<AgainOrderSection>(_CreateOrderOrderSection_QNAME, AgainOrderSection.class, AgainCreateOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderPayResultdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AgainCreateOrderResult", scope = AgainCreateOrderResponse.class)
    public JAXBElement<ServiceResultOfOrderPayResultdNPiHdpe> createAgainCreateOrderResponseAgainCreateOrderResult(ServiceResultOfOrderPayResultdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderPayResultdNPiHdpe>(_AgainCreateOrderResponseAgainCreateOrderResult_QNAME, ServiceResultOfOrderPayResultdNPiHdpe.class, AgainCreateOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrdersParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "pParams", scope = GetOrdersByQueryParams.class)
    public JAXBElement<QueryOrdersParam> createGetOrdersByQueryParamsPParams(QueryOrdersParam value) {
        return new JAXBElement<QueryOrdersParam>(_GetOrdersByQueryParamsPParams_QNAME, QueryOrdersParam.class, GetOrdersByQueryParams.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfPageOfOrderdNPiHdpem06JEnuP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrdersByQueryParamsResult", scope = GetOrdersByQueryParamsResponse.class)
    public JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP> createGetOrdersByQueryParamsResponseGetOrdersByQueryParamsResult(ServiceResultOfPageOfOrderdNPiHdpem06JEnuP value) {
        return new JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP>(_GetOrdersByQueryParamsResponseGetOrdersByQueryParamsResult_QNAME, ServiceResultOfPageOfOrderdNPiHdpem06JEnuP.class, GetOrdersByQueryParamsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = GetOrderByNumber.class)
    public JAXBElement<String> createGetOrderByNumberOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, GetOrderByNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderByNumberResult", scope = GetOrderByNumberResponse.class)
    public JAXBElement<ServiceResultOfOrderdNPiHdpe> createGetOrderByNumberResponseGetOrderByNumberResult(ServiceResultOfOrderdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderdNPiHdpe>(_GetOrderByNumberResponseGetOrderByNumberResult_QNAME, ServiceResultOfOrderdNPiHdpe.class, GetOrderByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderByIdResult", scope = GetOrderByIdResponse.class)
    public JAXBElement<ServiceResultOfOrderdNPiHdpe> createGetOrderByIdResponseGetOrderByIdResult(ServiceResultOfOrderdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderdNPiHdpe>(_GetOrderByIdResponseGetOrderByIdResult_QNAME, ServiceResultOfOrderdNPiHdpe.class, GetOrderByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrderQuantityParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "param", scope = GetOrderQuantity.class)
    public JAXBElement<QueryOrderQuantityParam> createGetOrderQuantityParam(QueryOrderQuantityParam value) {
        return new JAXBElement<QueryOrderQuantityParam>(_GetOrderQuantityParam_QNAME, QueryOrderQuantityParam.class, GetOrderQuantity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderQuantityResult", scope = GetOrderQuantityResponse.class)
    public JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe> createGetOrderQuantityResponseGetOrderQuantityResult(ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe value) {
        return new JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe>(_GetOrderQuantityResponseGetOrderQuantityResult_QNAME, ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe.class, GetOrderQuantityResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = NoticeCallBackSuccess.class)
    public JAXBElement<String> createNoticeCallBackSuccessOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, NoticeCallBackSuccess.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NoticeCallBackSuccessResult", scope = NoticeCallBackSuccessResponse.class)
    public JAXBElement<ServiceResult> createNoticeCallBackSuccessResponseNoticeCallBackSuccessResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_NoticeCallBackSuccessResponseNoticeCallBackSuccessResult_QNAME, ServiceResult.class, NoticeCallBackSuccessResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CloseExpireOrderResult", scope = CloseExpireOrderResponse.class)
    public JAXBElement<ServiceResult> createCloseExpireOrderResponseCloseExpireOrderResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_CloseExpireOrderResponseCloseExpireOrderResult_QNAME, ServiceResult.class, CloseExpireOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderstatusChangeLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "log", scope = AddOrderStatusChangeLog.class)
    public JAXBElement<OrderstatusChangeLog> createAddOrderStatusChangeLogLog(OrderstatusChangeLog value) {
        return new JAXBElement<OrderstatusChangeLog>(_AddOrderStatusChangeLogLog_QNAME, OrderstatusChangeLog.class, AddOrderStatusChangeLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AddOrderStatusChangeLogResult", scope = AddOrderStatusChangeLogResponse.class)
    public JAXBElement<ServiceResult> createAddOrderStatusChangeLogResponseAddOrderStatusChangeLogResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_AddOrderStatusChangeLogResponseAddOrderStatusChangeLogResult_QNAME, ServiceResult.class, AddOrderStatusChangeLogResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrderParamSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "queryOrder", scope = GetOrderIsSuccess.class)
    public JAXBElement<QueryOrderParamSection> createGetOrderIsSuccessQueryOrder(QueryOrderParamSection value) {
        return new JAXBElement<QueryOrderParamSection>(_GetOrderIsSuccessQueryOrder_QNAME, QueryOrderParamSection.class, GetOrderIsSuccess.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfTransactionType5Y56Hjij }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderIsSuccessResult", scope = GetOrderIsSuccessResponse.class)
    public JAXBElement<ServiceResultOfTransactionType5Y56Hjij> createGetOrderIsSuccessResponseGetOrderIsSuccessResult(ServiceResultOfTransactionType5Y56Hjij value) {
        return new JAXBElement<ServiceResultOfTransactionType5Y56Hjij>(_GetOrderIsSuccessResponseGetOrderIsSuccessResult_QNAME, ServiceResultOfTransactionType5Y56Hjij.class, GetOrderIsSuccessResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = GetOrderInfoByNumber.class)
    public JAXBElement<String> createGetOrderInfoByNumberOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, GetOrderInfoByNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderInfoByNumberResult", scope = GetOrderInfoByNumberResponse.class)
    public JAXBElement<ServiceResultOfOrderdNPiHdpe> createGetOrderInfoByNumberResponseGetOrderInfoByNumberResult(ServiceResultOfOrderdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderdNPiHdpe>(_GetOrderInfoByNumberResponseGetOrderInfoByNumberResult_QNAME, ServiceResultOfOrderdNPiHdpe.class, GetOrderInfoByNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = NoticeOrderFailure.class)
    public JAXBElement<String> createNoticeOrderFailureOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, NoticeOrderFailure.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NoticeOrderFailureResult", scope = NoticeOrderFailureResponse.class)
    public JAXBElement<ServiceResult> createNoticeOrderFailureResponseNoticeOrderFailureResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_NoticeOrderFailureResponseNoticeOrderFailureResult_QNAME, ServiceResult.class, NoticeOrderFailureResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = NoticeOrderTradeSuccess.class)
    public JAXBElement<String> createNoticeOrderTradeSuccessOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, NoticeOrderTradeSuccess.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NoticeOrderTradeSuccessResult", scope = NoticeOrderTradeSuccessResponse.class)
    public JAXBElement<ServiceResult> createNoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_NoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult_QNAME, ServiceResult.class, NoticeOrderTradeSuccessResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrderStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = ChangeStatus.class)
    public JAXBElement<ChangeOrderStatusRequest> createChangeStatusRequest(ChangeOrderStatusRequest value) {
        return new JAXBElement<ChangeOrderStatusRequest>(_ChangeStatusRequest_QNAME, ChangeOrderStatusRequest.class, ChangeStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckProductExistsOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = CheckProductExistsOrder.class)
    public JAXBElement<CheckProductExistsOrderRequest> createCheckProductExistsOrderRequest(CheckProductExistsOrderRequest value) {
        return new JAXBElement<CheckProductExistsOrderRequest>(_ChangeStatusRequest_QNAME, CheckProductExistsOrderRequest.class, CheckProductExistsOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckProductExistsOrderResult", scope = CheckProductExistsOrderResponse.class)
    public JAXBElement<ServiceResultOfboolean> createCheckProductExistsOrderResponseCheckProductExistsOrderResult(ServiceResultOfboolean value) {
        return new JAXBElement<ServiceResultOfboolean>(_CheckProductExistsOrderResponseCheckProductExistsOrderResult_QNAME, ServiceResultOfboolean.class, CheckProductExistsOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderPayUrlRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetOrderScanCodePayUrl.class)
    public JAXBElement<GetOrderPayUrlRequest> createGetOrderScanCodePayUrlRequest(GetOrderPayUrlRequest value) {
        return new JAXBElement<GetOrderPayUrlRequest>(_ChangeStatusRequest_QNAME, GetOrderPayUrlRequest.class, GetOrderScanCodePayUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderScanCodePayUrlResult", scope = GetOrderScanCodePayUrlResponse.class)
    public JAXBElement<ServiceResultOfstring> createGetOrderScanCodePayUrlResponseGetOrderScanCodePayUrlResult(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_GetOrderScanCodePayUrlResponseGetOrderScanCodePayUrlResult_QNAME, ServiceResultOfstring.class, GetOrderScanCodePayUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderPayUrlRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetOrderScanCodePayShortUrl.class)
    public JAXBElement<GetOrderPayUrlRequest> createGetOrderScanCodePayShortUrlRequest(GetOrderPayUrlRequest value) {
        return new JAXBElement<GetOrderPayUrlRequest>(_ChangeStatusRequest_QNAME, GetOrderPayUrlRequest.class, GetOrderScanCodePayShortUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderScanCodePayShortUrlResult", scope = GetOrderScanCodePayShortUrlResponse.class)
    public JAXBElement<ServiceResultOfstring> createGetOrderScanCodePayShortUrlResponseGetOrderScanCodePayShortUrlResult(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_GetOrderScanCodePayShortUrlResponseGetOrderScanCodePayShortUrlResult_QNAME, ServiceResultOfstring.class, GetOrderScanCodePayShortUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderPayModedNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderPayModeResult", scope = GetOrderPayModeResponse.class)
    public JAXBElement<ServiceResultOfArrayOfOrderPayModedNPiHdpe> createGetOrderPayModeResponseGetOrderPayModeResult(ServiceResultOfArrayOfOrderPayModedNPiHdpe value) {
        return new JAXBElement<ServiceResultOfArrayOfOrderPayModedNPiHdpe>(_GetOrderPayModeResponseGetOrderPayModeResult_QNAME, ServiceResultOfArrayOfOrderPayModedNPiHdpe.class, GetOrderPayModeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "param", scope = CloseOrder.class)
    public JAXBElement<CloseOrderRequest> createCloseOrderParam(CloseOrderRequest value) {
        return new JAXBElement<CloseOrderRequest>(_GetOrderQuantityParam_QNAME, CloseOrderRequest.class, CloseOrder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CloseOrderResult", scope = CloseOrderResponse.class)
    public JAXBElement<ServiceResult> createCloseOrderResponseCloseOrderResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_CloseOrderResponseCloseOrderResult_QNAME, ServiceResult.class, CloseOrderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = UpdateOrderPayUserId.class)
    public JAXBElement<String> createUpdateOrderPayUserIdOrderNumber(String value) {
        return new JAXBElement<String>(_GetOrderByNumberOrderNumber_QNAME, String.class, UpdateOrderPayUserId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdateOrderPayUserIdResult", scope = UpdateOrderPayUserIdResponse.class)
    public JAXBElement<ServiceResult> createUpdateOrderPayUserIdResponseUpdateOrderPayUserIdResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_UpdateOrderPayUserIdResponseUpdateOrderPayUserIdResult_QNAME, ServiceResult.class, UpdateOrderPayUserIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductOrderNumberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetProductOrderNumber.class)
    public JAXBElement<GetProductOrderNumberRequest> createGetProductOrderNumberRequest(GetProductOrderNumberRequest value) {
        return new JAXBElement<GetProductOrderNumberRequest>(_ChangeStatusRequest_QNAME, GetProductOrderNumberRequest.class, GetProductOrderNumber.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProductOrderNumberResult", scope = GetProductOrderNumberResponse.class)
    public JAXBElement<ServiceResultOfstring> createGetProductOrderNumberResponseGetProductOrderNumberResult(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_GetProductOrderNumberResponseGetProductOrderNumberResult_QNAME, ServiceResultOfstring.class, GetProductOrderNumberResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNo", scope = SendFreeOrderSuccessEvent.class)
    public JAXBElement<String> createSendFreeOrderSuccessEventOrderNo(String value) {
        return new JAXBElement<String>(_SendFreeOrderSuccessEventOrderNo_QNAME, String.class, SendFreeOrderSuccessEvent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendFreeOrderSuccessEventResult", scope = SendFreeOrderSuccessEventResponse.class)
    public JAXBElement<ServiceResultOfboolean> createSendFreeOrderSuccessEventResponseSendFreeOrderSuccessEventResult(ServiceResultOfboolean value) {
        return new JAXBElement<ServiceResultOfboolean>(_SendFreeOrderSuccessEventResponseSendFreeOrderSuccessEventResult_QNAME, ServiceResultOfboolean.class, SendFreeOrderSuccessEventResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderFilterParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "oParams", scope = GetOrdersByFilterParams.class)
    public JAXBElement<OrderFilterParam> createGetOrdersByFilterParamsOParams(OrderFilterParam value) {
        return new JAXBElement<OrderFilterParam>(_GetOrdersByFilterParamsOParams_QNAME, OrderFilterParam.class, GetOrdersByFilterParams.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfPageOfOrderdNPiHdpem06JEnuP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrdersByFilterParamsResult", scope = GetOrdersByFilterParamsResponse.class)
    public JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP> createGetOrdersByFilterParamsResponseGetOrdersByFilterParamsResult(ServiceResultOfPageOfOrderdNPiHdpem06JEnuP value) {
        return new JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP>(_GetOrdersByFilterParamsResponseGetOrdersByFilterParamsResult_QNAME, ServiceResultOfPageOfOrderdNPiHdpem06JEnuP.class, GetOrdersByFilterParamsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPayTrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderPayTrade", scope = UpdateOrderPayMode.class)
    public JAXBElement<OrderPayTrade> createUpdateOrderPayModeOrderPayTrade(OrderPayTrade value) {
        return new JAXBElement<OrderPayTrade>(_UpdateOrderPayModeOrderPayTrade_QNAME, OrderPayTrade.class, UpdateOrderPayMode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdateOrderPayModeResult", scope = UpdateOrderPayModeResponse.class)
    public JAXBElement<ServiceResult> createUpdateOrderPayModeResponseUpdateOrderPayModeResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_UpdateOrderPayModeResponseUpdateOrderPayModeResult_QNAME, ServiceResult.class, UpdateOrderPayModeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckProductExistsOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetExistsOrderByProduct.class)
    public JAXBElement<CheckProductExistsOrderRequest> createGetExistsOrderByProductRequest(CheckProductExistsOrderRequest value) {
        return new JAXBElement<CheckProductExistsOrderRequest>(_ChangeStatusRequest_QNAME, CheckProductExistsOrderRequest.class, GetExistsOrderByProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExistsOrderByProductResult", scope = GetExistsOrderByProductResponse.class)
    public JAXBElement<ServiceResultOfOrderdNPiHdpe> createGetExistsOrderByProductResponseGetExistsOrderByProductResult(ServiceResultOfOrderdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderdNPiHdpe>(_GetExistsOrderByProductResponseGetExistsOrderByProductResult_QNAME, ServiceResultOfOrderdNPiHdpe.class, GetExistsOrderByProductResponse.class, value);
    }

}
