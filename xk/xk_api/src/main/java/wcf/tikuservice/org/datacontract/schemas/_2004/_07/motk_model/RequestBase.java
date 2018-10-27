
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetAllQuestionCategoriesRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetBookVersionsRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetExamUsageRulerRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetExamUsageRulerViewRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetOnlineQuestionsForKnowledgePointRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetOnlineQuestionsRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionCategoriesCheckOnlineRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionKnowledgePointDistributionRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionSectionDistributionRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionStatisticsListRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionsFromCourseMappingAllRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionsFromKnowledgePointsAllRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.KnowledgePointQuestionRequest;


/**
 * <p>RequestBase complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="RequestBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="RequestFromType" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}RequestFromTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBase", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", propOrder = {
    "exUserId",
    "requestFromType",
    "userId"
})
@XmlSeeAlso({
    KnowledgePointQuestionRequest.class,
    GetExamUsageRulerViewRequest.class,
    IdRequest.class,
    GetExamUsageRulerRequest.class,
    GetQuestionsFromCourseMappingAllRequest.class,
    GetQuestionsFromKnowledgePointsAllRequest.class,
    GetQuestionStatisticsListRequest.class,
    GetBookVersionsRequest.class,
    GetAllQuestionCategoriesRequest.class,
    GetQuestionCategoriesCheckOnlineRequest.class,
    GetOnlineQuestionsRequest.class,
    GetOnlineQuestionsForKnowledgePointRequest.class,
    GetQuestionSectionDistributionRequest.class,
    GetQuestionKnowledgePointDistributionRequest.class
})
public class RequestBase {

    @XmlElement(name = "ExUserId")
    protected Long exUserId;
    @XmlElement(name = "RequestFromType")
    @XmlSchemaType(name = "string")
    protected RequestFromTypeEnum requestFromType;
    @XmlElement(name = "UserId")
    protected Integer userId;

    /**
     * 获取exUserId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExUserId() {
        return exUserId;
    }

    /**
     * 设置exUserId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExUserId(Long value) {
        this.exUserId = value;
    }

    /**
     * 获取requestFromType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestFromTypeEnum }
     *     
     */
    public RequestFromTypeEnum getRequestFromType() {
        return requestFromType;
    }

    /**
     * 设置requestFromType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestFromTypeEnum }
     *     
     */
    public void setRequestFromType(RequestFromTypeEnum value) {
        this.requestFromType = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }

}
