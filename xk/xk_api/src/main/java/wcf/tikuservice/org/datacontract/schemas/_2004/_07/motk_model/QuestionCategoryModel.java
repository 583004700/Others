
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionCategoryModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionCategoryModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionCategoryModelId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryModelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SupportOnline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionCategoryModel", propOrder = {
    "questionCategoryModelId",
    "questionCategoryModelName",
    "supportOnline"
})
public class QuestionCategoryModel {

    @XmlElement(name = "QuestionCategoryModelId")
    protected Integer questionCategoryModelId;
    @XmlElementRef(name = "QuestionCategoryModelName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionCategoryModelName;
    @XmlElement(name = "SupportOnline")
    protected Boolean supportOnline;

    /**
     * 获取questionCategoryModelId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCategoryModelId() {
        return questionCategoryModelId;
    }

    /**
     * 设置questionCategoryModelId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCategoryModelId(Integer value) {
        this.questionCategoryModelId = value;
    }

    /**
     * 获取questionCategoryModelName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionCategoryModelName() {
        return questionCategoryModelName;
    }

    /**
     * 设置questionCategoryModelName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionCategoryModelName(JAXBElement<String> value) {
        this.questionCategoryModelName = value;
    }

    /**
     * 获取supportOnline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportOnline() {
        return supportOnline;
    }

    /**
     * 设置supportOnline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportOnline(Boolean value) {
        this.supportOnline = value;
    }

}
