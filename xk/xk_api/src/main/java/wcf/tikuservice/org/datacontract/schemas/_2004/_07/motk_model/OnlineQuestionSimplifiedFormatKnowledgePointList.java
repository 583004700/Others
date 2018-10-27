
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OnlineQuestionSimplifiedFormatKnowledgePointList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OnlineQuestionSimplifiedFormatKnowledgePointList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Questions" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfOnlineQuestionSimplifiedFormat" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnlineQuestionSimplifiedFormatKnowledgePointList", propOrder = {
    "bookVersionId",
    "knowledgePointId",
    "questions"
})
public class OnlineQuestionSimplifiedFormatKnowledgePointList {

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElement(name = "KnowledgePointId")
    protected Integer knowledgePointId;
    @XmlElementRef(name = "Questions", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> questions;

    /**
     * 获取bookVersionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookVersionId() {
        return bookVersionId;
    }

    /**
     * 设置bookVersionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookVersionId(Integer value) {
        this.bookVersionId = value;
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
     * 获取questions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOnlineQuestionSimplifiedFormat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> getQuestions() {
        return questions;
    }

    /**
     * 设置questions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOnlineQuestionSimplifiedFormat }{@code >}
     *     
     */
    public void setQuestions(JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> value) {
        this.questions = value;
    }

}
