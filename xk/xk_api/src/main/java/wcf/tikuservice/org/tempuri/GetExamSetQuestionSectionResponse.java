
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk.SimpleTree;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetExamSetQuestionSectionResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model}SimpleTree" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getExamSetQuestionSectionResult"
})
@XmlRootElement(name = "GetExamSetQuestionSectionResponse")
public class GetExamSetQuestionSectionResponse {

    @XmlElementRef(name = "GetExamSetQuestionSectionResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<SimpleTree> getExamSetQuestionSectionResult;

    /**
     * 获取getExamSetQuestionSectionResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}
     *     
     */
    public JAXBElement<SimpleTree> getGetExamSetQuestionSectionResult() {
        return getExamSetQuestionSectionResult;
    }

    /**
     * 设置getExamSetQuestionSectionResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}
     *     
     */
    public void setGetExamSetQuestionSectionResult(JAXBElement<SimpleTree> value) {
        this.getExamSetQuestionSectionResult = value;
    }

}
