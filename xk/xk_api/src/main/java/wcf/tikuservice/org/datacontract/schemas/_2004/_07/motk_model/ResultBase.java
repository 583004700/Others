
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.CheckSCPQuestionView;


/**
 * <p>ResultBase complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ResultBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResultType" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}ResultTypeEnum" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultBase", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", propOrder = {
    "message",
    "resultType"
})
@XmlSeeAlso({
    CheckSCPQuestionView.class
})
public class ResultBase {

    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElement(name = "ResultType")
    @XmlSchemaType(name = "string")
    protected ResultTypeEnum resultType;

    /**
     * 获取message属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * 设置message属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = value;
    }

    /**
     * 获取resultType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResultTypeEnum }
     *     
     */
    public ResultTypeEnum getResultType() {
        return resultType;
    }

    /**
     * 设置resultType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTypeEnum }
     *     
     */
    public void setResultType(ResultTypeEnum value) {
        this.resultType = value;
    }

}
