
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionStatisticsDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionStatisticsDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AverageTime" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="CorrectCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionOptionGroupId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionOptionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WrongCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionStatisticsDetail", propOrder = {
    "averageTime",
    "correctCount",
    "questionOptionGroupId",
    "questionOptionId",
    "wrongCount"
})
public class QuestionStatisticsDetail {

    @XmlElement(name = "AverageTime")
    protected Double averageTime;
    @XmlElement(name = "CorrectCount")
    protected Integer correctCount;
    @XmlElement(name = "QuestionOptionGroupId")
    protected Integer questionOptionGroupId;
    @XmlElementRef(name = "QuestionOptionId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionOptionId;
    @XmlElement(name = "WrongCount")
    protected Integer wrongCount;

    /**
     * 获取averageTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAverageTime() {
        return averageTime;
    }

    /**
     * 设置averageTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAverageTime(Double value) {
        this.averageTime = value;
    }

    /**
     * 获取correctCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorrectCount() {
        return correctCount;
    }

    /**
     * 设置correctCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorrectCount(Integer value) {
        this.correctCount = value;
    }

    /**
     * 获取questionOptionGroupId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionOptionGroupId() {
        return questionOptionGroupId;
    }

    /**
     * 设置questionOptionGroupId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionOptionGroupId(Integer value) {
        this.questionOptionGroupId = value;
    }

    /**
     * 获取questionOptionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionOptionId() {
        return questionOptionId;
    }

    /**
     * 设置questionOptionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionOptionId(JAXBElement<String> value) {
        this.questionOptionId = value;
    }

    /**
     * 获取wrongCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWrongCount() {
        return wrongCount;
    }

    /**
     * 设置wrongCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWrongCount(Integer value) {
        this.wrongCount = value;
    }

}
