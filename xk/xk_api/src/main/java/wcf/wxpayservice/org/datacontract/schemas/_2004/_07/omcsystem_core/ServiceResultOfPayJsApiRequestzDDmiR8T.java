
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.PayJsApiRequest;

/**
 * <p>ServiceResultOfPayJsApiRequestzDDmiR8T complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceResultOfPayJsApiRequestzDDmiR8T"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entity" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.WeChat.Models.WeChat}PayJsApiRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResultOfPayJsApiRequestzDDmiR8T", propOrder = {"entity"})
public class ServiceResultOfPayJsApiRequestzDDmiR8T extends ServiceResult
{

    @XmlElementRef(name = "Entity", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", type = JAXBElement.class)
    protected JAXBElement<PayJsApiRequest> entity;

    /**
     * 获取entity属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link PayJsApiRequest }{@code >}
     */
    public JAXBElement<PayJsApiRequest> getEntity()
    {
        return entity;
    }

    /**
     * 设置entity属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link PayJsApiRequest }{@code >}
     */
    public void setEntity(JAXBElement<PayJsApiRequest> value)
    {
        this.entity = value;
    }

}
