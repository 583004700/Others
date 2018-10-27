
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestBase;


/**
 * <p>GetOnlineQuestionsForKnowledgePointRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetOnlineQuestionsForKnowledgePointRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}RequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgePointId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOnlineQuestionsForKnowledgePointRequest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", propOrder = {
    "bookVersionId",
    "knowledgePointId"
})
public class GetOnlineQuestionsForKnowledgePointRequest
    extends RequestBase
{

    @XmlElement(name = "BookVersionId")
    protected Integer bookVersionId;
    @XmlElement(name = "KnowledgePointId")
    protected Integer knowledgePointId;

    /**
     * 获取bookVersionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookVersionId() {
        return bookVersionId;
    }

    /**
     * 设置bookVersionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookVersionId(Integer value) {
        this.bookVersionId = value;
    }

    /**
     * 获取knowledgePointId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKnowledgePointId() {
        return knowledgePointId;
    }

    /**
     * 设置knowledgePointId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKnowledgePointId(Integer value) {
        this.knowledgePointId = value;
    }

}
