
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfBookVersion;


/**
 * <p>CourseBookVersionListView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CourseBookVersionListView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersions" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfBookVersion" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourseBookVersionListView", propOrder = {
    "bookVersions",
    "courseId",
    "questionCount"
})
public class CourseBookVersionListView {

    @XmlElementRef(name = "BookVersions", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBookVersion> bookVersions;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "QuestionCount")
    protected Integer questionCount;

    /**
     * 获取bookVersions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBookVersion> getBookVersions() {
        return bookVersions;
    }

    /**
     * 设置bookVersions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}
     *     
     */
    public void setBookVersions(JAXBElement<ArrayOfBookVersion> value) {
        this.bookVersions = value;
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
     * 获取questionCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCount() {
        return questionCount;
    }

    /**
     * 设置questionCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCount(Integer value) {
        this.questionCount = value;
    }

}
