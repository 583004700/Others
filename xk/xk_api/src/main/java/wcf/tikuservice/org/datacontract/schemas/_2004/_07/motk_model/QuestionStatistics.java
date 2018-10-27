
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>QuestionStatistics complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionStatistics"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CorrectCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Details" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionStatisticsDetail" minOccurs="0"/&gt;
 *         &lt;element name="DistinguishScore" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionSourceReferences" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *         &lt;element name="TotalTime" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="WrongCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "QuestionStatistics", propOrder = {
    "correctCount",
    "details",
    "distinguishScore",
    "questionId",
    "questionSourceReferences",
    "totalTime",
    "wrongCount",
    "zujuanCount"
})
public class QuestionStatistics {

    @XmlElement(name = "CorrectCount")
    protected Integer correctCount;
    @XmlElementRef(name = "Details", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionStatisticsDetail> details;
    @XmlElement(name = "DistinguishScore")
    protected Double distinguishScore;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElementRef(name = "QuestionSourceReferences", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> questionSourceReferences;
    @XmlElement(name = "TotalTime")
    protected Double totalTime;
    @XmlElement(name = "WrongCount")
    protected Integer wrongCount;
    @XmlElement(name = "ZujuanCount")
    protected Integer zujuanCount;

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
     * 获取details属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatisticsDetail }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionStatisticsDetail> getDetails() {
        return details;
    }

    /**
     * 设置details属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatisticsDetail }{@code >}
     *     
     */
    public void setDetails(JAXBElement<ArrayOfQuestionStatisticsDetail> value) {
        this.details = value;
    }

    /**
     * 获取distinguishScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistinguishScore() {
        return distinguishScore;
    }

    /**
     * 设置distinguishScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistinguishScore(Double value) {
        this.distinguishScore = value;
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
     * 获取questionSourceReferences属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getQuestionSourceReferences() {
        return questionSourceReferences;
    }

    /**
     * 设置questionSourceReferences属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setQuestionSourceReferences(JAXBElement<ArrayOfstring> value) {
        this.questionSourceReferences = value;
    }

    /**
     * 获取totalTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalTime() {
        return totalTime;
    }

    /**
     * 设置totalTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalTime(Double value) {
        this.totalTime = value;
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
