
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfQuestionKnowledgePointDistributionView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfQuestionKnowledgePointDistributionView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionKnowledgePointDistributionView" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}QuestionKnowledgePointDistributionView" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfQuestionKnowledgePointDistributionView", propOrder = {
    "questionKnowledgePointDistributionView"
})
public class ArrayOfQuestionKnowledgePointDistributionView {

    @XmlElement(name = "QuestionKnowledgePointDistributionView", nillable = true)
    protected List<QuestionKnowledgePointDistributionView> questionKnowledgePointDistributionView;

    /**
     * Gets the value of the questionKnowledgePointDistributionView property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the questionKnowledgePointDistributionView property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionKnowledgePointDistributionView().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuestionKnowledgePointDistributionView }
     * 
     * 
     */
    public List<QuestionKnowledgePointDistributionView> getQuestionKnowledgePointDistributionView() {
        if (questionKnowledgePointDistributionView == null) {
            questionKnowledgePointDistributionView = new ArrayList<QuestionKnowledgePointDistributionView>();
        }
        return this.questionKnowledgePointDistributionView;
    }

}
