
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ClassRoomEvaluationDefaultSelected;


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
 *         &lt;element name="GetClassRoomEvaluationDefaultSelectedResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ClassRoomEvaluationDefaultSelected" minOccurs="0"/&gt;
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
    "getClassRoomEvaluationDefaultSelectedResult"
})
@XmlRootElement(name = "GetClassRoomEvaluationDefaultSelectedResponse")
public class GetClassRoomEvaluationDefaultSelectedResponse {

    @XmlElementRef(name = "GetClassRoomEvaluationDefaultSelectedResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ClassRoomEvaluationDefaultSelected> getClassRoomEvaluationDefaultSelectedResult;

    /**
     * 获取getClassRoomEvaluationDefaultSelectedResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ClassRoomEvaluationDefaultSelected }{@code >}
     *     
     */
    public JAXBElement<ClassRoomEvaluationDefaultSelected> getGetClassRoomEvaluationDefaultSelectedResult() {
        return getClassRoomEvaluationDefaultSelectedResult;
    }

    /**
     * 设置getClassRoomEvaluationDefaultSelectedResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ClassRoomEvaluationDefaultSelected }{@code >}
     *     
     */
    public void setGetClassRoomEvaluationDefaultSelectedResult(JAXBElement<ClassRoomEvaluationDefaultSelected> value) {
        this.getClassRoomEvaluationDefaultSelectedResult = value;
    }

}
