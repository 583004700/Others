
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="GetBookVersionQuestionCountResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
    "getBookVersionQuestionCountResult"
})
@XmlRootElement(name = "GetBookVersionQuestionCountResponse")
public class GetBookVersionQuestionCountResponse {

    @XmlElement(name = "GetBookVersionQuestionCountResult")
    protected Integer getBookVersionQuestionCountResult;

    /**
     * 获取getBookVersionQuestionCountResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGetBookVersionQuestionCountResult() {
        return getBookVersionQuestionCountResult;
    }

    /**
     * 设置getBookVersionQuestionCountResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGetBookVersionQuestionCountResult(Integer value) {
        this.getBookVersionQuestionCountResult = value;
    }

}
