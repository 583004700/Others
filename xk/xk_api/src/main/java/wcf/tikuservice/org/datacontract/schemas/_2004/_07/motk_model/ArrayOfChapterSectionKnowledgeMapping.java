
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfChapterSectionKnowledgeMapping complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfChapterSectionKnowledgeMapping"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChapterSectionKnowledgeMapping" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ChapterSectionKnowledgeMapping" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfChapterSectionKnowledgeMapping", propOrder = {
    "chapterSectionKnowledgeMapping"
})
public class ArrayOfChapterSectionKnowledgeMapping {

    @XmlElement(name = "ChapterSectionKnowledgeMapping", nillable = true)
    protected List<ChapterSectionKnowledgeMapping> chapterSectionKnowledgeMapping;

    /**
     * Gets the value of the chapterSectionKnowledgeMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chapterSectionKnowledgeMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChapterSectionKnowledgeMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChapterSectionKnowledgeMapping }
     * 
     * 
     */
    public List<ChapterSectionKnowledgeMapping> getChapterSectionKnowledgeMapping() {
        if (chapterSectionKnowledgeMapping == null) {
            chapterSectionKnowledgeMapping = new ArrayList<ChapterSectionKnowledgeMapping>();
        }
        return this.chapterSectionKnowledgeMapping;
    }

}
