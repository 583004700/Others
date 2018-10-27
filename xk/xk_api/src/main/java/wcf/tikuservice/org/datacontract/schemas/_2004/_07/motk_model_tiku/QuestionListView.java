
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QuestionListView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QuestionListView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuestionList" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}ArrayOfQuestionView" minOccurs="0"/&gt;
 *         &lt;element name="TotalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionListView", propOrder = {
    "questionList",
    "totalCount"
})
public class QuestionListView {

    @XmlElementRef(name = "QuestionList", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfQuestionView> questionList;
    @XmlElement(name = "TotalCount")
    protected Integer totalCount;

    /**
     * 获取questionList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionView }{@code >}
     *     
     */
    public JAXBElement<ArrayOfQuestionView> getQuestionList() {
        return questionList;
    }

    /**
     * 设置questionList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfQuestionView }{@code >}
     *     
     */
    public void setQuestionList(JAXBElement<ArrayOfQuestionView> value) {
        this.questionList = value;
    }

    /**
     * 获取totalCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置totalCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

}
