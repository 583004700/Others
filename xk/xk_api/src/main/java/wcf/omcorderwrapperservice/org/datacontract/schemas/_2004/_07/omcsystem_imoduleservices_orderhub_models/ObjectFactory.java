
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models package. 
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

    private final static QName _ChangeOrderStatusRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "ChangeOrderStatusRequest");
    private final static QName _CheckProductExistsOrderRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "CheckProductExistsOrderRequest");
    private final static QName _GetOrderPayUrlRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "GetOrderPayUrlRequest");
    private final static QName _CloseOrderRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "CloseOrderRequest");
    private final static QName _GetProductOrderNumberRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "GetProductOrderNumberRequest");
    private final static QName _GetProductOrderNumberRequestSourcePlantCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "SourcePlantCode");
    private final static QName _CloseOrderRequestOrderNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "OrderNumber");
    private final static QName _ChangeOrderStatusRequestErrorCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "ErrorCode");
    private final static QName _ChangeOrderStatusRequestErrorMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", "ErrorMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeOrderStatusRequest }
     * 
     */
    public ChangeOrderStatusRequest createChangeOrderStatusRequest() {
        return new ChangeOrderStatusRequest();
    }

    /**
     * Create an instance of {@link CheckProductExistsOrderRequest }
     * 
     */
    public CheckProductExistsOrderRequest createCheckProductExistsOrderRequest() {
        return new CheckProductExistsOrderRequest();
    }

    /**
     * Create an instance of {@link GetOrderPayUrlRequest }
     * 
     */
    public GetOrderPayUrlRequest createGetOrderPayUrlRequest() {
        return new GetOrderPayUrlRequest();
    }

    /**
     * Create an instance of {@link CloseOrderRequest }
     * 
     */
    public CloseOrderRequest createCloseOrderRequest() {
        return new CloseOrderRequest();
    }

    /**
     * Create an instance of {@link GetProductOrderNumberRequest }
     * 
     */
    public GetProductOrderNumberRequest createGetProductOrderNumberRequest() {
        return new GetProductOrderNumberRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrderStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "ChangeOrderStatusRequest")
    public JAXBElement<ChangeOrderStatusRequest> createChangeOrderStatusRequest(ChangeOrderStatusRequest value) {
        return new JAXBElement<ChangeOrderStatusRequest>(_ChangeOrderStatusRequest_QNAME, ChangeOrderStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckProductExistsOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "CheckProductExistsOrderRequest")
    public JAXBElement<CheckProductExistsOrderRequest> createCheckProductExistsOrderRequest(CheckProductExistsOrderRequest value) {
        return new JAXBElement<CheckProductExistsOrderRequest>(_CheckProductExistsOrderRequest_QNAME, CheckProductExistsOrderRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderPayUrlRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "GetOrderPayUrlRequest")
    public JAXBElement<GetOrderPayUrlRequest> createGetOrderPayUrlRequest(GetOrderPayUrlRequest value) {
        return new JAXBElement<GetOrderPayUrlRequest>(_GetOrderPayUrlRequest_QNAME, GetOrderPayUrlRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseOrderRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "CloseOrderRequest")
    public JAXBElement<CloseOrderRequest> createCloseOrderRequest(CloseOrderRequest value) {
        return new JAXBElement<CloseOrderRequest>(_CloseOrderRequest_QNAME, CloseOrderRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductOrderNumberRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "GetProductOrderNumberRequest")
    public JAXBElement<GetProductOrderNumberRequest> createGetProductOrderNumberRequest(GetProductOrderNumberRequest value) {
        return new JAXBElement<GetProductOrderNumberRequest>(_GetProductOrderNumberRequest_QNAME, GetProductOrderNumberRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "SourcePlantCode", scope = GetProductOrderNumberRequest.class)
    public JAXBElement<String> createGetProductOrderNumberRequestSourcePlantCode(String value) {
        return new JAXBElement<String>(_GetProductOrderNumberRequestSourcePlantCode_QNAME, String.class, GetProductOrderNumberRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "OrderNumber", scope = CloseOrderRequest.class)
    public JAXBElement<String> createCloseOrderRequestOrderNumber(String value) {
        return new JAXBElement<String>(_CloseOrderRequestOrderNumber_QNAME, String.class, CloseOrderRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "OrderNumber", scope = GetOrderPayUrlRequest.class)
    public JAXBElement<String> createGetOrderPayUrlRequestOrderNumber(String value) {
        return new JAXBElement<String>(_CloseOrderRequestOrderNumber_QNAME, String.class, GetOrderPayUrlRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "SourcePlantCode", scope = CheckProductExistsOrderRequest.class)
    public JAXBElement<String> createCheckProductExistsOrderRequestSourcePlantCode(String value) {
        return new JAXBElement<String>(_GetProductOrderNumberRequestSourcePlantCode_QNAME, String.class, CheckProductExistsOrderRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "ErrorCode", scope = ChangeOrderStatusRequest.class)
    public JAXBElement<String> createChangeOrderStatusRequestErrorCode(String value) {
        return new JAXBElement<String>(_ChangeOrderStatusRequestErrorCode_QNAME, String.class, ChangeOrderStatusRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "ErrorMessage", scope = ChangeOrderStatusRequest.class)
    public JAXBElement<String> createChangeOrderStatusRequestErrorMessage(String value) {
        return new JAXBElement<String>(_ChangeOrderStatusRequestErrorMessage_QNAME, String.class, ChangeOrderStatusRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Request", name = "OrderNumber", scope = ChangeOrderStatusRequest.class)
    public JAXBElement<String> createChangeOrderStatusRequestOrderNumber(String value) {
        return new JAXBElement<String>(_CloseOrderRequestOrderNumber_QNAME, String.class, ChangeOrderStatusRequest.class, value);
    }

}
