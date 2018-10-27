
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfSchoolBookVersion;


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
 *         &lt;element name="GetSchoolBookVersionResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ArrayOfSchoolBookVersion" minOccurs="0"/&gt;
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
    "getSchoolBookVersionResult"
})
@XmlRootElement(name = "GetSchoolBookVersionResponse")
public class GetSchoolBookVersionResponse {

    @XmlElementRef(name = "GetSchoolBookVersionResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSchoolBookVersion> getSchoolBookVersionResult;

    /**
     * 获取getSchoolBookVersionResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSchoolBookVersion }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSchoolBookVersion> getGetSchoolBookVersionResult() {
        return getSchoolBookVersionResult;
    }

    /**
     * 设置getSchoolBookVersionResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSchoolBookVersion }{@code >}
     *     
     */
    public void setGetSchoolBookVersionResult(JAXBElement<ArrayOfSchoolBookVersion> value) {
        this.getSchoolBookVersionResult = value;
    }

}
