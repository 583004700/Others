
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.QuestionListView;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetQuestionsFromSectionsResult" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}QuestionListView" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQuestionsFromSectionsResult"
})
@XmlRootElement(name = "GetQuestionsFromSectionsResponse")
public class GetQuestionsFromSectionsResponse {

    @XmlElementRef(name = "GetQuestionsFromSectionsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<QuestionListView> getQuestionsFromSectionsResult;

    /**
     * 获取getQuestionsFromSectionsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}
     *     
     */
    public JAXBElement<QuestionListView> getGetQuestionsFromSectionsResult() {
        return getQuestionsFromSectionsResult;
    }

    /**
     * 设置getQuestionsFromSectionsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}
     *     
     */
    public void setGetQuestionsFromSectionsResult(JAXBElement<QuestionListView> value) {
        this.getQuestionsFromSectionsResult = value;
    }

}
