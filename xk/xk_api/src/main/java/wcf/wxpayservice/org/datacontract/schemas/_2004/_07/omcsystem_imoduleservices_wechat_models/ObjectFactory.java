
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models
 * package. <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _PayJsApiRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "PayJsApiRequest");

    private final static QName _ScanCodeCallbackParam_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ScanCodeCallbackParam");

    private final static QName _ScanCodeCallbackResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ScanCodeCallbackResult");

    private final static QName _ScanCodeCallbackResultAppId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "AppId");

    private final static QName _ScanCodeCallbackResultErrCodeDes_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ErrCodeDes");

    private final static QName _ScanCodeCallbackResultMchId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "MchId");

    private final static QName _ScanCodeCallbackResultNonceStr_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "NonceStr");

    private final static QName _ScanCodeCallbackResultPrePayId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "PrePayId");

    private final static QName _ScanCodeCallbackResultResultCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ResultCode");

    private final static QName _ScanCodeCallbackResultReturnCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ReturnCode");

    private final static QName _ScanCodeCallbackResultReturnMsg_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ReturnMsg");

    private final static QName _ScanCodeCallbackResultSign_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "Sign");

    private final static QName _ScanCodeCallbackParamClientId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ClientId");

    private final static QName _ScanCodeCallbackParamIpAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "IpAddress");

    private final static QName _ScanCodeCallbackParamIsSubscribe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "IsSubscribe");

    private final static QName _ScanCodeCallbackParamOpenId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "OpenId");

    private final static QName _ScanCodeCallbackParamProductId_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "ProductId");

    private final static QName _PayJsApiRequestAppkey_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "Appkey");

    private final static QName _PayJsApiRequestPackage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "Package");

    private final static QName _PayJsApiRequestPaySign_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "PaySign");

    private final static QName _PayJsApiRequestSignType_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "SignType");

    private final static QName _PayJsApiRequestTimeStamp_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", "TimeStamp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived
     * classes for package:
     * org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models
     */
    public ObjectFactory()
    {}

    /**
     * Create an instance of {@link PayJsApiRequest }
     */
    public PayJsApiRequest createPayJsApiRequest()
    {
        return new PayJsApiRequest();
    }

    /**
     * Create an instance of {@link ScanCodeCallbackParam }
     */
    public ScanCodeCallbackParam createScanCodeCallbackParam()
    {
        return new ScanCodeCallbackParam();
    }

    /**
     * Create an instance of {@link ScanCodeCallbackResult }
     */
    public ScanCodeCallbackResult createScanCodeCallbackResult()
    {
        return new ScanCodeCallbackResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayJsApiRequest }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "PayJsApiRequest")
    public JAXBElement<PayJsApiRequest> createPayJsApiRequest(PayJsApiRequest value)
    {
        return new JAXBElement<PayJsApiRequest>(_PayJsApiRequest_QNAME, PayJsApiRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanCodeCallbackParam }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ScanCodeCallbackParam")
    public JAXBElement<ScanCodeCallbackParam> createScanCodeCallbackParam(ScanCodeCallbackParam value)
    {
        return new JAXBElement<ScanCodeCallbackParam>(_ScanCodeCallbackParam_QNAME, ScanCodeCallbackParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScanCodeCallbackResult }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ScanCodeCallbackResult")
    public JAXBElement<ScanCodeCallbackResult> createScanCodeCallbackResult(ScanCodeCallbackResult value)
    {
        return new JAXBElement<ScanCodeCallbackResult>(_ScanCodeCallbackResult_QNAME, ScanCodeCallbackResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "AppId", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultAppId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultAppId_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ErrCodeDes", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultErrCodeDes(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultErrCodeDes_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "MchId", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultMchId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultMchId_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "NonceStr", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultNonceStr(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultNonceStr_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "PrePayId", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultPrePayId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultPrePayId_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ResultCode", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultResultCode(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultResultCode_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ReturnCode", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultReturnCode(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultReturnCode_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ReturnMsg", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultReturnMsg(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultReturnMsg_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "Sign", scope = ScanCodeCallbackResult.class)
    public JAXBElement<String> createScanCodeCallbackResultSign(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultSign_QNAME, String.class, ScanCodeCallbackResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "AppId", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamAppId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultAppId_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ClientId", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamClientId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackParamClientId_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "IpAddress", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamIpAddress(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackParamIpAddress_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "IsSubscribe", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamIsSubscribe(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackParamIsSubscribe_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "MchId", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamMchId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultMchId_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "NonceStr", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamNonceStr(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultNonceStr_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "OpenId", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamOpenId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackParamOpenId_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "ProductId", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamProductId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackParamProductId_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "Sign", scope = ScanCodeCallbackParam.class)
    public JAXBElement<String> createScanCodeCallbackParamSign(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultSign_QNAME, String.class, ScanCodeCallbackParam.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "AppId", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestAppId(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultAppId_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "Appkey", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestAppkey(String value)
    {
        return new JAXBElement<String>(_PayJsApiRequestAppkey_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "NonceStr", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestNonceStr(String value)
    {
        return new JAXBElement<String>(_ScanCodeCallbackResultNonceStr_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "Package", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestPackage(String value)
    {
        return new JAXBElement<String>(_PayJsApiRequestPackage_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "PaySign", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestPaySign(String value)
    {
        return new JAXBElement<String>(_PayJsApiRequestPaySign_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "SignType", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestSignType(String value)
    {
        return new JAXBElement<String>(_PayJsApiRequestSignType_QNAME, String.class, PayJsApiRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat", name = "TimeStamp", scope = PayJsApiRequest.class)
    public JAXBElement<String> createPayJsApiRequestTimeStamp(String value)
    {
        return new JAXBElement<String>(_PayJsApiRequestTimeStamp_QNAME, String.class, PayJsApiRequest.class, value);
    }

}
