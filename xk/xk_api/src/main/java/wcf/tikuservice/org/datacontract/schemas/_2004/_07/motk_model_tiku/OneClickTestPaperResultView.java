
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionSimplifiedFormat;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam.SelectQuestionScoreView;


/**
 * <p>OneClickTestPaperResultView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OneClickTestPaperResultView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionCategoryScore" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View}SelectQuestionScoreView" minOccurs="0"/&gt;
 *         &lt;element name="Questions" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionSimplifiedFormat" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneClickTestPaperResultView", propOrder = {
    "questionCategoryScore",
    "questions"
})
public class OneClickTestPaperResultView {

    @XmlElementRef(name = "QuestionCategoryScore", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<SelectQuestionScoreView> questionCategoryScore;
    @XmlElementRef(name = "Questions", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionSimplifiedFormat> questions;

    /**
     * 获取questionCategoryScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SelectQuestionScoreView }{@code >}
     *     
     */
    public JAXBElement<SelectQuestionScoreView> getQuestionCategoryScore() {
        return questionCategoryScore;
    }

    /**
     * 设置questionCategoryScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SelectQuestionScoreView }{@code >}
     *     
     */
    public void setQuestionCategoryScore(JAXBElement<SelectQuestionScoreView> value) {
        this.questionCategoryScore = value;
    }

    /**
     * 获取questions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionSimplifiedFormat> getQuestions() {
        return questions;
    }

    /**
     * 设置questions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}
     *     
     */
    public void setQuestions(JAXBElement<ArrayOfQuestionSimplifiedFormat> value) {
        this.questions = value;
    }

}
