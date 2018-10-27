
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>KnowledgePointPoint complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KnowledgePointPoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KnowledgePointFullPoint" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParentKnowledgePointName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="RelatedQuestions" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfKnowledgePointPointQuestion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgePointPoint", propOrder = {
    "knowledgePointFullPoint",
    "knowledgePointId",
    "knowledgePointName",
    "parentKnowledgePointName",
    "questionLevel",
    "relatedQuestions"
})
public class KnowledgePointPoint {

    @XmlElement(name = "KnowledgePointFullPoint")
    protected Double knowledgePointFullPoint;
    @XmlElement(name = "KnowledgePointId")
    protected Integer knowledgePointId;
    @XmlElementRef(name = "KnowledgePointName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> knowledgePointName;
    @XmlElementRef(name = "ParentKnowledgePointName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> parentKnowledgePointName;
    @XmlElement(name = "QuestionLevel")
    protected Double questionLevel;
    @XmlElementRef(name = "RelatedQuestions", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKnowledgePointPointQuestion> relatedQuestions;

    /**
     * 获取knowledgePointFullPoint属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getKnowledgePointFullPoint() {
        return knowledgePointFullPoint;
    }

    /**
     * 设置knowledgePointFullPoint属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setKnowledgePointFullPoint(Double value) {
        this.knowledgePointFullPoint = value;
    }

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
     * 获取knowledgePointName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKnowledgePointName() {
        return knowledgePointName;
    }

    /**
     * 设置knowledgePointName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKnowledgePointName(JAXBElement<String> value) {
        this.knowledgePointName = value;
    }

    /**
     * 获取parentKnowledgePointName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParentKnowledgePointName() {
        return parentKnowledgePointName;
    }

    /**
     * 设置parentKnowledgePointName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParentKnowledgePointName(JAXBElement<String> value) {
        this.parentKnowledgePointName = value;
    }

    /**
     * 获取questionLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQuestionLevel() {
        return questionLevel;
    }

    /**
     * 设置questionLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQuestionLevel(Double value) {
        this.questionLevel = value;
    }

    /**
     * 获取relatedQuestions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPointQuestion }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKnowledgePointPointQuestion> getRelatedQuestions() {
        return relatedQuestions;
    }

    /**
     * 设置relatedQuestions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPointQuestion }{@code >}
     *     
     */
    public void setRelatedQuestions(JAXBElement<ArrayOfKnowledgePointPointQuestion> value) {
        this.relatedQuestions = value;
    }

}
