
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ResultBase;


/**
 * <p>WeChatAccessTokenView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatAccessTokenView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}ResultBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccessToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExpiresIn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="RefreshTick" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatAccessTokenView", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", propOrder = {
    "accessToken",
    "expiresIn",
    "refreshTick"
})
public class WeChatAccessTokenView
    extends ResultBase
{

    @XmlElementRef(name = "AccessToken", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> accessToken;
    @XmlElement(name = "ExpiresIn")
    protected Integer expiresIn;
    @XmlElement(name = "RefreshTick")
    protected Long refreshTick;

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
     * 获取expiresIn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置expiresIn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpiresIn(Integer value) {
        this.expiresIn = value;
    }

    /**
     * 获取refreshTick属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRefreshTick() {
        return refreshTick;
    }

    /**
     * 设置refreshTick属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRefreshTick(Long value) {
        this.refreshTick = value;
    }

}
