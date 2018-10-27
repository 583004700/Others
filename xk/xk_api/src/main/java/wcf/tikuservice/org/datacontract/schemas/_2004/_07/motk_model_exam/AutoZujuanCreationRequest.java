
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>AutoZujuanCreationRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AutoZujuanCreationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ByCourseMapping" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&gt;
 *         &lt;element name="OnlineOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCount" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintint" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="SectionIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoZujuanCreationRequest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", propOrder = {
    "bookVersionId",
    "byCourseMapping",
    "courseId",
    "knowledgePointIds",
    "onlineOnly",
    "organizationName",
    "questionCount",
    "questionLevel",
    "sectionIds"
})
public class AutoZujuanCreationRequest {

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElement(name = "ByCourseMapping")
    protected Boolean byCourseMapping;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElementRef(name = "KnowledgePointIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", type = JAXBElement.class)
    protected JAXBElement<ArrayOfint> knowledgePointIds;
    @XmlElement(name = "OnlineOnly")
    protected Boolean onlineOnly;
    @XmlElementRef(name = "OrganizationName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", type = JAXBElement.class)
    protected JAXBElement<String> organizationName;
    @XmlElementRef(name = "QuestionCount", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintint> questionCount;
    @XmlElement(name = "QuestionLevel")
    protected Double questionLevel;
    @XmlElementRef(name = "SectionIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> sectionIds;

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
     * 获取byCourseMapping属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isByCourseMapping() {
        return byCourseMapping;
    }

    /**
     * 设置byCourseMapping属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setByCourseMapping(Boolean value) {
        this.byCourseMapping = value;
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
     * 获取knowledgePointIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getKnowledgePointIds() {
        return knowledgePointIds;
    }

    /**
     * 设置knowledgePointIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setKnowledgePointIds(JAXBElement<ArrayOfint> value) {
        this.knowledgePointIds = value;
    }

    /**
     * 获取onlineOnly属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlineOnly() {
        return onlineOnly;
    }

    /**
     * 设置onlineOnly属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlineOnly(Boolean value) {
        this.onlineOnly = value;
    }

    /**
     * 获取organizationName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置organizationName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrganizationName(JAXBElement<String> value) {
        this.organizationName = value;
    }

    /**
     * 获取questionCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfintint> getQuestionCount() {
        return questionCount;
    }

    /**
     * 设置questionCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintint }{@code >}
     *     
     */
    public void setQuestionCount(JAXBElement<ArrayOfKeyValueOfintint> value) {
        this.questionCount = value;
    }

    /**
     * 获取questionLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQuestionLevel() {
        return questionLevel;
    }

    /**
     * 设置questionLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQuestionLevel(Double value) {
        this.questionLevel = value;
    }

    /**
     * 获取sectionIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSectionIds() {
        return sectionIds;
    }

    /**
     * 设置sectionIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSectionIds(JAXBElement<ArrayOfstring> value) {
        this.sectionIds = value;
    }

}
