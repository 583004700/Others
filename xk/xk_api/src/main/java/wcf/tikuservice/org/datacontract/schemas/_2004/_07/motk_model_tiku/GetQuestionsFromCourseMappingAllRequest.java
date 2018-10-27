
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestBase;


/**
 * <p>GetQuestionsFromCourseMappingAllRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetQuestionsFromCourseMappingAllRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.Common}RequestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourseMappingId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OnlineOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="SectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetQuestionsFromCourseMappingAllRequest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", propOrder = {
    "courseMappingId",
    "onlineOnly",
    "sectionId"
})
public class GetQuestionsFromCourseMappingAllRequest
    extends RequestBase
{

    @XmlElement(name = "CourseMappingId")
    protected Integer courseMappingId;
    @XmlElement(name = "OnlineOnly")
    protected Boolean onlineOnly;
    @XmlElement(name = "SectionId")
    protected Integer sectionId;

    /**
     * 获取courseMappingId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCourseMappingId() {
        return courseMappingId;
    }

    /**
     * 设置courseMappingId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCourseMappingId(Integer value) {
        this.courseMappingId = value;
    }

    /**
     * 获取onlineOnly属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlineOnly() {
        return onlineOnly;
    }

    /**
     * 设置onlineOnly属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlineOnly(Boolean value) {
        this.onlineOnly = value;
    }

    /**
     * 获取sectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 设置sectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSectionId(Integer value) {
        this.sectionId = value;
    }

}
