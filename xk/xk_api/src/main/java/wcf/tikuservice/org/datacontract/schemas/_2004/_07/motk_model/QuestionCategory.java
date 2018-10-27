
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionCategory complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionCategory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AllowAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OrderIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ParentCategoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryModelId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionDisplayTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="RootCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionCategory", propOrder = {
    "allowAdd",
    "courseId",
    "enabled",
    "orderIndex",
    "parentCategoryId",
    "questionCategoryId",
    "questionCategoryModelId",
    "questionCategoryName",
    "questionDisplayTypeId",
    "rootCategoryId"
})
public class QuestionCategory {

    @XmlElement(name = "AllowAdd")
    protected Boolean allowAdd;
    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "Enabled")
    protected Boolean enabled;
    @XmlElement(name = "OrderIndex")
    protected Integer orderIndex;
    @XmlElementRef(name = "ParentCategoryId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> parentCategoryId;
    @XmlElement(name = "QuestionCategoryId")
    protected Integer questionCategoryId;
    @XmlElement(name = "QuestionCategoryModelId")
    protected Integer questionCategoryModelId;
    @XmlElementRef(name = "QuestionCategoryName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> questionCategoryName;
    @XmlElement(name = "QuestionDisplayTypeId")
    protected Integer questionDisplayTypeId;
    @XmlElement(name = "RootCategoryId")
    protected Integer rootCategoryId;

    /**
     * 获取allowAdd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowAdd() {
        return allowAdd;
    }

    /**
     * 设置allowAdd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowAdd(Boolean value) {
        this.allowAdd = value;
    }

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
     * 获取enabled属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置enabled属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * 获取orderIndex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 设置orderIndex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderIndex(Integer value) {
        this.orderIndex = value;
    }

    /**
     * 获取parentCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParentCategoryId() {
        return parentCategoryId;
    }

    /**
     * 设置parentCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParentCategoryId(JAXBElement<String> value) {
        this.parentCategoryId = value;
    }

    /**
     * 获取questionCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCategoryId() {
        return questionCategoryId;
    }

    /**
     * 设置questionCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCategoryId(Integer value) {
        this.questionCategoryId = value;
    }

    /**
     * 获取questionCategoryModelId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionCategoryModelId() {
        return questionCategoryModelId;
    }

    /**
     * 设置questionCategoryModelId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionCategoryModelId(Integer value) {
        this.questionCategoryModelId = value;
    }

    /**
     * 获取questionCategoryName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQuestionCategoryName() {
        return questionCategoryName;
    }

    /**
     * 设置questionCategoryName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuestionCategoryName(JAXBElement<String> value) {
        this.questionCategoryName = value;
    }

    /**
     * 获取questionDisplayTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionDisplayTypeId() {
        return questionDisplayTypeId;
    }

    /**
     * 设置questionDisplayTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionDisplayTypeId(Integer value) {
        this.questionDisplayTypeId = value;
    }

    /**
     * 获取rootCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    /**
     * 设置rootCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRootCategoryId(Integer value) {
        this.rootCategoryId = value;
    }

}
