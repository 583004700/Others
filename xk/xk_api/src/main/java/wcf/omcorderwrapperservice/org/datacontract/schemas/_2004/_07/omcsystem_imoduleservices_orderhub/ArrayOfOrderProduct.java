
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfOrderProduct complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOrderProduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderProduct" type="{http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models}OrderProduct" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOrderProduct", propOrder = {
    "orderProduct"
})
public class ArrayOfOrderProduct {

    @XmlElement(name = "OrderProduct", nillable = true)
    protected List<OrderProduct> orderProduct;

    /**
     * Gets the value of the orderProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderProduct }
     * 
     * 
     */
    public List<OrderProduct> getOrderProduct() {
        if (orderProduct == null) {
            orderProduct = new ArrayList<OrderProduct>();
        }
        return this.orderProduct;
    }

}
