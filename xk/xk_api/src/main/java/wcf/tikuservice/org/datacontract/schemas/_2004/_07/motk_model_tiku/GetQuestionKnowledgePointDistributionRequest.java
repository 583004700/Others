
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestBase;


/**
 * <p>GetQuestionKnowledgePointDistributionRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetQuestionKnowledgePointDistributionRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}RequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="NumberOfQuestionBySection" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SectionIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetQuestionKnowledgePointDistributionRequest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", propOrder = {
    "courseId",
    "numberOfQuestionBySection",
    "sectionIds"
})
public class GetQuestionKnowledgePointDistributionRequest
    extends RequestBase
{

    @XmlElement(name = "CourseId")
    protected Integer courseId;
    @XmlElement(name = "NumberOfQuestionBySection")
    protected Integer numberOfQuestionBySection;
    @XmlElementRef(name = "SectionIds", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", type = JAXBElement.class)
    protected JAXBElement<ArrayOfint> sectionIds;

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
     * 获取numberOfQuestionBySection属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfQuestionBySection() {
        return numberOfQuestionBySection;
    }

    /**
     * 设置numberOfQuestionBySection属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfQuestionBySection(Integer value) {
        this.numberOfQuestionBySection = value;
    }

    /**
     * 获取sectionIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getSectionIds() {
        return sectionIds;
    }

    /**
     * 设置sectionIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setSectionIds(JAXBElement<ArrayOfint> value) {
        this.sectionIds = value;
    }

}
