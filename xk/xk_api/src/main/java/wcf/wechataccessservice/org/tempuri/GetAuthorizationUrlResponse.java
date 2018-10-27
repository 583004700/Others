
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetAuthorizeUrlView;


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
 *         &lt;element name="GetAuthorizationUrlResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View}GetAuthorizeUrlView" minOccurs="0"/&gt;
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
    "getAuthorizationUrlResult"
})
@XmlRootElement(name = "GetAuthorizationUrlResponse")
public class GetAuthorizationUrlResponse {

    @XmlElementRef(name = "GetAuthorizationUrlResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<GetAuthorizeUrlView> getAuthorizationUrlResult;

    /**
     * 获取getAuthorizationUrlResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetAuthorizeUrlView }{@code >}
     *     
     */
    public JAXBElement<GetAuthorizeUrlView> getGetAuthorizationUrlResult() {
        return getAuthorizationUrlResult;
    }

    /**
     * 设置getAuthorizationUrlResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetAuthorizeUrlView }{@code >}
     *     
     */
    public void setGetAuthorizationUrlResult(JAXBElement<GetAuthorizeUrlView> value) {
        this.getAuthorizationUrlResult = value;
    }

}
