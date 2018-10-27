
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BookVersion complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BookVersion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="BookVersionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BookVersionSource" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="LocationId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PracticeTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersion" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}PublisherBookVersion" minOccurs="0"/&gt;
 *         &lt;element name="PublisherBookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "BookVersion", propOrder = {
    "bookVersionId",
    "bookVersionName",
    "bookVersionSource",
    "courseId",
    "locationId",
    "practiceTypeId",
    "publisherBookVersion",
    "publisherBookVersionId",
    "statusFlag"
})
public class BookVersion {

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElementRef(name = "BookVersionName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> bookVersionName;
    @XmlElement(name = "BookVersionSource")
    protected Integer bookVersionSource;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "LocationId")
    protected Integer locationId;
    @XmlElement(name = "PracticeTypeId")
    protected Integer practiceTypeId;
    @XmlElementRef(name = "PublisherBookVersion", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<PublisherBookVersion> publisherBookVersion;
    @XmlElement(name = "PublisherBookVersionId")
    protected Integer publisherBookVersionId;
    @XmlElement(name = "StatusFlag")
    protected Integer statusFlag;

    /**
     * 获取bookVersionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookVersionId() {
        return bookVersionId;
    }

    /**
     * 设置bookVersionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookVersionId(Integer value) {
        this.bookVersionId = value;
    }

    /**
     * 获取bookVersionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBookVersionName() {
        return bookVersionName;
    }

    /**
     * 设置bookVersionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBookVersionName(JAXBElement<String> value) {
        this.bookVersionName = value;
    }

    /**
     * 获取bookVersionSource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookVersionSource() {
        return bookVersionSource;
    }

    /**
     * 设置bookVersionSource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookVersionSource(Integer value) {
        this.bookVersionSource = value;
    }

    /**
     * 获取courseId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置courseId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCourseId(Integer value) {
        this.courseId = value;
    }

    /**
     * 获取locationId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 设置locationId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLocationId(Integer value) {
        this.locationId = value;
    }

    /**
     * 获取practiceTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPracticeTypeId() {
        return practiceTypeId;
    }

    /**
     * 设置practiceTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPracticeTypeId(Integer value) {
        this.practiceTypeId = value;
    }

    /**
     * 获取publisherBookVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PublisherBookVersion }{@code >}
     *     
     */
    public JAXBElement<PublisherBookVersion> getPublisherBookVersion() {
        return publisherBookVersion;
    }

    /**
     * 设置publisherBookVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PublisherBookVersion }{@code >}
     *     
     */
    public void setPublisherBookVersion(JAXBElement<PublisherBookVersion> value) {
        this.publisherBookVersion = value;
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
