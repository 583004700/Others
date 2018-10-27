
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SendWeChatPayRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SendWeChatPayRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.Request}WeChatPayRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PayMethod" type="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.WeChat}PayMethod" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendWeChatPayRequest", propOrder = {
    "payMethod"
})
public class SendWeChatPayRequest
    extends WeChatPayRequestBase
{

    @XmlElement(name = "PayMethod")
    @XmlSchemaType(name = "string")
    protected PayMethod payMethod;

    /**
     * 获取payMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PayMethod }
     *     
     */
    public PayMethod getPayMethod() {
        return payMethod;
    }

    /**
     * 设置payMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PayMethod }
     *     
     */
    public void setPayMethod(PayMethod value) {
        this.payMethod = value;
    }

}
