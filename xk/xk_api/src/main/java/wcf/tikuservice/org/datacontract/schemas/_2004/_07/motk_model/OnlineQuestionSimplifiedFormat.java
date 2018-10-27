
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OnlineQuestionSimplifiedFormat complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OnlineQuestionSimplifiedFormat"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Capabilities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinishTime" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoint" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OtherKnowledgePoints" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSortingScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="RealQuestionLevel" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="SectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SolveMethodLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "OnlineQuestionSimplifiedFormat", propOrder = {
    "capabilities",
    "finishTime",
    "mainKnowledgePoint",
    "otherKnowledgePoints",
    "questionCategoryId",
    "questionDisplayTypeId",
    "questionId",
    "questionLevel",
    "questionSortingScore",
    "realQuestionLevel",
    "sectionId",
    "solveMethodLabel",
    "useRange"
})
public class OnlineQuestionSimplifiedFormat {

    @XmlElementRef(name = "Capabilities", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> capabilities;
    @XmlElement(name = "FinishTime")
    protected Double finishTime;
    @XmlElement(name = "MainKnowledgePoint")
    protected Integer mainKnowledgePoint;
    @XmlElementRef(name = "OtherKnowledgePoints", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> otherKnowledgePoints;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
    @XmlElement(name = "QuestionDisplayTypeId")
    protected Integer questionDisplayTypeId;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElement(name = "QuestionLevel")
    protected Short questionLevel;
    @XmlElement(name = "QuestionSortingScore")
    protected Double questionSortingScore;
    @XmlElement(name = "RealQuestionLevel")
    protected Double realQuestionLevel;
    @XmlElement(name = "SectionId")
    protected Integer sectionId;
    @XmlElementRef(name = "SolveMethodLabel", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> solveMethodLabel;
    @XmlElementRef(name = "UseRange", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> useRange;

    /**
     * 获取capabilities属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCapabilities() {
        return capabilities;
    }

    /**
     * 设置capabilities属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCapabilities(JAXBElement<String> value) {
        this.capabilities = value;
    }

    /**
     * 获取finishTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFinishTime() {
        return finishTime;
    }

    /**
     * 设置finishTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFinishTime(Double value) {
        this.finishTime = value;
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
     * 获取otherKnowledgePoints属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOtherKnowledgePoints() {
        return otherKnowledgePoints;
    }

    /**
     * 设置otherKnowledgePoints属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOtherKnowledgePoints(JAXBElement<String> value) {
        this.otherKnowledgePoints = value;
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
