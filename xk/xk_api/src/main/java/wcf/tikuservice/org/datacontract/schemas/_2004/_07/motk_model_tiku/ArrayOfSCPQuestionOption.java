
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfSCPQuestionOption complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSCPQuestionOption"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SCPQuestionOption" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}SCPQuestionOption" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSCPQuestionOption", propOrder = {
    "scpQuestionOption"
})
public class ArrayOfSCPQuestionOption {

    @XmlElement(name = "SCPQuestionOption", nillable = true)
    protected List<SCPQuestionOption> scpQuestionOption;

    /**
     * Gets the value of the scpQuestionOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scpQuestionOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSCPQuestionOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SCPQuestionOption }
     * 
     * 
     */
    public List<SCPQuestionOption> getSCPQuestionOption() {
        if (scpQuestionOption == null) {
            scpQuestionOption = new ArrayList<SCPQuestionOption>();
        }
        return this.scpQuestionOption;
    }

}
