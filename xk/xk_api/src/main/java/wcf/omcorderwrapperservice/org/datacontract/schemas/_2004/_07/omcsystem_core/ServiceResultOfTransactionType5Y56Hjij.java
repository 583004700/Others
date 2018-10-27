
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TransactionType;


/**
 * <p>ServiceResultOfTransactionType5Y56Hjij complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ServiceResultOfTransactionType5Y56Hjij"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entity" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}TransactionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResultOfTransactionType5Y56Hjij", propOrder = {
    "entity"
})
public class ServiceResultOfTransactionType5Y56Hjij
    extends ServiceResult
{

    @XmlElement(name = "Entity")
    @XmlSchemaType(name = "string")
    protected TransactionType entity;

    /**
     * 获取entity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getEntity() {
        return entity;
    }

    /**
     * 设置entity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setEntity(TransactionType value) {
        this.entity = value;
    }

}
