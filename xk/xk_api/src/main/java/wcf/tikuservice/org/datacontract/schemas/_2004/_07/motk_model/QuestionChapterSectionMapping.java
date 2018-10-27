
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionChapterSectionMapping complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionChapterSectionMapping"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CourseMappingId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="HiddenInChapter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="RootSectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionChapterSectionMapping", propOrder = {
    "bookVersionId",
    "courseMappingId",
    "hiddenInChapter",
    "rootSectionId",
    "sectionId"
})
public class QuestionChapterSectionMapping {

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElement(name = "CourseMappingId")
    protected Integer courseMappingId;
    @XmlElement(name = "HiddenInChapter")
    protected Boolean hiddenInChapter;
    @XmlElement(name = "RootSectionId")
    protected Integer rootSectionId;
    @XmlElement(name = "SectionId")
    protected Integer sectionId;

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
     * 获取courseMappingId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCourseMappingId() {
        return courseMappingId;
    }

    /**
     * 设置courseMappingId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCourseMappingId(Integer value) {
        this.courseMappingId = value;
    }

    /**
     * 获取hiddenInChapter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHiddenInChapter() {
        return hiddenInChapter;
    }

    /**
     * 设置hiddenInChapter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHiddenInChapter(Boolean value) {
        this.hiddenInChapter = value;
    }

    /**
     * 获取rootSectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRootSectionId() {
        return rootSectionId;
    }

    /**
     * 设置rootSectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRootSectionId(Integer value) {
        this.rootSectionId = value;
    }

    /**
     * 获取sectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 设置sectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSectionId(Integer value) {
        this.sectionId = value;
    }

}
