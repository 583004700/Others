
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.ArrayOfOrder;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.omcsystem_core_common package. 
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

    private final static QName _ErrorInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException", "ErrorInfo");
    private final static QName _PayMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", "PayMode");
    private final static QName _TradeTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", "TradeTypeEnum");
    private final static QName _TransactionType_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", "TransactionType");
    private final static QName _QueryParams_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", "QueryParams");
    private final static QName _PageOfOrderdNPiHdpe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", "PageOfOrderdN_PiHdpe");
    private final static QName _PageOfOrderdNPiHdpeItems_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", "Items");
    private final static QName _ErrorInfoMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.omcsystem_core_common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorInfo }
     * 
     */
    public ErrorInfo createErrorInfo() {
        return new ErrorInfo();
    }

    /**
     * Create an instance of {@link QueryParams }
     * 
     */
    public QueryParams createQueryParams() {
        return new QueryParams();
    }

    /**
     * Create an instance of {@link PageOfOrderdNPiHdpe }
     * 
     */
    public PageOfOrderdNPiHdpe createPageOfOrderdNPiHdpe() {
        return new PageOfOrderdNPiHdpe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException", name = "ErrorInfo")
    public JAXBElement<ErrorInfo> createErrorInfo(ErrorInfo value) {
        return new JAXBElement<ErrorInfo>(_ErrorInfo_QNAME, ErrorInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", name = "PayMode")
    public JAXBElement<PayMode> createPayMode(PayMode value) {
        return new JAXBElement<PayMode>(_PayMode_QNAME, PayMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TradeTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", name = "TradeTypeEnum")
    public JAXBElement<TradeTypeEnum> createTradeTypeEnum(TradeTypeEnum value) {
        return new JAXBElement<TradeTypeEnum>(_TradeTypeEnum_QNAME, TradeTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums", name = "TransactionType")
    public JAXBElement<TransactionType> createTransactionType(TransactionType value) {
        return new JAXBElement<TransactionType>(_TransactionType_QNAME, TransactionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", name = "QueryParams")
    public JAXBElement<QueryParams> createQueryParams(QueryParams value) {
        return new JAXBElement<QueryParams>(_QueryParams_QNAME, QueryParams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PageOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", name = "PageOfOrderdN_PiHdpe")
    public JAXBElement<PageOfOrderdNPiHdpe> createPageOfOrderdNPiHdpe(PageOfOrderdNPiHdpe value) {
        return new JAXBElement<PageOfOrderdNPiHdpe>(_PageOfOrderdNPiHdpe_QNAME, PageOfOrderdNPiHdpe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel", name = "Items", scope = PageOfOrderdNPiHdpe.class)
    public JAXBElement<ArrayOfOrder> createPageOfOrderdNPiHdpeItems(ArrayOfOrder value) {
        return new JAXBElement<ArrayOfOrder>(_PageOfOrderdNPiHdpeItems_QNAME, ArrayOfOrder.class, PageOfOrderdNPiHdpe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException", name = "Message", scope = ErrorInfo.class)
    public JAXBElement<String> createErrorInfoMessage(String value) {
        return new JAXBElement<String>(_ErrorInfoMessage_QNAME, String.class, ErrorInfo.class, value);
    }

}
