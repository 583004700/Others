
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>QuestionReportModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionReportModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CapabilityAnalysis" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="KnowledgeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="QuestionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="QuestionLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SolveMethodLabel" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionReportModel", propOrder = {
    "capabilityAnalysis",
    "categoryName",
    "knowledgeName",
    "questionId",
    "questionLevel",
    "solveMethodLabel"
})
public class QuestionReportModel {

    @XmlElementRef(name = "CapabilityAnalysis", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> capabilityAnalysis;
    @XmlElementRef(name = "CategoryName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> categoryName;
    @XmlElementRef(name = "KnowledgeName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<String> knowledgeName;
    @XmlElement(name = "QuestionId")
    protected Integer questionId;
    @XmlElement(name = "QuestionLevel")
    protected Integer questionLevel;
    @XmlElementRef(name = "SolveMethodLabel", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> solveMethodLabel;

    /**
     * 获取capabilityAnalysis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCapabilityAnalysis() {
        return capabilityAnalysis;
    }

    /**
     * 设置capabilityAnalysis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCapabilityAnalysis(JAXBElement<ArrayOfstring> value) {
        this.capabilityAnalysis = value;
    }

    /**
     * 获取categoryName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategoryName() {
        return categoryName;
    }

    /**
     * 设置categoryName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategoryName(JAXBElement<String> value) {
        this.categoryName = value;
    }

    /**
     * 获取knowledgeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * 设置knowledgeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKnowledgeName(JAXBElement<String> value) {
        this.knowledgeName = value;
    }

    /**
     * 获取questionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 设置questionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionId(Integer value) {
        this.questionId = value;
    }

    /**
     * 获取questionLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuestionLevel() {
        return questionLevel;
    }

    /**
     * 设置questionLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuestionLevel(Integer value) {
        this.questionLevel = value;
    }

    /**
     * 获取solveMethodLabel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSolveMethodLabel() {
        return solveMethodLabel;
    }

    /**
     * 设置solveMethodLabel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSolveMethodLabel(JAXBElement<ArrayOfstring> value) {
        this.solveMethodLabel = value;
    }

}
