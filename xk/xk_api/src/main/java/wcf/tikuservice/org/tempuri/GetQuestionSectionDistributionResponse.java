
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfQuestionSectionDistributionView;


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
 *         &lt;element name="GetQuestionSectionDistributionResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}ArrayOfQuestionSectionDistributionView" minOccurs="0"/&gt;
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
    "getQuestionSectionDistributionResult"
})
@XmlRootElement(name = "GetQuestionSectionDistributionResponse")
public class GetQuestionSectionDistributionResponse {

    @XmlElementRef(name = "GetQuestionSectionDistributionResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionSectionDistributionView> getQuestionSectionDistributionResult;

    /**
     * 获取getQuestionSectionDistributionResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionSectionDistributionView }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionSectionDistributionView> getGetQuestionSectionDistributionResult() {
        return getQuestionSectionDistributionResult;
    }

    /**
     * 设置getQuestionSectionDistributionResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionSectionDistributionView }{@code >}
     *     
     */
    public void setGetQuestionSectionDistributionResult(JAXBElement<ArrayOfQuestionSectionDistributionView> value) {
        this.getQuestionSectionDistributionResult = value;
    }

}
