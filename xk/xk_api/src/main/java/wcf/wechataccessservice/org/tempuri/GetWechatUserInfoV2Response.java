
package wcf.wechataccessservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatUserInfoView;


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
 *         &lt;element name="GetWechatUserInfoV2Result" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View}WeChatUserInfoView" minOccurs="0"/&gt;
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
    "getWechatUserInfoV2Result"
})
@XmlRootElement(name = "GetWechatUserInfoV2Response")
public class GetWechatUserInfoV2Response {

    @XmlElementRef(name = "GetWechatUserInfoV2Result", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<WeChatUserInfoView> getWechatUserInfoV2Result;

    /**
     * 获取getWechatUserInfoV2Result属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WeChatUserInfoView }{@code >}
     *     
     */
    public JAXBElement<WeChatUserInfoView> getGetWechatUserInfoV2Result() {
        return getWechatUserInfoV2Result;
    }

    /**
     * 设置getWechatUserInfoV2Result属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WeChatUserInfoView }{@code >}
     *     
     */
    public void setGetWechatUserInfoV2Result(JAXBElement<WeChatUserInfoView> value) {
        this.getWechatUserInfoV2Result = value;
    }

}
