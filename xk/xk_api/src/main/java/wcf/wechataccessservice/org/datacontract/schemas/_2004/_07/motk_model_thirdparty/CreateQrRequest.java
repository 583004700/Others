
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreateQrRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreateQrRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request}WeChatRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExpireSeconds" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/&gt;
 *         &lt;element name="SceneId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateQrRequest", propOrder = {
    "expireSeconds",
    "sceneId"
})
public class CreateQrRequest
    extends WeChatRequestBase
{

    @XmlElement(name = "ExpireSeconds")
    @XmlSchemaType(name = "unsignedInt")
    protected Long expireSeconds;
    @XmlElement(name = "SceneId")
    protected Integer sceneId;

    /**
     * 获取expireSeconds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExpireSeconds() {
        return expireSeconds;
    }

    /**
     * 设置expireSeconds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExpireSeconds(Long value) {
        this.expireSeconds = value;
    }

    /**
     * 获取sceneId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSceneId() {
        return sceneId;
    }

    /**
     * 设置sceneId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSceneId(Integer value) {
        this.sceneId = value;
    }

}
