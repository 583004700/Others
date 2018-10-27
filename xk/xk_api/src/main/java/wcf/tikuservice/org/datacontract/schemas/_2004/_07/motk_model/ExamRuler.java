
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExamRuler complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ExamRuler"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ExamRulerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ExamRulerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExamRulerType" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}ExamRulerTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="Grade" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}GradeEnum" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointPoints" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfKnowledgePointPoint" minOccurs="0"/&gt;
 *         &lt;element name="RawData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RegionIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsageType" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}ExamRulerUsageTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExamRuler", propOrder = {
    "bookVersionId",
    "courseId",
    "examRulerId",
    "examRulerName",
    "examRulerType",
    "grade",
    "knowledgePointPoints",
    "rawData",
    "regionIds",
    "usageType",
    "year"
})
public class ExamRuler {

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "ExamRulerId")
    protected Integer examRulerId;
    @XmlElementRef(name = "ExamRulerName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> examRulerName;
    @XmlElement(name = "ExamRulerType")
    @XmlSchemaType(name = "string")
    protected ExamRulerTypeEnum examRulerType;
    @XmlElement(name = "Grade")
    @XmlSchemaType(name = "string")
    protected GradeEnum grade;
    @XmlElementRef(name = "KnowledgePointPoints", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKnowledgePointPoint> knowledgePointPoints;
    @XmlElementRef(name = "RawData", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> rawData;
    @XmlElementRef(name = "RegionIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> regionIds;
    @XmlElement(name = "UsageType")
    @XmlSchemaType(name = "string")
    protected ExamRulerUsageTypeEnum usageType;
    @XmlElement(name = "Year")
    protected Integer year;

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
     * 获取examRulerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExamRulerId() {
        return examRulerId;
    }

    /**
     * 设置examRulerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExamRulerId(Integer value) {
        this.examRulerId = value;
    }

    /**
     * 获取examRulerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExamRulerName() {
        return examRulerName;
    }

    /**
     * 设置examRulerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExamRulerName(JAXBElement<String> value) {
        this.examRulerName = value;
    }

    /**
     * 获取examRulerType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExamRulerTypeEnum }
     *     
     */
    public ExamRulerTypeEnum getExamRulerType() {
        return examRulerType;
    }

    /**
     * 设置examRulerType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExamRulerTypeEnum }
     *     
     */
    public void setExamRulerType(ExamRulerTypeEnum value) {
        this.examRulerType = value;
    }

    /**
     * 获取grade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GradeEnum }
     *     
     */
    public GradeEnum getGrade() {
        return grade;
    }

    /**
     * 设置grade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GradeEnum }
     *     
     */
    public void setGrade(GradeEnum value) {
        this.grade = value;
    }

    /**
     * 获取knowledgePointPoints属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPoint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKnowledgePointPoint> getKnowledgePointPoints() {
        return knowledgePointPoints;
    }

    /**
     * 设置knowledgePointPoints属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPoint }{@code >}
     *     
     */
    public void setKnowledgePointPoints(JAXBElement<ArrayOfKnowledgePointPoint> value) {
        this.knowledgePointPoints = value;
    }

    /**
     * 获取rawData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRawData() {
        return rawData;
    }

    /**
     * 设置rawData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRawData(JAXBElement<String> value) {
        this.rawData = value;
    }

    /**
     * 获取regionIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegionIds() {
        return regionIds;
    }

    /**
     * 设置regionIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegionIds(JAXBElement<String> value) {
        this.regionIds = value;
    }

    /**
     * 获取usageType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExamRulerUsageTypeEnum }
     *     
     */
    public ExamRulerUsageTypeEnum getUsageType() {
        return usageType;
    }

    /**
     * 设置usageType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExamRulerUsageTypeEnum }
     *     
     */
    public void setUsageType(ExamRulerUsageTypeEnum value) {
        this.usageType = value;
    }

    /**
     * 获取year属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置year属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

}
