
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.WcfRequestBase;


/**
 * <p>WechatTransferRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WechatTransferRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}WcfRequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WechatTransfer" type="{http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request}WechatTransferModel" minOccurs="0"/&gt;
 *         &lt;element name="WithdrawCertificateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WechatTransferRequest", propOrder = {
    "wechatTransfer",
    "withdrawCertificateNumber"
})
public class WechatTransferRequest
    extends WcfRequestBase
{

    @XmlElementRef(name = "WechatTransfer", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", type = JAXBElement.class)
    protected JAXBElement<WechatTransferModel> wechatTransfer;
    @XmlElementRef(name = "WithdrawCertificateNumber", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat.Request", type = JAXBElement.class)
    protected JAXBElement<String> withdrawCertificateNumber;

    /**
     * 获取wechatTransfer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WechatTransferModel }{@code >}
     *     
     */
    public JAXBElement<WechatTransferModel> getWechatTransfer() {
        return wechatTransfer;
    }

    /**
     * 设置wechatTransfer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WechatTransferModel }{@code >}
     *     
     */
    public void setWechatTransfer(JAXBElement<WechatTransferModel> value) {
        this.wechatTransfer = value;
    }

    /**
     * 获取withdrawCertificateNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWithdrawCertificateNumber() {
        return withdrawCertificateNumber;
    }

    /**
     * 设置withdrawCertificateNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWithdrawCertificateNumber(JAXBElement<String> value) {
        this.withdrawCertificateNumber = value;
    }

}
