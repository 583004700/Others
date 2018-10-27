
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.BookVersion;


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
 *         &lt;element name="GetBookVersionInfoResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}BookVersion" minOccurs="0"/&gt;
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
    "getBookVersionInfoResult"
})
@XmlRootElement(name = "GetBookVersionInfoResponse")
public class GetBookVersionInfoResponse {

    @XmlElementRef(name = "GetBookVersionInfoResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<BookVersion> getBookVersionInfoResult;

    /**
     * 获取getBookVersionInfoResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BookVersion }{@code >}
     *     
     */
    public JAXBElement<BookVersion> getGetBookVersionInfoResult() {
        return getBookVersionInfoResult;
    }

    /**
     * 设置getBookVersionInfoResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BookVersion }{@code >}
     *     
     */
    public void setGetBookVersionInfoResult(JAXBElement<BookVersion> value) {
        this.getBookVersionInfoResult = value;
    }

}
