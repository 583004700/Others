
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>PublisherBookVersion complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PublisherBookVersion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="PublishYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersionFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PublisherId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PublisherLogoPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PublisherLogoShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusFlag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublisherBookVersion", propOrder = {
    "createDate",
    "publishYear",
    "publisherBookVersionCode",
    "publisherBookVersionFullName",
    "publisherBookVersionId",
    "publisherBookVersionName",
    "publisherId",
    "publisherLogoPath",
    "publisherLogoShortCode",
    "statusFlag"
})
public class PublisherBookVersion {

    @XmlElement(name = "CreateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "PublishYear")
    protected Integer publishYear;
    @XmlElementRef(name = "PublisherBookVersionCode", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> publisherBookVersionCode;
    @XmlElementRef(name = "PublisherBookVersionFullName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> publisherBookVersionFullName;
    @XmlElement(name = "PublisherBookVersionId")
    protected Integer publisherBookVersionId;
    @XmlElementRef(name = "PublisherBookVersionName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> publisherBookVersionName;
    @XmlElement(name = "PublisherId")
    protected Integer publisherId;
    @XmlElementRef(name = "PublisherLogoPath", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> publisherLogoPath;
    @XmlElementRef(name = "PublisherLogoShortCode", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> publisherLogoShortCode;
    @XmlElement(name = "StatusFlag")
    protected Integer statusFlag;

    /**
     * 获取createDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * 设置createDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * 获取publishYear属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPublishYear() {
        return publishYear;
    }

    /**
     * 设置publishYear属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPublishYear(Integer value) {
        this.publishYear = value;
    }

    /**
     * 获取publisherBookVersionCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublisherBookVersionCode() {
        return publisherBookVersionCode;
    }

    /**
     * 设置publisherBookVersionCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublisherBookVersionCode(JAXBElement<String> value) {
        this.publisherBookVersionCode = value;
    }

    /**
     * 获取publisherBookVersionFullName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublisherBookVersionFullName() {
        return publisherBookVersionFullName;
    }

    /**
     * 设置publisherBookVersionFullName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublisherBookVersionFullName(JAXBElement<String> value) {
        this.publisherBookVersionFullName = value;
    }

    /**
     * 获取publisherBookVersionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPublisherBookVersionId() {
        return publisherBookVersionId;
    }

    /**
     * 设置publisherBookVersionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPublisherBookVersionId(Integer value) {
        this.publisherBookVersionId = value;
    }

    /**
     * 获取publisherBookVersionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublisherBookVersionName() {
        return publisherBookVersionName;
    }

    /**
     * 设置publisherBookVersionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublisherBookVersionName(JAXBElement<String> value) {
        this.publisherBookVersionName = value;
    }

    /**
     * 获取publisherId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * 设置publisherId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPublisherId(Integer value) {
        this.publisherId = value;
    }

    /**
     * 获取publisherLogoPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublisherLogoPath() {
        return publisherLogoPath;
    }

    /**
     * 设置publisherLogoPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublisherLogoPath(JAXBElement<String> value) {
        this.publisherLogoPath = value;
    }

    /**
     * 获取publisherLogoShortCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublisherLogoShortCode() {
        return publisherLogoShortCode;
    }

    /**
     * 设置publisherLogoShortCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublisherLogoShortCode(JAXBElement<String> value) {
        this.publisherLogoShortCode = value;
    }

    /**
     * 获取statusFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatusFlag() {
        return statusFlag;
    }

    /**
     * 设置statusFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatusFlag(Integer value) {
        this.statusFlag = value;
    }

}
