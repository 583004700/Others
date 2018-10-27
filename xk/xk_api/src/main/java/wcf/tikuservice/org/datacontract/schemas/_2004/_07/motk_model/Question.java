
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Question complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Question"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Analysis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attachments" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionAttachment" minOccurs="0"/&gt;
 *         &lt;element name="CacheUpdateFlag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CapabilityAnalysis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CreateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="FinishTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="FitUseOrganization" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *         &lt;element name="HasAudio" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsProprietary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointLabels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoint" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoints" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OptionGroups" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionOptionGroup" minOccurs="0"/&gt;
 *         &lt;element name="QuestionAudioUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionContentForDisplay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="QuestionQuality" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSortingScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SectionMappings" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionChapterSectionMapping" minOccurs="0"/&gt;
 *         &lt;element name="SemanticLabels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SolveMethodLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusFlag" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SupportOnline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="UpdateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="UseRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
    "analysis",
    "attachments",
    "cacheUpdateFlag",
    "capabilityAnalysis",
    "courseId",
    "createDateTime",
    "finishTime",
    "fitUseOrganization",
    "hasAudio",
    "isProprietary",
    "knowledgePointLabels",
    "mainKnowledgePoint",
    "mainKnowledgePoints",
    "optionGroups",
    "questionAudioUrl",
    "questionCategoryId",
    "questionContent",
    "questionContentForDisplay",
    "questionDisplayTypeId",
    "questionId",
    "questionLevel",
    "questionQuality",
    "questionSortingScore",
    "questionSource",
    "questionYear",
    "sectionMappings",
    "semanticLabels",
    "solveMethodLabel",
    "statusFlag",
    "supportOnline",
    "updateDateTime",
    "useRange"
})
public class Question {

