
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionOptionGroup complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionOptionGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Answers" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionOptionGroupAnswer" minOccurs="0"/&gt;
 *         &lt;element name="DisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Options" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfQuestionOption" minOccurs="0"/&gt;
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ParentGroupId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionOptionGroupId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionOptionGroup", propOrder = {
    "answers",
    "displayTypeId",
    "options",
    "order",
    "parentGroupId",
    "questionId",
    "questionOptionGroupId",
    "questionText"
})
public class QuestionOptionGroup {

    @XmlElementRef(name = "Answers", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionOptionGroupAnswer> answers;
    @XmlElement(name = "DisplayTypeId")
    protected Integer displayTypeId;
    @XmlElementRef(name = "Options", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionOption> options;
    @XmlElement(name = "Order")
    protected Integer order;
    @XmlElement(name = "ParentGroupId")
    protected Integer parentGroupId;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElement(name = "QuestionOptionGroupId")
    protected Integer questionOptionGroupId;
    @XmlElementRef(name = "QuestionText", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionText;

    /**
     * 获取answers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroupAnswer }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionOptionGroupAnswer> getAnswers() {
        return answers;
    }

    /**
     * 设置answers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroupAnswer }{@code >}
     *     
     */
    public void setAnswers(JAXBElement<ArrayOfQuestionOptionGroupAnswer> value) {
        this.answers = value;
    }

    /**
     * 获取displayTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisplayTypeId() {
        return displayTypeId;
    }

    /**
     * 设置displayTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisplayTypeId(Integer value) {
        this.displayTypeId = value;
    }

    /**
     * 获取options属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOption }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionOption> getOptions() {
        return options;
    }

    /**
     * 设置options属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionOption }{@code >}
     *     
     */
    public void setOptions(JAXBElement<ArrayOfQuestionOption> value) {
        this.options = value;
    }

    /**
     * 获取order属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置order属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * 获取parentGroupId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParentGroupId() {
        return parentGroupId;
    }

    /**
     * 设置parentGroupId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParentGroupId(Integer value) {
        this.parentGroupId = value;
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
     * 获取questionText属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionText() {
        return questionText;
    }

    /**
     * 设置questionText属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionText(JAXBElement<String> value) {
        this.questionText = value;
    }

}
