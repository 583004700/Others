
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExamUsageRulerView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ExamUsageRulerView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ImprovementRulerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ImprovementRulerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PredictionRulerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PredictionRulerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExamUsageRulerView", propOrder = {
    "improvementRulerId",
    "improvementRulerName",
    "predictionRulerId",
    "predictionRulerName"
})
public class ExamUsageRulerView {

    @XmlElement(name = "ImprovementRulerId")
    protected Integer improvementRulerId;
    @XmlElementRef(name = "ImprovementRulerName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> improvementRulerName;
    @XmlElement(name = "PredictionRulerId")
    protected Integer predictionRulerId;
    @XmlElementRef(name = "PredictionRulerName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> predictionRulerName;

    /**
     * 获取improvementRulerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImprovementRulerId() {
        return improvementRulerId;
    }

    /**
     * 设置improvementRulerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImprovementRulerId(Integer value) {
        this.improvementRulerId = value;
    }

    /**
     * 获取improvementRulerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImprovementRulerName() {
        return improvementRulerName;
    }

    /**
     * 设置improvementRulerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImprovementRulerName(JAXBElement<String> value) {
        this.improvementRulerName = value;
    }

    /**
     * 获取predictionRulerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPredictionRulerId() {
        return predictionRulerId;
    }

    /**
     * 设置predictionRulerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPredictionRulerId(Integer value) {
        this.predictionRulerId = value;
    }

    /**
     * 获取predictionRulerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPredictionRulerName() {
        return predictionRulerName;
    }

    /**
     * 设置predictionRulerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPredictionRulerName(JAXBElement<String> value) {
        this.predictionRulerName = value;
    }

}
