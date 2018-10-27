
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.NewsItemRequestResult;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ResultMessage;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.WechatTransferResponse;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.CreateQrRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.CreateWeChatMenuRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetAuthorizeUrlRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetAuthorizeUrlView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatAccessTokenRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatAuthorizationInfoRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatTicketRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatUserInfoRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.SendCustomMessageRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.SendWeChatPayRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.SendWeChatTextMessageRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ShortUrlRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ShortUrlResult;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.TemplateMesageSendRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatAccessTokenView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatAuthorizationInfoView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatEncryptRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatEncryptView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatPayRequestBase;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatProcessRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatResponseView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatTicketInfoView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatUserInfoView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat.GetMaterialRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat.WechatTransferRequest;


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

    private final static QName _CreateMenuRequest_QNAME = new QName("http://tempuri.org/", "request");
    private final static QName _CreateMenuResponseCreateMenuResult_QNAME = new QName("http://tempuri.org/", "CreateMenuResult");
    private final static QName _SendTextMessageResponseSendTextMessageResult_QNAME = new QName("http://tempuri.org/", "SendTextMessageResult");
    private final static QName _GetAccessTokenResponseGetAccessTokenResult_QNAME = new QName("http://tempuri.org/", "GetAccessTokenResult");
    private final static QName _GetAuthorizationInfoResponseGetAuthorizationInfoResult_QNAME = new QName("http://tempuri.org/", "GetAuthorizationInfoResult");
    private final static QName _ProcessRequestResponseProcessRequestResult_QNAME = new QName("http://tempuri.org/", "ProcessRequestResult");
    private final static QName _SendPayRequestResponseSendPayRequestResult_QNAME = new QName("http://tempuri.org/", "SendPayRequestResult");
    private final static QName _GetShortUrlResponseGetShortUrlResult_QNAME = new QName("http://tempuri.org/", "GetShortUrlResult");
    private final static QName _ShortUrlResponseShortUrlResult_QNAME = new QName("http://tempuri.org/", "ShortUrlResult");
    private final static QName _ReversePayRequestResponseReversePayRequestResult_QNAME = new QName("http://tempuri.org/", "ReversePayRequestResult");
    private final static QName _GetEncryptMsgResponseGetEncryptMsgResult_QNAME = new QName("http://tempuri.org/", "GetEncryptMsgResult");
    private final static QName _GetAuthorizationUrlResponseGetAuthorizationUrlResult_QNAME = new QName("http://tempuri.org/", "GetAuthorizationUrlResult");
    private final static QName _GetWechatUserInfoResponseGetWechatUserInfoResult_QNAME = new QName("http://tempuri.org/", "GetWechatUserInfoResult");
    private final static QName _CreateQrUrlResponseCreateQrUrlResult_QNAME = new QName("http://tempuri.org/", "CreateQrUrlResult");
    private final static QName _TransferResponseTransferResult_QNAME = new QName("http://tempuri.org/", "TransferResult");
    private final static QName _GetNewsItemResultResponseGetNewsItemResultResult_QNAME = new QName("http://tempuri.org/", "GetNewsItemResultResult");
    private final static QName _GetWeChatTicketResponseGetWeChatTicketResult_QNAME = new QName("http://tempuri.org/", "GetWeChatTicketResult");
    private final static QName _GetAuthorizationInfoV2ResponseGetAuthorizationInfoV2Result_QNAME = new QName("http://tempuri.org/", "GetAuthorizationInfoV2Result");
    private final static QName _GetWechatUserInfoV2ResponseGetWechatUserInfoV2Result_QNAME = new QName("http://tempuri.org/", "GetWechatUserInfoV2Result");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateMenu }
     * 
     */
    public CreateMenu createCreateMenu() {
        return new CreateMenu();
    }

    /**
     * Create an instance of {@link CreateMenuResponse }
     * 
     */
    public CreateMenuResponse createCreateMenuResponse() {
        return new CreateMenuResponse();
    }

    /**
     * Create an instance of {@link SendTextMessage }
     * 
     */
    public SendTextMessage createSendTextMessage() {
        return new SendTextMessage();
    }

    /**
     * Create an instance of {@link SendTextMessageResponse }
     * 
     */
    public SendTextMessageResponse createSendTextMessageResponse() {
        return new SendTextMessageResponse();
    }

    /**
     * Create an instance of {@link GetAccessToken }
     * 
     */
    public GetAccessToken createGetAccessToken() {
        return new GetAccessToken();
    }

    /**
     * Create an instance of {@link GetAccessTokenResponse }
     * 
     */
    public GetAccessTokenResponse createGetAccessTokenResponse() {
        return new GetAccessTokenResponse();
    }

    /**
     * Create an instance of {@link GetAuthorizationInfo }
     * 
     */
    public GetAuthorizationInfo createGetAuthorizationInfo() {
        return new GetAuthorizationInfo();
    }

    /**
     * Create an instance of {@link GetAuthorizationInfoResponse }
     * 
     */
    public GetAuthorizationInfoResponse createGetAuthorizationInfoResponse() {
        return new GetAuthorizationInfoResponse();
    }

    /**
     * Create an instance of {@link ProcessRequest }
     * 
     */
    public ProcessRequest createProcessRequest() {
        return new ProcessRequest();
    }

    /**
     * Create an instance of {@link ProcessRequestResponse }
     * 
     */
    public ProcessRequestResponse createProcessRequestResponse() {
        return new ProcessRequestResponse();
    }

    /**
     * Create an instance of {@link SendPayRequest }
     * 
     */
    public SendPayRequest createSendPayRequest() {
        return new SendPayRequest();
    }

    /**
     * Create an instance of {@link SendPayRequestResponse }
     * 
     */
    public SendPayRequestResponse createSendPayRequestResponse() {
        return new SendPayRequestResponse();
    }

    /**
     * Create an instance of {@link GetShortUrl }
     * 
     */
    public GetShortUrl createGetShortUrl() {
        return new GetShortUrl();
    }

    /**
     * Create an instance of {@link GetShortUrlResponse }
     * 
     */
    public GetShortUrlResponse createGetShortUrlResponse() {
        return new GetShortUrlResponse();
    }

    /**
     * Create an instance of {@link ShortUrl }
     * 
     */
    public ShortUrl createShortUrl() {
        return new ShortUrl();
    }

    /**
     * Create an instance of {@link ShortUrlResponse }
     * 
     */
    public ShortUrlResponse createShortUrlResponse() {
        return new ShortUrlResponse();
    }

    /**
     * Create an instance of {@link ReversePayRequest }
     * 
     */
    public ReversePayRequest createReversePayRequest() {
        return new ReversePayRequest();
    }

    /**
     * Create an instance of {@link ReversePayRequestResponse }
     * 
     */
    public ReversePayRequestResponse createReversePayRequestResponse() {
        return new ReversePayRequestResponse();
    }

    /**
     * Create an instance of {@link GetEncryptMsg }
     * 
     */
    public GetEncryptMsg createGetEncryptMsg() {
        return new GetEncryptMsg();
    }

    /**
     * Create an instance of {@link GetEncryptMsgResponse }
     * 
     */
    public GetEncryptMsgResponse createGetEncryptMsgResponse() {
        return new GetEncryptMsgResponse();
    }

    /**
     * Create an instance of {@link GetAuthorizationUrl }
     * 
     */
    public GetAuthorizationUrl createGetAuthorizationUrl() {
        return new GetAuthorizationUrl();
    }

    /**
     * Create an instance of {@link GetAuthorizationUrlResponse }
     * 
     */
    public GetAuthorizationUrlResponse createGetAuthorizationUrlResponse() {
        return new GetAuthorizationUrlResponse();
    }

    /**
     * Create an instance of {@link TemplateMesageSend }
     * 
     */
    public TemplateMesageSend createTemplateMesageSend() {
        return new TemplateMesageSend();
    }

    /**
     * Create an instance of {@link TemplateMesageSendResponse }
     * 
     */
    public TemplateMesageSendResponse createTemplateMesageSendResponse() {
        return new TemplateMesageSendResponse();
    }

    /**
     * Create an instance of {@link GetWechatUserInfo }
     * 
     */
    public GetWechatUserInfo createGetWechatUserInfo() {
        return new GetWechatUserInfo();
    }

    /**
     * Create an instance of {@link GetWechatUserInfoResponse }
     * 
     */
    public GetWechatUserInfoResponse createGetWechatUserInfoResponse() {
        return new GetWechatUserInfoResponse();
    }

    /**
     * Create an instance of {@link CreateQrUrl }
     * 
     */
    public CreateQrUrl createCreateQrUrl() {
        return new CreateQrUrl();
    }

    /**
     * Create an instance of {@link CreateQrUrlResponse }
     * 
     */
    public CreateQrUrlResponse createCreateQrUrlResponse() {
        return new CreateQrUrlResponse();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link SendCustomMessage }
     * 
     */
    public SendCustomMessage createSendCustomMessage() {
        return new SendCustomMessage();
    }

    /**
     * Create an instance of {@link SendCustomMessageResponse }
     * 
     */
    public SendCustomMessageResponse createSendCustomMessageResponse() {
        return new SendCustomMessageResponse();
    }

    /**
     * Create an instance of {@link GetNewsItemResult }
     * 
     */
    public GetNewsItemResult createGetNewsItemResult() {
        return new GetNewsItemResult();
    }

    /**
     * Create an instance of {@link GetNewsItemResultResponse }
     * 
     */
    public GetNewsItemResultResponse createGetNewsItemResultResponse() {
        return new GetNewsItemResultResponse();
    }

    /**
     * Create an instance of {@link GetWeChatTicket }
     * 
     */
    public GetWeChatTicket createGetWeChatTicket() {
        return new GetWeChatTicket();
    }

    /**
     * Create an instance of {@link GetWeChatTicketResponse }
     * 
     */
    public GetWeChatTicketResponse createGetWeChatTicketResponse() {
        return new GetWeChatTicketResponse();
    }

    /**
     * Create an instance of {@link GetAuthorizationInfoV2 }
     * 
     */
    public GetAuthorizationInfoV2 createGetAuthorizationInfoV2() {
        return new GetAuthorizationInfoV2();
    }

    /**
     * Create an instance of {@link GetAuthorizationInfoV2Response }
     * 
     */
    public GetAuthorizationInfoV2Response createGetAuthorizationInfoV2Response() {
        return new GetAuthorizationInfoV2Response();
    }

    /**
     * Create an instance of {@link GetWechatUserInfoV2 }
     * 
     */
    public GetWechatUserInfoV2 createGetWechatUserInfoV2() {
        return new GetWechatUserInfoV2();
    }

    /**
     * Create an instance of {@link GetWechatUserInfoV2Response }
     * 
     */
    public GetWechatUserInfoV2Response createGetWechatUserInfoV2Response() {
        return new GetWechatUserInfoV2Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWeChatMenuRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = CreateMenu.class)
    public JAXBElement<CreateWeChatMenuRequest> createCreateMenuRequest(CreateWeChatMenuRequest value) {
        return new JAXBElement<CreateWeChatMenuRequest>(_CreateMenuRequest_QNAME, CreateWeChatMenuRequest.class, CreateMenu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreateMenuResult", scope = CreateMenuResponse.class)
    public JAXBElement<ResultMessage> createCreateMenuResponseCreateMenuResult(ResultMessage value) {
        return new JAXBElement<ResultMessage>(_CreateMenuResponseCreateMenuResult_QNAME, ResultMessage.class, CreateMenuResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendWeChatTextMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = SendTextMessage.class)
    public JAXBElement<SendWeChatTextMessageRequest> createSendTextMessageRequest(SendWeChatTextMessageRequest value) {
        return new JAXBElement<SendWeChatTextMessageRequest>(_CreateMenuRequest_QNAME, SendWeChatTextMessageRequest.class, SendTextMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendTextMessageResult", scope = SendTextMessageResponse.class)
    public JAXBElement<ResultMessage> createSendTextMessageResponseSendTextMessageResult(ResultMessage value) {
        return new JAXBElement<ResultMessage>(_SendTextMessageResponseSendTextMessageResult_QNAME, ResultMessage.class, SendTextMessageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatAccessTokenRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAccessToken.class)
    public JAXBElement<GetWeChatAccessTokenRequest> createGetAccessTokenRequest(GetWeChatAccessTokenRequest value) {
        return new JAXBElement<GetWeChatAccessTokenRequest>(_CreateMenuRequest_QNAME, GetWeChatAccessTokenRequest.class, GetAccessToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatAccessTokenView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccessTokenResult", scope = GetAccessTokenResponse.class)
    public JAXBElement<WeChatAccessTokenView> createGetAccessTokenResponseGetAccessTokenResult(WeChatAccessTokenView value) {
        return new JAXBElement<WeChatAccessTokenView>(_GetAccessTokenResponseGetAccessTokenResult_QNAME, WeChatAccessTokenView.class, GetAccessTokenResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatAuthorizationInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAuthorizationInfo.class)
    public JAXBElement<GetWeChatAuthorizationInfoRequest> createGetAuthorizationInfoRequest(GetWeChatAuthorizationInfoRequest value) {
        return new JAXBElement<GetWeChatAuthorizationInfoRequest>(_CreateMenuRequest_QNAME, GetWeChatAuthorizationInfoRequest.class, GetAuthorizationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatAuthorizationInfoView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAuthorizationInfoResult", scope = GetAuthorizationInfoResponse.class)
    public JAXBElement<WeChatAuthorizationInfoView> createGetAuthorizationInfoResponseGetAuthorizationInfoResult(WeChatAuthorizationInfoView value) {
        return new JAXBElement<WeChatAuthorizationInfoView>(_GetAuthorizationInfoResponseGetAuthorizationInfoResult_QNAME, WeChatAuthorizationInfoView.class, GetAuthorizationInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatProcessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = ProcessRequest.class)
    public JAXBElement<WeChatProcessRequest> createProcessRequestRequest(WeChatProcessRequest value) {
        return new JAXBElement<WeChatProcessRequest>(_CreateMenuRequest_QNAME, WeChatProcessRequest.class, ProcessRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatResponseView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ProcessRequestResult", scope = ProcessRequestResponse.class)
    public JAXBElement<WeChatResponseView> createProcessRequestResponseProcessRequestResult(WeChatResponseView value) {
        return new JAXBElement<WeChatResponseView>(_ProcessRequestResponseProcessRequestResult_QNAME, WeChatResponseView.class, ProcessRequestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendWeChatPayRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = SendPayRequest.class)
    public JAXBElement<SendWeChatPayRequest> createSendPayRequestRequest(SendWeChatPayRequest value) {
        return new JAXBElement<SendWeChatPayRequest>(_CreateMenuRequest_QNAME, SendWeChatPayRequest.class, SendPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SendPayRequestResult", scope = SendPayRequestResponse.class)
    public JAXBElement<String> createSendPayRequestResponseSendPayRequestResult(String value) {
        return new JAXBElement<String>(_SendPayRequestResponseSendPayRequestResult_QNAME, String.class, SendPayRequestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatPayRequestBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetShortUrl.class)
    public JAXBElement<WeChatPayRequestBase> createGetShortUrlRequest(WeChatPayRequestBase value) {
        return new JAXBElement<WeChatPayRequestBase>(_CreateMenuRequest_QNAME, WeChatPayRequestBase.class, GetShortUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetShortUrlResult", scope = GetShortUrlResponse.class)
    public JAXBElement<String> createGetShortUrlResponseGetShortUrlResult(String value) {
        return new JAXBElement<String>(_GetShortUrlResponseGetShortUrlResult_QNAME, String.class, GetShortUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShortUrlRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = ShortUrl.class)
    public JAXBElement<ShortUrlRequest> createShortUrlRequest(ShortUrlRequest value) {
        return new JAXBElement<ShortUrlRequest>(_CreateMenuRequest_QNAME, ShortUrlRequest.class, ShortUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShortUrlResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ShortUrlResult", scope = ShortUrlResponse.class)
    public JAXBElement<ShortUrlResult> createShortUrlResponseShortUrlResult(ShortUrlResult value) {
        return new JAXBElement<ShortUrlResult>(_ShortUrlResponseShortUrlResult_QNAME, ShortUrlResult.class, ShortUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatPayRequestBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = ReversePayRequest.class)
    public JAXBElement<WeChatPayRequestBase> createReversePayRequestRequest(WeChatPayRequestBase value) {
        return new JAXBElement<WeChatPayRequestBase>(_CreateMenuRequest_QNAME, WeChatPayRequestBase.class, ReversePayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReversePayRequestResult", scope = ReversePayRequestResponse.class)
    public JAXBElement<String> createReversePayRequestResponseReversePayRequestResult(String value) {
        return new JAXBElement<String>(_ReversePayRequestResponseReversePayRequestResult_QNAME, String.class, ReversePayRequestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatEncryptRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetEncryptMsg.class)
    public JAXBElement<WeChatEncryptRequest> createGetEncryptMsgRequest(WeChatEncryptRequest value) {
        return new JAXBElement<WeChatEncryptRequest>(_CreateMenuRequest_QNAME, WeChatEncryptRequest.class, GetEncryptMsg.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatEncryptView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetEncryptMsgResult", scope = GetEncryptMsgResponse.class)
    public JAXBElement<WeChatEncryptView> createGetEncryptMsgResponseGetEncryptMsgResult(WeChatEncryptView value) {
        return new JAXBElement<WeChatEncryptView>(_GetEncryptMsgResponseGetEncryptMsgResult_QNAME, WeChatEncryptView.class, GetEncryptMsgResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorizeUrlRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAuthorizationUrl.class)
    public JAXBElement<GetAuthorizeUrlRequest> createGetAuthorizationUrlRequest(GetAuthorizeUrlRequest value) {
        return new JAXBElement<GetAuthorizeUrlRequest>(_CreateMenuRequest_QNAME, GetAuthorizeUrlRequest.class, GetAuthorizationUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorizeUrlView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAuthorizationUrlResult", scope = GetAuthorizationUrlResponse.class)
    public JAXBElement<GetAuthorizeUrlView> createGetAuthorizationUrlResponseGetAuthorizationUrlResult(GetAuthorizeUrlView value) {
        return new JAXBElement<GetAuthorizeUrlView>(_GetAuthorizationUrlResponseGetAuthorizationUrlResult_QNAME, GetAuthorizeUrlView.class, GetAuthorizationUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemplateMesageSendRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = TemplateMesageSend.class)
    public JAXBElement<TemplateMesageSendRequest> createTemplateMesageSendRequest(TemplateMesageSendRequest value) {
        return new JAXBElement<TemplateMesageSendRequest>(_CreateMenuRequest_QNAME, TemplateMesageSendRequest.class, TemplateMesageSend.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatUserInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetWechatUserInfo.class)
    public JAXBElement<GetWeChatUserInfoRequest> createGetWechatUserInfoRequest(GetWeChatUserInfoRequest value) {
        return new JAXBElement<GetWeChatUserInfoRequest>(_CreateMenuRequest_QNAME, GetWeChatUserInfoRequest.class, GetWechatUserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatUserInfoView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetWechatUserInfoResult", scope = GetWechatUserInfoResponse.class)
    public JAXBElement<WeChatUserInfoView> createGetWechatUserInfoResponseGetWechatUserInfoResult(WeChatUserInfoView value) {
        return new JAXBElement<WeChatUserInfoView>(_GetWechatUserInfoResponseGetWechatUserInfoResult_QNAME, WeChatUserInfoView.class, GetWechatUserInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateQrRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = CreateQrUrl.class)
    public JAXBElement<CreateQrRequest> createCreateQrUrlRequest(CreateQrRequest value) {
        return new JAXBElement<CreateQrRequest>(_CreateMenuRequest_QNAME, CreateQrRequest.class, CreateQrUrl.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CreateQrUrlResult", scope = CreateQrUrlResponse.class)
    public JAXBElement<String> createCreateQrUrlResponseCreateQrUrlResult(String value) {
        return new JAXBElement<String>(_CreateQrUrlResponseCreateQrUrlResult_QNAME, String.class, CreateQrUrlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatTransferRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = Transfer.class)
    public JAXBElement<WechatTransferRequest> createTransferRequest(WechatTransferRequest value) {
        return new JAXBElement<WechatTransferRequest>(_CreateMenuRequest_QNAME, WechatTransferRequest.class, Transfer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WechatTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "TransferResult", scope = TransferResponse.class)
    public JAXBElement<WechatTransferResponse> createTransferResponseTransferResult(WechatTransferResponse value) {
        return new JAXBElement<WechatTransferResponse>(_TransferResponseTransferResult_QNAME, WechatTransferResponse.class, TransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCustomMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = SendCustomMessage.class)
    public JAXBElement<SendCustomMessageRequest> createSendCustomMessageRequest(SendCustomMessageRequest value) {
        return new JAXBElement<SendCustomMessageRequest>(_CreateMenuRequest_QNAME, SendCustomMessageRequest.class, SendCustomMessage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetNewsItemResult.class)
    public JAXBElement<GetMaterialRequest> createGetNewsItemResultRequest(GetMaterialRequest value) {
        return new JAXBElement<GetMaterialRequest>(_CreateMenuRequest_QNAME, GetMaterialRequest.class, GetNewsItemResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewsItemRequestResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetNewsItemResultResult", scope = GetNewsItemResultResponse.class)
    public JAXBElement<NewsItemRequestResult> createGetNewsItemResultResponseGetNewsItemResultResult(NewsItemRequestResult value) {
        return new JAXBElement<NewsItemRequestResult>(_GetNewsItemResultResponseGetNewsItemResultResult_QNAME, NewsItemRequestResult.class, GetNewsItemResultResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatTicketRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetWeChatTicket.class)
    public JAXBElement<GetWeChatTicketRequest> createGetWeChatTicketRequest(GetWeChatTicketRequest value) {
        return new JAXBElement<GetWeChatTicketRequest>(_CreateMenuRequest_QNAME, GetWeChatTicketRequest.class, GetWeChatTicket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatTicketInfoView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetWeChatTicketResult", scope = GetWeChatTicketResponse.class)
    public JAXBElement<WeChatTicketInfoView> createGetWeChatTicketResponseGetWeChatTicketResult(WeChatTicketInfoView value) {
        return new JAXBElement<WeChatTicketInfoView>(_GetWeChatTicketResponseGetWeChatTicketResult_QNAME, WeChatTicketInfoView.class, GetWeChatTicketResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatAuthorizationInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAuthorizationInfoV2 .class)
    public JAXBElement<GetWeChatAuthorizationInfoRequest> createGetAuthorizationInfoV2Request(GetWeChatAuthorizationInfoRequest value) {
        return new JAXBElement<GetWeChatAuthorizationInfoRequest>(_CreateMenuRequest_QNAME, GetWeChatAuthorizationInfoRequest.class, GetAuthorizationInfoV2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatAuthorizationInfoView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAuthorizationInfoV2Result", scope = GetAuthorizationInfoV2Response.class)
    public JAXBElement<WeChatAuthorizationInfoView> createGetAuthorizationInfoV2ResponseGetAuthorizationInfoV2Result(WeChatAuthorizationInfoView value) {
        return new JAXBElement<WeChatAuthorizationInfoView>(_GetAuthorizationInfoV2ResponseGetAuthorizationInfoV2Result_QNAME, WeChatAuthorizationInfoView.class, GetAuthorizationInfoV2Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeChatUserInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetWechatUserInfoV2 .class)
    public JAXBElement<GetWeChatUserInfoRequest> createGetWechatUserInfoV2Request(GetWeChatUserInfoRequest value) {
        return new JAXBElement<GetWeChatUserInfoRequest>(_CreateMenuRequest_QNAME, GetWeChatUserInfoRequest.class, GetWechatUserInfoV2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatUserInfoView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetWechatUserInfoV2Result", scope = GetWechatUserInfoV2Response.class)
    public JAXBElement<WeChatUserInfoView> createGetWechatUserInfoV2ResponseGetWechatUserInfoV2Result(WeChatUserInfoView value) {
        return new JAXBElement<WeChatUserInfoView>(_GetWechatUserInfoV2ResponseGetWechatUserInfoV2Result_QNAME, WeChatUserInfoView.class, GetWechatUserInfoV2Response.class, value);
    }

}