    @XmlElementRef(name = "Analysis", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> analysis;
    @XmlElementRef(name = "Attachments", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionAttachment> attachments;
    @XmlElement(name = "CacheUpdateFlag")
    protected Integer cacheUpdateFlag;
    @XmlElementRef(name = "CapabilityAnalysis", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> capabilityAnalysis;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "CreateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDateTime;
    @XmlElement(name = "FinishTime")
    protected Integer finishTime;
    @XmlElementRef(name = "FitUseOrganization", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> fitUseOrganization;
    @XmlElement(name = "HasAudio")
    protected Boolean hasAudio;
    @XmlElement(name = "IsProprietary")
    protected Boolean isProprietary;
    @XmlElementRef(name = "KnowledgePointLabels", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> knowledgePointLabels;
    @XmlElement(name = "MainKnowledgePoint")
    protected Integer mainKnowledgePoint;
    @XmlElementRef(name = "MainKnowledgePoints", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> mainKnowledgePoints;
    @XmlElementRef(name = "OptionGroups", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionOptionGroup> optionGroups;
    @XmlElementRef(name = "QuestionAudioUrl", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionAudioUrl;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
    @XmlElementRef(name = "QuestionContent", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionContent;
    @XmlElementRef(name = "QuestionContentForDisplay", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionContentForDisplay;
    @XmlElement(name = "QuestionDisplayTypeId")
    protected Integer questionDisplayTypeId;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElement(name = "QuestionLevel")
    protected Short questionLevel;
    @XmlElement(name = "QuestionQuality")
    protected Integer questionQuality;
    @XmlElement(name = "QuestionSortingScore")
    protected Double questionSortingScore;
    @XmlElementRef(name = "QuestionSource", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionSource;
    @XmlElement(name = "QuestionYear")
    protected Integer questionYear;
    @XmlElementRef(name = "SectionMappings", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionChapterSectionMapping> sectionMappings;
    @XmlElementRef(name = "SemanticLabels", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> semanticLabels;
    @XmlElementRef(name = "SolveMethodLabel", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> solveMethodLabel;
    @XmlElement(name = "StatusFlag")
    protected Integer statusFlag;
    @XmlElement(name = "SupportOnline")
    protected Boolean supportOnline;
    @XmlElement(name = "UpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateDateTime;
    @XmlElementRef(name = "UseRange", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> useRange;

    /**
     * 获取analysis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAnalysis() {
        return analysis;
    }

    /**
     * 设置analysis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAnalysis(JAXBElement<String> value) {
        this.analysis = value;
    }

    /**
     * 获取attachments属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionAttachment }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionAttachment> getAttachments() {
        return attachments;
    }

    /**
     * 设置attachments属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionAttachment }{@code >}
     *     
     */
    public void setAttachments(JAXBElement<ArrayOfQuestionAttachment> value) {
        this.attachments = value;
    }

    /**
     * 获取cacheUpdateFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCacheUpdateFlag() {
        return cacheUpdateFlag;
    }

    /**
     * 设置cacheUpdateFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCacheUpdateFlag(Integer value) {
        this.cacheUpdateFlag = value;
    }

    /**
     * 获取capabilityAnalysis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCapabilityAnalysis() {
        return capabilityAnalysis;
    }

    /**
     * 设置capabilityAnalysis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCapabilityAnalysis(JAXBElement<String> value) {
        this.capabilityAnalysis = value;
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
     * 获取createDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDateTime() {
        return createDateTime;
    }

    /**
     * 设置createDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDateTime(XMLGregorianCalendar value) {
        this.createDateTime = value;
    }

    /**
     * 获取finishTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFinishTime() {
        return finishTime;
    }

    /**
     * 设置finishTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFinishTime(Integer value) {
        this.finishTime = value;
    }

    /**
     * 获取fitUseOrganization属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getFitUseOrganization() {
        return fitUseOrganization;
    }

    /**
     * 设置fitUseOrganization属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setFitUseOrganization(JAXBElement<ArrayOfstring> value) {
        this.fitUseOrganization = value;
    }

    /**
     * 获取hasAudio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasAudio() {
        return hasAudio;
    }

    /**
     * 设置hasAudio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasAudio(Boolean value) {
        this.hasAudio = value;
    }

    /**
     * 获取isProprietary属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsProprietary() {
        return isProprietary;
    }

    /**
     * 设置isProprietary属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsProprietary(Boolean value) {
        this.isProprietary = value;
    }

    /**
     * 获取knowledgePointLabels属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKnowledgePointLabels() {
        return knowledgePointLabels;
    }

    /**
     * 设置knowledgePointLabels属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKnowledgePointLabels(JAXBElement<String> value) {
        this.knowledgePointLabels = value;
    }

    /**
     * 获取mainKnowledgePoint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMainKnowledgePoint() {
        return mainKnowledgePoint;
    }

    /**
     * 设置mainKnowledgePoint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMainKnowledgePoint(Integer value) {
        this.mainKnowledgePoint = value;
    }

    /**
     * 获取mainKnowledgePoints属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMainKnowledgePoints() {
        return mainKnowledgePoints;
    }

    /**
     * 设置mainKnowledgePoints属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMainKnowledgePoints(JAXBElement<String> value) {
        this.mainKnowledgePoints = value;
    }

    /**
     * 获取optionGroups属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroup }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionOptionGroup> getOptionGroups() {
        return optionGroups;
    }

    /**
     * 设置optionGroups属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroup }{@code >}
     *     
     */
    public void setOptionGroups(JAXBElement<ArrayOfQuestionOptionGroup> value) {
        this.optionGroups = value;
    }

    /**
     * 获取questionAudioUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionAudioUrl() {
        return questionAudioUrl;
    }

    /**
     * 设置questionAudioUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionAudioUrl(JAXBElement<String> value) {
        this.questionAudioUrl = value;
    }

    /**
     * 获取questionCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCategoryId() {
        return questionCategoryId;
    }

    /**
     * 设置questionCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCategoryId(Integer value) {
        this.questionCategoryId = value;
    }

    /**
     * 获取questionContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionContent() {
        return questionContent;
    }

    /**
     * 设置questionContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionContent(JAXBElement<String> value) {
        this.questionContent = value;
    }

    /**
     * 获取questionContentForDisplay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionContentForDisplay() {
        return questionContentForDisplay;
    }

    /**
     * 设置questionContentForDisplay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionContentForDisplay(JAXBElement<String> value) {
        this.questionContentForDisplay = value;
    }

    /**
     * 获取questionDisplayTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionDisplayTypeId() {
        return questionDisplayTypeId;
    }

    /**
     * 设置questionDisplayTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionDisplayTypeId(Integer value) {
        this.questionDisplayTypeId = value;
    }

    /**
     * 获取questionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 设置questionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionId(Integer value) {
        this.questionId = value;
    }

    /**
     * 获取questionLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQuestionLevel() {
        return questionLevel;
    }

    /**
     * 设置questionLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setQuestionLevel(Short value) {
        this.questionLevel = value;
    }

    /**
     * 获取questionQuality属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionQuality() {
        return questionQuality;
    }

    /**
     * 设置questionQuality属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionQuality(Integer value) {
        this.questionQuality = value;
    }

    /**
     * 获取questionSortingScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQuestionSortingScore() {
        return questionSortingScore;
    }

    /**
     * 设置questionSortingScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQuestionSortingScore(Double value) {
        this.questionSortingScore = value;
    }

    /**
     * 获取questionSource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionSource() {
        return questionSource;
    }

    /**
     * 设置questionSource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionSource(JAXBElement<String> value) {
        this.questionSource = value;
    }

    /**
     * 获取questionYear属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionYear() {
        return questionYear;
    }

    /**
     * 设置questionYear属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionYear(Integer value) {
        this.questionYear = value;
    }

    /**
     * 获取sectionMappings属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionChapterSectionMapping }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionChapterSectionMapping> getSectionMappings() {
        return sectionMappings;
    }

    /**
     * 设置sectionMappings属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionChapterSectionMapping }{@code >}
     *     
     */
    public void setSectionMappings(JAXBElement<ArrayOfQuestionChapterSectionMapping> value) {
        this.sectionMappings = value;
    }

    /**
     * 获取semanticLabels属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSemanticLabels() {
        return semanticLabels;
    }

    /**
     * 设置semanticLabels属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSemanticLabels(JAXBElement<String> value) {
        this.semanticLabels = value;
    }

    /**
     * 获取solveMethodLabel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSolveMethodLabel() {
        return solveMethodLabel;
    }

    /**
     * 设置solveMethodLabel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSolveMethodLabel(JAXBElement<String> value) {
        this.solveMethodLabel = value;
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

    /**
     * 获取supportOnline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportOnline() {
        return supportOnline;
    }

    /**
     * 设置supportOnline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportOnline(Boolean value) {
        this.supportOnline = value;
    }

    /**
     * 获取updateDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * 设置updateDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateDateTime(XMLGregorianCalendar value) {
        this.updateDateTime = value;
    }

    /**
     * 获取useRange属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUseRange() {
        return useRange;
    }

    /**
     * 设置useRange属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUseRange(JAXBElement<String> value) {
        this.useRange = value;
    }

}
