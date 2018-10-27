
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>KnowledgePointPointQuestion complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KnowledgePointPointQuestion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Question" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}QuestionSimplifiedFormat" minOccurs="0"/&gt;
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgePointPointQuestion", propOrder = {
    "question",
    "weight"
})
public class KnowledgePointPointQuestion {

    @XmlElementRef(name = "Question", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<QuestionSimplifiedFormat> question;
    @XmlElement(name = "Weight")
    protected Double weight;

    /**
     * 获取question属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QuestionSimplifiedFormat }{@code >}
     *     
     */
    public JAXBElement<QuestionSimplifiedFormat> getQuestion() {
        return question;
    }

    /**
     * 设置question属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QuestionSimplifiedFormat }{@code >}
     *     
     */
    public void setQuestion(JAXBElement<QuestionSimplifiedFormat> value) {
        this.question = value;
    }

    /**
     * 获取weight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置weight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

}
