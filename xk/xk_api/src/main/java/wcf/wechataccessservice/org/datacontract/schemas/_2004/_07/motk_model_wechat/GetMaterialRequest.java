
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.WcfRequestBase;


/**
 * <p>GetMaterialRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetMaterialRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}WcfRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccessToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MediaIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMaterialRequest", propOrder = {
    "accessToken",
    "mediaIds"
})
public class GetMaterialRequest
    extends WcfRequestBase
{

    @XmlElementRef(name = "AccessToken", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", type = JAXBElement.class)
    protected JAXBElement<String> accessToken;
    @XmlElementRef(name = "MediaIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> mediaIds;

    /**
     * 获取accessToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccessToken() {
        return accessToken;
    }

    /**
     * 设置accessToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccessToken(JAXBElement<String> value) {
        this.accessToken = value;
    }

    /**
     * 获取mediaIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getMediaIds() {
        return mediaIds;
    }

    /**
     * 设置mediaIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setMediaIds(JAXBElement<ArrayOfstring> value) {
        this.mediaIds = value;
    }

}
