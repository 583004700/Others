
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * <p>QuestionSimplifiedFormat complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionSimplifiedFormat"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FinishTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointLabels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoint" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoints" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="QuestionQuality" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSortingScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="RealQuestionLevel" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="SectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SupportOnline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="UseRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UseRangeIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionSimplifiedFormat", propOrder = {
    "finishTime",
    "knowledgePointLabels",
    "mainKnowledgePoint",
    "mainKnowledgePoints",
    "questionCategoryId",
    "questionDisplayTypeId",
    "questionId",
    "questionLevel",
    "questionQuality",
    "questionSortingScore",
    "realQuestionLevel",
    "sectionId",
    "supportOnline",
    "useRange",
    "useRangeIds"
})
@XmlSeeAlso({
    QuestionSimplifiedFormatCache.class
})
public class QuestionSimplifiedFormat {

    @XmlElement(name = "FinishTime")
    protected Integer finishTime;
    @XmlElementRef(name = "KnowledgePointLabels", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> knowledgePointLabels;
    @XmlElement(name = "MainKnowledgePoint")
    protected Integer mainKnowledgePoint;
    @XmlElementRef(name = "MainKnowledgePoints", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfint> mainKnowledgePoints;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
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
    @XmlElement(name = "RealQuestionLevel")
    protected Double realQuestionLevel;
    @XmlElement(name = "SectionId")
    protected Integer sectionId;
    @XmlElement(name = "SupportOnline")
    protected Boolean supportOnline;
    @XmlElementRef(name = "UseRange", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> useRange;
    @XmlElementRef(name = "UseRangeIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfint> useRangeIds;

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
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getMainKnowledgePoints() {
        return mainKnowledgePoints;
    }

    /**
     * 设置mainKnowledgePoints属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setMainKnowledgePoints(JAXBElement<ArrayOfint> value) {
        this.mainKnowledgePoints = value;
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
     * 获取realQuestionLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRealQuestionLevel() {
        return realQuestionLevel;
    }

    /**
     * 设置realQuestionLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRealQuestionLevel(Double value) {
        this.realQuestionLevel = value;
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

    /**
     * 获取useRangeIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getUseRangeIds() {
        return useRangeIds;
    }

    /**
     * 设置useRangeIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setUseRangeIds(JAXBElement<ArrayOfint> value) {
        this.useRangeIds = value;
    }

}
