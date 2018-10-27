
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.ScanCodeCallbackParam;

/**
 * <p>anonymous complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="paras" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat}ScanCodeCallbackParam" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"paras"})
@XmlRootElement(name = "ScanCodeCallback")
public class ScanCodeCallback
{

    @XmlElementRef(name = "paras", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ScanCodeCallbackParam> paras;

    /**
     * 获取paras属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link ScanCodeCallbackParam
     *         }{@code >}
     */
    public JAXBElement<ScanCodeCallbackParam> getParas()
    {
        return paras;
    }

    /**
     * 设置paras属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link ScanCodeCallbackParam
     *            }{@code >}
     */
    public void setParas(JAXBElement<ScanCodeCallbackParam> value)
    {
        this.paras = value;
    }

}
