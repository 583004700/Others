
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models
 * package. <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _AppPayParameterResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "AppPayParameterResponse");

    private final static QName _AppPayParameterResponseAppId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "AppId");

    private final static QName _AppPayParameterResponseNonceStr_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "NonceStr");

    private final static QName _AppPayParameterResponsePackage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "Package");

    private final static QName _AppPayParameterResponsePartnerId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "PartnerId");

    private final static QName _AppPayParameterResponsePaySign_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "PaySign");

    private final static QName _AppPayParameterResponsePrePayId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "PrePayId");

    private final static QName _AppPayParameterResponseTimeStamp_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", "TimeStamp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived
     * classes for package:
     * org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models
     */
    public ObjectFactory()
    {}

    /**
     * Create an instance of {@link AppPayParameterResponse }
     */
    public AppPayParameterResponse createAppPayParameterResponse()
    {
        return new AppPayParameterResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPayParameterResponse
     * }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "AppPayParameterResponse")
    public JAXBElement<AppPayParameterResponse> createAppPayParameterResponse(AppPayParameterResponse value)
    {
        return new JAXBElement<AppPayParameterResponse>(_AppPayParameterResponse_QNAME, AppPayParameterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "AppId", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponseAppId(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponseAppId_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "NonceStr", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponseNonceStr(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponseNonceStr_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "Package", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponsePackage(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponsePackage_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "PartnerId", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponsePartnerId(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponsePartnerId_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "PaySign", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponsePaySign(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponsePaySign_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "PrePayId", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponsePrePayId(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponsePrePayId_QNAME, String.class, AppPayParameterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response", name = "TimeStamp", scope = AppPayParameterResponse.class)
    public JAXBElement<String> createAppPayParameterResponseTimeStamp(String value)
    {
        return new JAXBElement<String>(_AppPayParameterResponseTimeStamp_QNAME, String.class, AppPayParameterResponse.class, value);
    }

}
