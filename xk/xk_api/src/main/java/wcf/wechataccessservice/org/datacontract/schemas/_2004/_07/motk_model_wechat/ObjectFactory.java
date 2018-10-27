
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.wechataccessservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.motk_model_wechat package. 
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

    private final static QName _WechatTransferRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "WechatTransferRequest");
    private final static QName _WechatTransferModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "WechatTransferModel");
    private final static QName _GetMaterialRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "GetMaterialRequest");
    private final static QName _GetMaterialRequestAccessToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "AccessToken");
    private final static QName _GetMaterialRequestMediaIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "MediaIds");
    private final static QName _WechatTransferRequestWechatTransfer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "WechatTransfer");
    private final static QName _WechatTransferRequestWithdrawCertificateNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", "WithdrawCertificateNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.motk_model_wechat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WechatTransferRequest }
     * 
     */
    public WechatTransferRequest createWechatTransferRequest() {
        return new WechatTransferRequest();
    }

    /**
     * Create an instance of {@link GetMaterialRequest }
     * 
     */
    public GetMaterialRequest createGetMaterialRequest() {
        return new GetMaterialRequest();
    }

    /**
     * Create an instance of {@link WechatTransferModel }
     * 
     */
    public WechatTransferModel createWechatTransferModel() {
        return new WechatTransferModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatTransferRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "WechatTransferRequest")
    public JAXBElement<WechatTransferRequest> createWechatTransferRequest(WechatTransferRequest value) {
        return new JAXBElement<WechatTransferRequest>(_WechatTransferRequest_QNAME, WechatTransferRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatTransferModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "WechatTransferModel")
    public JAXBElement<WechatTransferModel> createWechatTransferModel(WechatTransferModel value) {
        return new JAXBElement<WechatTransferModel>(_WechatTransferModel_QNAME, WechatTransferModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "GetMaterialRequest")
    public JAXBElement<GetMaterialRequest> createGetMaterialRequest(GetMaterialRequest value) {
        return new JAXBElement<GetMaterialRequest>(_GetMaterialRequest_QNAME, GetMaterialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "AccessToken", scope = GetMaterialRequest.class)
    public JAXBElement<String> createGetMaterialRequestAccessToken(String value) {
        return new JAXBElement<String>(_GetMaterialRequestAccessToken_QNAME, String.class, GetMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "MediaIds", scope = GetMaterialRequest.class)
    public JAXBElement<ArrayOfstring> createGetMaterialRequestMediaIds(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetMaterialRequestMediaIds_QNAME, ArrayOfstring.class, GetMaterialRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatTransferModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "WechatTransfer", scope = WechatTransferRequest.class)
    public JAXBElement<WechatTransferModel> createWechatTransferRequestWechatTransfer(WechatTransferModel value) {
        return new JAXBElement<WechatTransferModel>(_WechatTransferRequestWechatTransfer_QNAME, WechatTransferModel.class, WechatTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", name = "WithdrawCertificateNumber", scope = WechatTransferRequest.class)
    public JAXBElement<String> createWechatTransferRequestWithdrawCertificateNumber(String value) {
        return new JAXBElement<String>(_WechatTransferRequestWithdrawCertificateNumber_QNAME, String.class, WechatTransferRequest.class, value);
    }

}
