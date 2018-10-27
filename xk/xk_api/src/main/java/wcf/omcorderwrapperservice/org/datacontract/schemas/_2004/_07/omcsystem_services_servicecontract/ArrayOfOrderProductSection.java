
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfOrderProductSection complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOrderProductSection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderProductSection" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Services.ServiceContract.Model}OrderProductSection" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOrderProductSection", propOrder = {
    "orderProductSection"
})
public class ArrayOfOrderProductSection {

    @XmlElement(name = "OrderProductSection", nillable = true)
    protected List<OrderProductSection> orderProductSection;

    /**
     * Gets the value of the orderProductSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderProductSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderProductSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderProductSection }
     * 
     * 
     */
    public List<OrderProductSection> getOrderProductSection() {
        if (orderProductSection == null) {
            orderProductSection = new ArrayList<OrderProductSection>();
        }
        return this.orderProductSection;
    }

}
