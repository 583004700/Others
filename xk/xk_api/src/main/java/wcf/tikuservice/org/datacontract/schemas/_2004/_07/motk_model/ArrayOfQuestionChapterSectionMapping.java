
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfQuestionChapterSectionMapping complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfQuestionChapterSectionMapping"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionChapterSectionMapping" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}QuestionChapterSectionMapping" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfQuestionChapterSectionMapping", propOrder = {
    "questionChapterSectionMapping"
})
public class ArrayOfQuestionChapterSectionMapping {

    @XmlElement(name = "QuestionChapterSectionMapping", nillable = true)
    protected List<QuestionChapterSectionMapping> questionChapterSectionMapping;

    /**
     * Gets the value of the questionChapterSectionMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the questionChapterSectionMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionChapterSectionMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuestionChapterSectionMapping }
     * 
     * 
     */
    public List<QuestionChapterSectionMapping> getQuestionChapterSectionMapping() {
        if (questionChapterSectionMapping == null) {
            questionChapterSectionMapping = new ArrayList<QuestionChapterSectionMapping>();
        }
        return this.questionChapterSectionMapping;
    }

}
