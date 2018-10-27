
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionOptionGroup;


/**
 * <p>QuestionView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Analysis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Answer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointLabels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePoint" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="MainKnowledgePointValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OptionGroups" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionOptionGroup" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SupportOnline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TotalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="UpdateDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ZujuanCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionView", propOrder = {
    "analysis",
    "answer",
    "knowledgePointLabels",
    "mainKnowledgePoint",
    "mainKnowledgePointValue",
    "optionGroups",
    "questionCategoryId",
    "questionCategoryName",
    "questionCategoryOrder",
    "questionContent",
    "questionDisplayId",
    "questionId",
    "questionLevel",
    "questionLevelText",
    "questionScore",
    "questionSource",
    "supportOnline",
    "totalCount",
    "updateDateTime",
    "zujuanCount"
})
public class QuestionView {

    @XmlElementRef(name = "Analysis", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> analysis;
    @XmlElementRef(name = "Answer", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> answer;
    @XmlElementRef(name = "KnowledgePointLabels", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> knowledgePointLabels;
    @XmlElement(name = "MainKnowledgePoint")
    protected Integer mainKnowledgePoint;
    @XmlElementRef(name = "MainKnowledgePointValue", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> mainKnowledgePointValue;
    @XmlElementRef(name = "OptionGroups", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionOptionGroup> optionGroups;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
    @XmlElementRef(name = "QuestionCategoryName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> questionCategoryName;
    @XmlElement(name = "QuestionCategoryOrder")
    protected Integer questionCategoryOrder;
    @XmlElementRef(name = "QuestionContent", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> questionContent;
    @XmlElement(name = "QuestionDisplayId")
    protected Integer questionDisplayId;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElement(name = "QuestionLevel")
    protected Short questionLevel;
    @XmlElementRef(name = "QuestionLevelText", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> questionLevelText;
    @XmlElement(name = "QuestionScore")
    protected Double questionScore;
    @XmlElementRef(name = "QuestionSource", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> questionSource;
    @XmlElement(name = "SupportOnline")
    protected Boolean supportOnline;
    @XmlElement(name = "TotalCount")
    protected Integer totalCount;
    @XmlElement(name = "UpdateDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateDateTime;
    @XmlElement(name = "ZujuanCount")
    protected Integer zujuanCount;

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
     * 获取answer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAnswer() {
        return answer;
    }

    /**
     * 设置answer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAnswer(JAXBElement<String> value) {
        this.answer = value;
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
     * 获取mainKnowledgePointValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMainKnowledgePointValue() {
        return mainKnowledgePointValue;
    }

    /**
     * 设置mainKnowledgePointValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMainKnowledgePointValue(JAXBElement<String> value) {
        this.mainKnowledgePointValue = value;
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
     * 获取questionCategoryName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionCategoryName() {
        return questionCategoryName;
    }

    /**
     * 设置questionCategoryName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionCategoryName(JAXBElement<String> value) {
        this.questionCategoryName = value;
    }

    /**
     * 获取questionCategoryOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCategoryOrder() {
        return questionCategoryOrder;
    }

    /**
     * 设置questionCategoryOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCategoryOrder(Integer value) {
        this.questionCategoryOrder = value;
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
     * 获取questionDisplayId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionDisplayId() {
        return questionDisplayId;
    }

    /**
     * 设置questionDisplayId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionDisplayId(Integer value) {
        this.questionDisplayId = value;
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
     * 获取questionLevelText属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionLevelText() {
        return questionLevelText;
    }

    /**
     * 设置questionLevelText属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionLevelText(JAXBElement<String> value) {
        this.questionLevelText = value;
    }

    /**
     * 获取questionScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQuestionScore() {
        return questionScore;
    }

    /**
     * 设置questionScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQuestionScore(Double value) {
        this.questionScore = value;
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
     * 获取totalCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置totalCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
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
     * 获取zujuanCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZujuanCount() {
        return zujuanCount;
    }

    /**
     * 设置zujuanCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZujuanCount(Integer value) {
        this.zujuanCount = value;
    }

}
