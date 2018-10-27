
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.CheckSCPQuestionView;


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
 *         &lt;element name="CheckSCPQuestionResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}CheckSCPQuestionView" minOccurs="0"/&gt;
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
    "checkSCPQuestionResult"
})
@XmlRootElement(name = "CheckSCPQuestionResponse")
public class CheckSCPQuestionResponse {

    @XmlElementRef(name = "CheckSCPQuestionResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<CheckSCPQuestionView> checkSCPQuestionResult;

    /**
     * 获取checkSCPQuestionResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CheckSCPQuestionView }{@code >}
     *     
     */
    public JAXBElement<CheckSCPQuestionView> getCheckSCPQuestionResult() {
        return checkSCPQuestionResult;
    }

    /**
     * 设置checkSCPQuestionResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CheckSCPQuestionView }{@code >}
     *     
     */
    public void setCheckSCPQuestionResult(JAXBElement<CheckSCPQuestionView> value) {
        this.checkSCPQuestionResult = value;
    }

}
