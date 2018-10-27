
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SelectQuestionScoreView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SelectQuestionScoreView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BackPageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsHomework" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryScores" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View}ArrayOfQuestionCategoryScoreView" minOccurs="0"/&gt;
 *         &lt;element name="TotalScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectQuestionScoreView", propOrder = {
    "backPageUrl",
    "isHomework",
    "questionCategoryScores",
    "totalScore"
})
public class SelectQuestionScoreView {

    @XmlElementRef(name = "BackPageUrl", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", type = JAXBElement.class)
    protected JAXBElement<String> backPageUrl;
    @XmlElement(name = "IsHomework")
    protected Boolean isHomework;
    @XmlElementRef(name = "QuestionCategoryScores", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionCategoryScoreView> questionCategoryScores;
    @XmlElement(name = "TotalScore")
    protected Integer totalScore;

    /**
     * 获取backPageUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBackPageUrl() {
        return backPageUrl;
    }

    /**
     * 设置backPageUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBackPageUrl(JAXBElement<String> value) {
        this.backPageUrl = value;
    }

    /**
     * 获取isHomework属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsHomework() {
        return isHomework;
    }

    /**
     * 设置isHomework属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsHomework(Boolean value) {
        this.isHomework = value;
    }

    /**
     * 获取questionCategoryScores属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryScoreView }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionCategoryScoreView> getQuestionCategoryScores() {
        return questionCategoryScores;
    }

    /**
     * 设置questionCategoryScores属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryScoreView }{@code >}
     *     
     */
    public void setQuestionCategoryScores(JAXBElement<ArrayOfQuestionCategoryScoreView> value) {
        this.questionCategoryScores = value;
    }

    /**
     * 获取totalScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     * 设置totalScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalScore(Integer value) {
        this.totalScore = value;
    }

}
