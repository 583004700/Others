
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionyHSjzk5H;


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
 *         &lt;element name="GetBookVersionChapterSectionsResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintChapterSectionyH_Sjzk5H" minOccurs="0"/&gt;
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
    "getBookVersionChapterSectionsResult"
})
@XmlRootElement(name = "GetBookVersionChapterSectionsResponse")
public class GetBookVersionChapterSectionsResponse {

    @XmlElementRef(name = "GetBookVersionChapterSectionsResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> getBookVersionChapterSectionsResult;

    /**
     * 获取getBookVersionChapterSectionsResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> getGetBookVersionChapterSectionsResult() {
        return getBookVersionChapterSectionsResult;
    }

    /**
     * 设置getBookVersionChapterSectionsResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}
     *     
     */
    public void setGetBookVersionChapterSectionsResult(JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> value) {
        this.getBookVersionChapterSectionsResult = value;
    }

}
