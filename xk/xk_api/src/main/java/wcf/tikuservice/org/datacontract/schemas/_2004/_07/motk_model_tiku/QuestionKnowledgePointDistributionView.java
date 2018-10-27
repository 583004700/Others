
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionKnowledgePointDistributionView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionKnowledgePointDistributionView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KnowledgePointId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="NumberOfQuestion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionKnowledgePointDistributionView", propOrder = {
    "knowledgePointId",
    "numberOfQuestion"
})
public class QuestionKnowledgePointDistributionView {

    @XmlElement(name = "KnowledgePointId")
    protected Integer knowledgePointId;
    @XmlElement(name = "NumberOfQuestion")
    protected Integer numberOfQuestion;

    /**
     * 获取knowledgePointId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKnowledgePointId() {
        return knowledgePointId;
    }

    /**
     * 设置knowledgePointId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKnowledgePointId(Integer value) {
        this.knowledgePointId = value;
    }

    /**
     * 获取numberOfQuestion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfQuestion() {
        return numberOfQuestion;
    }

    /**
     * 设置numberOfQuestion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfQuestion(Integer value) {
        this.numberOfQuestion = value;
    }

}
