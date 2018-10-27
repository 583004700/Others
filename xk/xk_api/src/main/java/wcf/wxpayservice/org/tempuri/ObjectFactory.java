
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfAppPayParameterResponsex2ZDcWkJ;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPayJsApiRequestzDDmiR8T;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfScanCodeCallbackResultzDDmiR8T;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.ScanCodeCallbackParam;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.tempuri package. <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation for XML content. The Java representation of
 * XML content can consist of schema derived interfaces and classes representing the binding of
 * schema type definitions, element declarations and model groups. Factory methods for each of
 * these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _NoticeOrderTradeSuccessOrderNumber_QNAME = new QName("http://tempuri.org/", "orderNumber");

    private final static QName _NoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult_QNAME = new QName("http://tempuri.org/", "NoticeOrderTradeSuccessResult");

    private final static QName _GetJsApiParametersResponseGetJsApiParametersResult_QNAME = new QName("http://tempuri.org/", "GetJsApiParametersResult");

    private final static QName _ScanCodeCallbackParas_QNAME = new QName("http://tempuri.org/", "paras");

    private final static QName _ScanCodeCallbackResponseScanCodeCallbackResult_QNAME = new QName("http://tempuri.org/", "ScanCodeCallbackResult");

    private final static QName _GetAppParametersResponseGetAppParametersResult_QNAME = new QName("http://tempuri.org/", "GetAppParametersResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived
     * classes for package: org.tempuri
     */
    public ObjectFactory()
    {}

    /**
     * Create an instance of {@link NoticeOrderTradeSuccess }
     */
    public NoticeOrderTradeSuccess createNoticeOrderTradeSuccess()
    {
        return new NoticeOrderTradeSuccess();
    }

    /**
     * Create an instance of {@link NoticeOrderTradeSuccessResponse }
     */
    public NoticeOrderTradeSuccessResponse createNoticeOrderTradeSuccessResponse()
    {
        return new NoticeOrderTradeSuccessResponse();
    }

    /**
     * Create an instance of {@link GetJsApiParameters }
     */
    public GetJsApiParameters createGetJsApiParameters()
    {
        return new GetJsApiParameters();
    }

    /**
     * Create an instance of {@link GetJsApiParametersResponse }
     */
    public GetJsApiParametersResponse createGetJsApiParametersResponse()
    {
        return new GetJsApiParametersResponse();
    }

    /**
     * Create an instance of {@link ScanCodeCallback }
     */
    public ScanCodeCallback createScanCodeCallback()
    {
        return new ScanCodeCallback();
    }

    /**
     * Create an instance of {@link ScanCodeCallbackResponse }
     */
    public ScanCodeCallbackResponse createScanCodeCallbackResponse()
    {
        return new ScanCodeCallbackResponse();
    }

    /**
     * Create an instance of {@link GetAppParameters }
     */
    public GetAppParameters createGetAppParameters()
    {
        return new GetAppParameters();
    }

    /**
     * Create an instance of {@link GetAppParametersResponse }
     */
    public GetAppParametersResponse createGetAppParametersResponse()
    {
        return new GetAppParametersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = NoticeOrderTradeSuccess.class)
    public JAXBElement<String> createNoticeOrderTradeSuccessOrderNumber(String value)
    {
        return new JAXBElement<String>(_NoticeOrderTradeSuccessOrderNumber_QNAME, String.class, NoticeOrderTradeSuccess.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NoticeOrderTradeSuccessResult", scope = NoticeOrderTradeSuccessResponse.class)
    public JAXBElement<ServiceResult> createNoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult(ServiceResult value)
    {
        return new JAXBElement<ServiceResult>(_NoticeOrderTradeSuccessResponseNoticeOrderTradeSuccessResult_QNAME, ServiceResult.class, NoticeOrderTradeSuccessResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = GetJsApiParameters.class)
    public JAXBElement<String> createGetJsApiParametersOrderNumber(String value)
    {
        return new JAXBElement<String>(_NoticeOrderTradeSuccessOrderNumber_QNAME, String.class, GetJsApiParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfPayJsApiRequestzDDmiR8T }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetJsApiParametersResult", scope = GetJsApiParametersResponse.class)
    public JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T> createGetJsApiParametersResponseGetJsApiParametersResult(ServiceResultOfPayJsApiRequestzDDmiR8T value)
    {
        return new JAXBElement<ServiceResultOfPayJsApiRequestzDDmiR8T>(_GetJsApiParametersResponseGetJsApiParametersResult_QNAME, ServiceResultOfPayJsApiRequestzDDmiR8T.class,
            GetJsApiParametersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanCodeCallbackParam }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "paras", scope = ScanCodeCallback.class)
    public JAXBElement<ScanCodeCallbackParam> createScanCodeCallbackParas(ScanCodeCallbackParam value)
    {
        return new JAXBElement<ScanCodeCallbackParam>(_ScanCodeCallbackParas_QNAME, ScanCodeCallbackParam.class, ScanCodeCallback.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfScanCodeCallbackResultzDDmiR8T }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ScanCodeCallbackResult", scope = ScanCodeCallbackResponse.class)
    public JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T> createScanCodeCallbackResponseScanCodeCallbackResult(ServiceResultOfScanCodeCallbackResultzDDmiR8T value)
    {
        return new JAXBElement<ServiceResultOfScanCodeCallbackResultzDDmiR8T>(_ScanCodeCallbackResponseScanCodeCallbackResult_QNAME, ServiceResultOfScanCodeCallbackResultzDDmiR8T.class,
            ScanCodeCallbackResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "orderNumber", scope = GetAppParameters.class)
    public JAXBElement<String> createGetAppParametersOrderNumber(String value)
    {
        return new JAXBElement<String>(_NoticeOrderTradeSuccessOrderNumber_QNAME, String.class, GetAppParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement
     * }{@code <}{@link ServiceResultOfAppPayParameterResponsex2ZDcWkJ }{@code >}}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAppParametersResult", scope = GetAppParametersResponse.class)
    public JAXBElement<ServiceResultOfAppPayParameterResponsex2ZDcWkJ> createGetAppParametersResponseGetAppParametersResult(ServiceResultOfAppPayParameterResponsex2ZDcWkJ value)
    {
        return new JAXBElement<ServiceResultOfAppPayParameterResponsex2ZDcWkJ>(_GetAppParametersResponseGetAppParametersResult_QNAME, ServiceResultOfAppPayParameterResponsex2ZDcWkJ.class,
            GetAppParametersResponse.class, value);
    }

}
