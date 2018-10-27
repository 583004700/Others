
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionDisplayType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionDisplayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionDisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StatusFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *         &lt;element name="SupportArtificialGrading" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "QuestionDisplayType", propOrder = {
    "questionDisplayTypeId",
    "questionDisplayTypeName",
    "statusFlag",
    "supportArtificialGrading",
    "supportOnline"
})
public class QuestionDisplayType {

    @XmlElement(name = "QuestionDisplayTypeId")
    protected Integer questionDisplayTypeId;
    @XmlElementRef(name = "QuestionDisplayTypeName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionDisplayTypeName;
    @XmlElement(name = "StatusFlag")
    @XmlSchemaType(name = "unsignedByte")
    protected Short statusFlag;
    @XmlElement(name = "SupportArtificialGrading")
    protected Boolean supportArtificialGrading;
    @XmlElement(name = "SupportOnline")
    protected Boolean supportOnline;

    /**
     * 获取questionDisplayTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionDisplayTypeId() {
        return questionDisplayTypeId;
    }

    /**
     * 设置questionDisplayTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionDisplayTypeId(Integer value) {
        this.questionDisplayTypeId = value;
    }

    /**
     * 获取questionDisplayTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionDisplayTypeName() {
        return questionDisplayTypeName;
    }

    /**
     * 设置questionDisplayTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionDisplayTypeName(JAXBElement<String> value) {
        this.questionDisplayTypeName = value;
    }

    /**
     * 获取statusFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getStatusFlag() {
        return statusFlag;
    }

    /**
     * 设置statusFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setStatusFlag(Short value) {
        this.statusFlag = value;
    }

    /**
     * 获取supportArtificialGrading属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportArtificialGrading() {
        return supportArtificialGrading;
    }

    /**
     * 设置supportArtificialGrading属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportArtificialGrading(Boolean value) {
        this.supportArtificialGrading = value;
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
