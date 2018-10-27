
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfKnowledgePointPoint complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfKnowledgePointPoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KnowledgePointPoint" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}KnowledgePointPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfKnowledgePointPoint", propOrder = {
    "knowledgePointPoint"
})
public class ArrayOfKnowledgePointPoint {

    @XmlElement(name = "KnowledgePointPoint", nillable = true)
    protected List<KnowledgePointPoint> knowledgePointPoint;

    /**
     * Gets the value of the knowledgePointPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knowledgePointPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnowledgePointPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KnowledgePointPoint }
     * 
     * 
     */
    public List<KnowledgePointPoint> getKnowledgePointPoint() {
        if (knowledgePointPoint == null) {
            knowledgePointPoint = new ArrayList<KnowledgePointPoint>();
        }
        return this.knowledgePointPoint;
    }

}
