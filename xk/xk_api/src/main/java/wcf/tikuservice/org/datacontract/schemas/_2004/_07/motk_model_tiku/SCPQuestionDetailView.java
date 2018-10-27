
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SCPQuestionDetailView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SCPQuestionDetailView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Questions" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}ArrayOfSCPQuestionDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SCPQuestionDetailView", propOrder = {
    "questions"
})
public class SCPQuestionDetailView {

    @XmlElementRef(name = "Questions", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSCPQuestionDetail> questions;

    /**
     * 获取questions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionDetail }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSCPQuestionDetail> getQuestions() {
        return questions;
    }

    /**
     * 设置questions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionDetail }{@code >}
     *     
     */
    public void setQuestions(JAXBElement<ArrayOfSCPQuestionDetail> value) {
        this.questions = value;
    }

}
