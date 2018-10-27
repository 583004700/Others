
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PageOfOrderdNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.ArrayOfOrderPayMode;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.ArrayOfOrderStatusQuantity;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.Order;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderPayResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.omcsystem_core package. 
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

    private final static QName _ServiceResultOfstring_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfstring");
    private final static QName _ServiceResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResult");
    private final static QName _ServiceResultOfOrderPayResultdNPiHdpe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfOrderPayResultdN_PiHdpe");
    private final static QName _ServiceResultOfPageOfOrderdNPiHdpem06JEnuP_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfPageOfOrderdN_PiHdpem06JEnuP");
    private final static QName _ServiceResultOfOrderdNPiHdpe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfOrderdN_PiHdpe");
    private final static QName _ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfArrayOfOrderStatusQuantitydN_PiHdpe");
    private final static QName _ServiceResultOfTransactionType5Y56Hjij_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfTransactionType5Y56Hjij");
    private final static QName _ServiceResultOfboolean_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfboolean");
    private final static QName _ServiceResultOfArrayOfOrderPayModedNPiHdpe_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "ServiceResultOfArrayOfOrderPayModedN_PiHdpe");
    private final static QName _ServiceResultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "Message");
    private final static QName _ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME = new QName("http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", "Entity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.omcsystem_core
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceResultOfstring }
     * 
     */
    public ServiceResultOfstring createServiceResultOfstring() {
        return new ServiceResultOfstring();
    }

    /**
     * Create an instance of {@link ServiceResult }
     * 
     */
    public ServiceResult createServiceResult() {
        return new ServiceResult();
    }

    /**
     * Create an instance of {@link ServiceResultOfOrderPayResultdNPiHdpe }
     * 
     */
    public ServiceResultOfOrderPayResultdNPiHdpe createServiceResultOfOrderPayResultdNPiHdpe() {
        return new ServiceResultOfOrderPayResultdNPiHdpe();
    }

    /**
     * Create an instance of {@link ServiceResultOfPageOfOrderdNPiHdpem06JEnuP }
     * 
     */
    public ServiceResultOfPageOfOrderdNPiHdpem06JEnuP createServiceResultOfPageOfOrderdNPiHdpem06JEnuP() {
        return new ServiceResultOfPageOfOrderdNPiHdpem06JEnuP();
    }

    /**
     * Create an instance of {@link ServiceResultOfOrderdNPiHdpe }
     * 
     */
    public ServiceResultOfOrderdNPiHdpe createServiceResultOfOrderdNPiHdpe() {
        return new ServiceResultOfOrderdNPiHdpe();
    }

    /**
     * Create an instance of {@link ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe }
     * 
     */
    public ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe createServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe() {
        return new ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe();
    }

    /**
     * Create an instance of {@link ServiceResultOfTransactionType5Y56Hjij }
     * 
     */
    public ServiceResultOfTransactionType5Y56Hjij createServiceResultOfTransactionType5Y56Hjij() {
        return new ServiceResultOfTransactionType5Y56Hjij();
    }

    /**
     * Create an instance of {@link ServiceResultOfboolean }
     * 
     */
    public ServiceResultOfboolean createServiceResultOfboolean() {
        return new ServiceResultOfboolean();
    }

    /**
     * Create an instance of {@link ServiceResultOfArrayOfOrderPayModedNPiHdpe }
     * 
     */
    public ServiceResultOfArrayOfOrderPayModedNPiHdpe createServiceResultOfArrayOfOrderPayModedNPiHdpe() {
        return new ServiceResultOfArrayOfOrderPayModedNPiHdpe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfstring")
    public JAXBElement<ServiceResultOfstring> createServiceResultOfstring(ServiceResultOfstring value) {
        return new JAXBElement<ServiceResultOfstring>(_ServiceResultOfstring_QNAME, ServiceResultOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResult")
    public JAXBElement<ServiceResult> createServiceResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_ServiceResult_QNAME, ServiceResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderPayResultdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfOrderPayResultdN_PiHdpe")
    public JAXBElement<ServiceResultOfOrderPayResultdNPiHdpe> createServiceResultOfOrderPayResultdNPiHdpe(ServiceResultOfOrderPayResultdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderPayResultdNPiHdpe>(_ServiceResultOfOrderPayResultdNPiHdpe_QNAME, ServiceResultOfOrderPayResultdNPiHdpe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfPageOfOrderdNPiHdpem06JEnuP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfPageOfOrderdN_PiHdpem06JEnuP")
    public JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP> createServiceResultOfPageOfOrderdNPiHdpem06JEnuP(ServiceResultOfPageOfOrderdNPiHdpem06JEnuP value) {
        return new JAXBElement<ServiceResultOfPageOfOrderdNPiHdpem06JEnuP>(_ServiceResultOfPageOfOrderdNPiHdpem06JEnuP_QNAME, ServiceResultOfPageOfOrderdNPiHdpem06JEnuP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfOrderdN_PiHdpe")
    public JAXBElement<ServiceResultOfOrderdNPiHdpe> createServiceResultOfOrderdNPiHdpe(ServiceResultOfOrderdNPiHdpe value) {
        return new JAXBElement<ServiceResultOfOrderdNPiHdpe>(_ServiceResultOfOrderdNPiHdpe_QNAME, ServiceResultOfOrderdNPiHdpe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfArrayOfOrderStatusQuantitydN_PiHdpe")
    public JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe> createServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe(ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe value) {
        return new JAXBElement<ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe>(_ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe_QNAME, ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfTransactionType5Y56Hjij }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfTransactionType5Y56Hjij")
    public JAXBElement<ServiceResultOfTransactionType5Y56Hjij> createServiceResultOfTransactionType5Y56Hjij(ServiceResultOfTransactionType5Y56Hjij value) {
        return new JAXBElement<ServiceResultOfTransactionType5Y56Hjij>(_ServiceResultOfTransactionType5Y56Hjij_QNAME, ServiceResultOfTransactionType5Y56Hjij.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfboolean")
    public JAXBElement<ServiceResultOfboolean> createServiceResultOfboolean(ServiceResultOfboolean value) {
        return new JAXBElement<ServiceResultOfboolean>(_ServiceResultOfboolean_QNAME, ServiceResultOfboolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResultOfArrayOfOrderPayModedNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "ServiceResultOfArrayOfOrderPayModedN_PiHdpe")
    public JAXBElement<ServiceResultOfArrayOfOrderPayModedNPiHdpe> createServiceResultOfArrayOfOrderPayModedNPiHdpe(ServiceResultOfArrayOfOrderPayModedNPiHdpe value) {
        return new JAXBElement<ServiceResultOfArrayOfOrderPayModedNPiHdpe>(_ServiceResultOfArrayOfOrderPayModedNPiHdpe_QNAME, ServiceResultOfArrayOfOrderPayModedNPiHdpe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Message", scope = ServiceResult.class)
    public JAXBElement<String> createServiceResultMessage(String value) {
        return new JAXBElement<String>(_ServiceResultMessage_QNAME, String.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderPayMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfArrayOfOrderPayModedNPiHdpe.class)
    public JAXBElement<ArrayOfOrderPayMode> createServiceResultOfArrayOfOrderPayModedNPiHdpeEntity(ArrayOfOrderPayMode value) {
        return new JAXBElement<ArrayOfOrderPayMode>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, ArrayOfOrderPayMode.class, ServiceResultOfArrayOfOrderPayModedNPiHdpe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOrderStatusQuantity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe.class)
    public JAXBElement<ArrayOfOrderStatusQuantity> createServiceResultOfArrayOfOrderStatusQuantitydNPiHdpeEntity(ArrayOfOrderStatusQuantity value) {
        return new JAXBElement<ArrayOfOrderStatusQuantity>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, ArrayOfOrderStatusQuantity.class, ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfOrderdNPiHdpe.class)
    public JAXBElement<Order> createServiceResultOfOrderdNPiHdpeEntity(Order value) {
        return new JAXBElement<Order>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, Order.class, ServiceResultOfOrderdNPiHdpe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PageOfOrderdNPiHdpe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfPageOfOrderdNPiHdpem06JEnuP.class)
    public JAXBElement<PageOfOrderdNPiHdpe> createServiceResultOfPageOfOrderdNPiHdpem06JEnuPEntity(PageOfOrderdNPiHdpe value) {
        return new JAXBElement<PageOfOrderdNPiHdpe>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, PageOfOrderdNPiHdpe.class, ServiceResultOfPageOfOrderdNPiHdpem06JEnuP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderPayResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfOrderPayResultdNPiHdpe.class)
    public JAXBElement<OrderPayResult> createServiceResultOfOrderPayResultdNPiHdpeEntity(OrderPayResult value) {
        return new JAXBElement<OrderPayResult>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, OrderPayResult.class, ServiceResultOfOrderPayResultdNPiHdpe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", name = "Entity", scope = ServiceResultOfstring.class)
    public JAXBElement<String> createServiceResultOfstringEntity(String value) {
        return new JAXBElement<String>(_ServiceResultOfArrayOfOrderPayModedNPiHdpeEntity_QNAME, String.class, ServiceResultOfstring.class, value);
    }

}
