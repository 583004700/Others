
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionyHSjzk5H;


/**
 * <p>ChapterSectionList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ChapterSectionList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseMappingId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Sections" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintChapterSectionyH_Sjzk5H" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChapterSectionList", propOrder = {
    "courseMappingId",
    "sections"
})
public class ChapterSectionList {

    @XmlElement(name = "CourseMappingId")
    protected Integer courseMappingId;
    @XmlElementRef(name = "Sections", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> sections;

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
     * 获取sections属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> getSections() {
        return sections;
    }

    /**
     * 设置sections属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}
     *     
     */
    public void setSections(JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> value) {
        this.sections = value;
    }

}
