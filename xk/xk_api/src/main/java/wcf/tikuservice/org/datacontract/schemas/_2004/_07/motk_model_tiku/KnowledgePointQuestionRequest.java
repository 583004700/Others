
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestBase;


/**
 * <p>KnowledgePointQuestionRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KnowledgePointQuestionRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}RequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="MaxLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ParentKnowledgePointId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SupportOnline" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="UserBookVersionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KnowledgePointQuestionRequest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", propOrder = {
    "courseId",
    "maxLevel",
    "parentKnowledgePointId",
    "supportOnline",
    "userBookVersionId"
})
public class KnowledgePointQuestionRequest
    extends RequestBase
{

    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "MaxLevel")
    protected Integer maxLevel;
    @XmlElement(name = "ParentKnowledgePointId")
    protected Integer parentKnowledgePointId;
    @XmlElement(name = "SupportOnline")
    protected Integer supportOnline;
    @XmlElement(name = "UserBookVersionId")
    protected Integer userBookVersionId;

    /**
     * 获取courseId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置courseId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCourseId(Integer value) {
        this.courseId = value;
    }

    /**
     * 获取maxLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxLevel() {
        return maxLevel;
    }

    /**
     * 设置maxLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxLevel(Integer value) {
        this.maxLevel = value;
    }

    /**
     * 获取parentKnowledgePointId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParentKnowledgePointId() {
        return parentKnowledgePointId;
    }

    /**
     * 设置parentKnowledgePointId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParentKnowledgePointId(Integer value) {
        this.parentKnowledgePointId = value;
    }

    /**
     * 获取supportOnline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSupportOnline() {
        return supportOnline;
    }

    /**
     * 设置supportOnline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSupportOnline(Integer value) {
        this.supportOnline = value;
    }

    /**
     * 获取userBookVersionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserBookVersionId() {
        return userBookVersionId;
    }

    /**
     * 设置userBookVersionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserBookVersionId(Integer value) {
        this.userBookVersionId = value;
    }

}
