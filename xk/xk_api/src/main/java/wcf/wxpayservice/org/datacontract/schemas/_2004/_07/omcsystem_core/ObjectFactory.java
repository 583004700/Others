
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.AppPayParameterResponse;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.PayJsApiRequest;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.ScanCodeCallbackResult;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.datacontract.schemas._2004._07.omcsystem_core package. <p>An ObjectFactory
 * allows you to programatically construct new instances of the Java representation for XML
 * content. The Java representation of XML content can consist of schema derived interfaces and
 * classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _ServiceResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResult");

    private final static QName _ServiceResultOfPayJsApiRequestzDDmiR8T_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfPayJsApiRequestzDDmiR8T");

    private final static QName _ServiceResultOfScanCodeCallbackResultzDDmiR8T_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common",
        "ServiceResultOfScanCodeCallbackResultzDDmiR8T");

    private final static QName _ServiceResultOfAppPayParameterResponsex2ZDcWkJ_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common",
        "ServiceResultOfAppPayParameterResponsex2zDcWkJ");

    private final static QName _ServiceResultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "Message");

    private final static QName _ServiceResultOfAppPayParameterResponsex2ZDcWkJEntity_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "Entity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived
     * classes for package: org.datacontract.schemas._2004._07.omcsystem_core
     */
    public ObjectFactory()
    {}

    /**
     * Create an instance of {@link ServiceResult }
     */
    public ServiceResult createServiceResult()
    {
        return new ServiceResult();
    }

    /**
     * Create an instance of {@link ServiceResultOfPayJsApiRequestzDDmiR8T }
     */
    public ServiceResultOfPayJsApiRequestzDDmiR8T createServiceResultOfPayJsApiRequestzDDmiR8T()
    {
        return new ServiceResultOfPayJsApiRequestzDDmiR8T();
    }

    /**
     * Create an instance of {@link ServiceResultOfScanCodeCallbackResultzDDmiR8T }
     */
    public ServiceResultOfScanCodeCallbackResultzDDmiR8T createServiceResultOfScanCodeCallbackResultzDDmiR8T()
    {
        return new ServiceResultOfScanCodeCallbackResultzDDmiR8T();
    }

    /**
     * Create an instance of {@link ServiceResultOfAppPayParameterResponsex2ZDcWkJ }
     */
    public ServiceResultOfAppPayParameterResponsex2ZDcWkJ createServiceResultOfAppPayParameterResponsex2ZDcWkJ()
    {
        return new ServiceResultOfAppPayParameterResponsex2ZDcWkJ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResult")
    public JAXBElement<ServiceResult> createServiceResult(ServiceResult value)
    {
        return new JAXBElement<ServiceResult>(_ServiceResult_QNAME, ServiceResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfPayJsApiRequestzDDmiR8T }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfPayJsApiRequestzDDmiR8T")
    public JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T> createServiceResultOfPayJsApiRequestzDDmiR8T(ServiceResultOfPayJsApiRequestzDDmiR8T value)
    {
        return new JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T>(_ServiceResultOfPayJsApiRequestzDDmiR8T_QNAME, ServiceResultOfPayJsApiRequestzDDmiR8T.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfScanCodeCallbackResultzDDmiR8T }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfScanCodeCallbackResultzDDmiR8T")
    public JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T> createServiceResultOfScanCodeCallbackResultzDDmiR8T(ServiceResultOfScanCodeCallbackResultzDDmiR8T value)
    {
        return new JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T>(_ServiceResultOfScanCodeCallbackResultzDDmiR8T_QNAME, ServiceResultOfScanCodeCallbackResultzDDmiR8T.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfAppPayParameterResponsex2ZDcWkJ }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfAppPayParameterResponsex2zDcWkJ")
    public JAXBElement<ServiceResultOfAppPayParameterResponsex2ZDcWkJ> createServiceResultOfAppPayParameterResponsex2ZDcWkJ(ServiceResultOfAppPayParameterResponsex2ZDcWkJ value)
    {
        return new JAXBElement<ServiceResultOfAppPayParameterResponsex2ZDcWkJ>(_ServiceResultOfAppPayParameterResponsex2ZDcWkJ_QNAME, ServiceResultOfAppPayParameterResponsex2ZDcWkJ.class, null,
            value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Message", scope = ServiceResult.class)
    public JAXBElement<String> createServiceResultMessage(String value)
    {
        return new JAXBElement<String>(_ServiceResultMessage_QNAME, String.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPayParameterResponse
     * }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfAppPayParameterResponsex2ZDcWkJ.class)
    public JAXBElement<AppPayParameterResponse> createServiceResultOfAppPayParameterResponsex2ZDcWkJEntity(AppPayParameterResponse value)
    {
        return new JAXBElement<AppPayParameterResponse>(_ServiceResultOfAppPayParameterResponsex2ZDcWkJEntity_QNAME, AppPayParameterResponse.class,
            ServiceResultOfAppPayParameterResponsex2ZDcWkJ.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanCodeCallbackResult }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfScanCodeCallbackResultzDDmiR8T.class)
    public JAXBElement<ScanCodeCallbackResult> createServiceResultOfScanCodeCallbackResultzDDmiR8TEntity(ScanCodeCallbackResult value)
    {
        return new JAXBElement<ScanCodeCallbackResult>(_ServiceResultOfAppPayParameterResponsex2ZDcWkJEntity_QNAME, ScanCodeCallbackResult.class, ServiceResultOfScanCodeCallbackResultzDDmiR8T.class,
            value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayJsApiRequest }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfPayJsApiRequestzDDmiR8T.class)
    public JAXBElement<PayJsApiRequest> createServiceResultOfPayJsApiRequestzDDmiR8TEntity(PayJsApiRequest value)
    {
        return new JAXBElement<PayJsApiRequest>(_ServiceResultOfAppPayParameterResponsex2ZDcWkJEntity_QNAME, PayJsApiRequest.class, ServiceResultOfPayJsApiRequestzDDmiR8T.class, value);
    }

}
