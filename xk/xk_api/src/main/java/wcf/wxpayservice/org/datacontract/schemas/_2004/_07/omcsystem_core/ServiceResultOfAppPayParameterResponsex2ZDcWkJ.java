
package wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.AppPayParameterResponse;

/**
 * <p>ServiceResultOfAppPayParameterResponsex2zDcWkJ complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceResultOfAppPayParameterResponsex2zDcWkJ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entity" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models.Response}AppPayParameterResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResultOfAppPayParameterResponsex2zDcWkJ", propOrder = {"entity"})
public class ServiceResultOfAppPayParameterResponsex2ZDcWkJ extends ServiceResult
{

    @XmlElementRef(name = "Entity", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", type = JAXBElement.class)
    protected JAXBElement<AppPayParameterResponse> entity;

    /**
     * 获取entity属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link AppPayParameterResponse
     *         }{@code >}
     */
    public JAXBElement<AppPayParameterResponse> getEntity()
    {
        return entity;
    }

    /**
     * 设置entity属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link AppPayParameterResponse
     *            }{@code >}
     */
    public void setEntity(JAXBElement<AppPayParameterResponse> value)
    {
        this.entity = value;
    }

}
