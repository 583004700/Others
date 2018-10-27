
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePoint;


/**
 * <p>KnowledgePointView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KnowledgePointView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KnowledgePoint" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}KnowledgePoint" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgePointView", propOrder = {
    "knowledgePoint",
    "questionCount"
})
public class KnowledgePointView {

    @XmlElementRef(name = "KnowledgePoint", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<KnowledgePoint> knowledgePoint;
    @XmlElement(name = "QuestionCount")
    protected Integer questionCount;

    /**
     * 获取knowledgePoint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link KnowledgePoint }{@code >}
     *     
     */
    public JAXBElement<KnowledgePoint> getKnowledgePoint() {
        return knowledgePoint;
    }

    /**
     * 设置knowledgePoint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link KnowledgePoint }{@code >}
     *     
     */
    public void setKnowledgePoint(JAXBElement<KnowledgePoint> value) {
        this.knowledgePoint = value;
    }

    /**
     * 获取questionCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCount() {
        return questionCount;
    }

    /**
     * 设置questionCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCount(Integer value) {
        this.questionCount = value;
    }

}
