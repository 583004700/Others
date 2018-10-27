
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZujuanBasketQuestionCategoryStatisticsView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ZujuanBasketQuestionCategoryStatisticsView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Percentage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZujuanBasketQuestionCategoryStatisticsView", propOrder = {
    "count",
    "percentage",
    "questionCategoryId",
    "questionCategoryName"
})
public class ZujuanBasketQuestionCategoryStatisticsView {

    @XmlElement(name = "Count")
    protected Integer count;
    @XmlElement(name = "Percentage")
    protected Double percentage;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
    @XmlElementRef(name = "QuestionCategoryName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", type = JAXBElement.class)
    protected JAXBElement<String> questionCategoryName;

    /**
     * 获取count属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置count属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * 获取percentage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentage() {
        return percentage;
    }

    /**
     * 设置percentage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentage(Double value) {
        this.percentage = value;
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

}
