
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NewsItemRequestResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NewsItemRequestResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseItems" type="{http://schemas.datacontract.org/2004/07/Motk.Model.WeChat}ArrayOfNewsItemResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewsItemRequestResult", propOrder = {
    "responseItems"
})
public class NewsItemRequestResult {

    @XmlElementRef(name = "ResponseItems", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<ArrayOfNewsItemResponse> responseItems;

    /**
     * 获取responseItems属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNewsItemResponse }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNewsItemResponse> getResponseItems() {
        return responseItems;
    }

    /**
     * 设置responseItems属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNewsItemResponse }{@code >}
     *     
     */
    public void setResponseItems(JAXBElement<ArrayOfNewsItemResponse> value) {
        this.responseItems = value;
    }

}
