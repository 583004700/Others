
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.ArrayOfOrderPayMode;


/**
 * <p>ServiceResultOfArrayOfOrderPayModedN_PiHdpe complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceResultOfArrayOfOrderPayModedN_PiHdpe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entity" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models}ArrayOfOrderPayMode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResultOfArrayOfOrderPayModedN_PiHdpe", propOrder = {
    "entity"
})
public class ServiceResultOfArrayOfOrderPayModedNPiHdpe
    extends ServiceResult
{

    @XmlElementRef(name = "Entity", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOrderPayMode> entity;

    /**
     * 获取entity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderPayMode }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOrderPayMode> getEntity() {
        return entity;
    }

    /**
     * 设置entity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOrderPayMode }{@code >}
     *     
     */
    public void setEntity(JAXBElement<ArrayOfOrderPayMode> value) {
        this.entity = value;
    }

}
