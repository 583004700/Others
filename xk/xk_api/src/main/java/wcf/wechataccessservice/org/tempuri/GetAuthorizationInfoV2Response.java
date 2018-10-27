
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatAuthorizationInfoView;


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
 *         &lt;element name="GetAuthorizationInfoV2Result" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View}WeChatAuthorizationInfoView" minOccurs="0"/&gt;
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
    "getAuthorizationInfoV2Result"
})
@XmlRootElement(name = "GetAuthorizationInfoV2Response")
public class GetAuthorizationInfoV2Response {

    @XmlElementRef(name = "GetAuthorizationInfoV2Result", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<WeChatAuthorizationInfoView> getAuthorizationInfoV2Result;

    /**
     * 获取getAuthorizationInfoV2Result属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WeChatAuthorizationInfoView }{@code >}
     *     
     */
    public JAXBElement<WeChatAuthorizationInfoView> getGetAuthorizationInfoV2Result() {
        return getAuthorizationInfoV2Result;
    }

    /**
     * 设置getAuthorizationInfoV2Result属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WeChatAuthorizationInfoView }{@code >}
     *     
     */
    public void setGetAuthorizationInfoV2Result(JAXBElement<WeChatAuthorizationInfoView> value) {
        this.getAuthorizationInfoV2Result = value;
    }

}
