
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NewsItemResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NewsItemResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ErrMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NewsItem" type="{http://schemas.datacontract.org/2004/07/Motk.Model.WeChat}ArrayOfArticle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewsItemResponse", propOrder = {
    "errCode",
    "errMsg",
    "mediaId",
    "newsItem"
})
public class NewsItemResponse {

    @XmlElement(name = "ErrCode")
    protected Integer errCode;
    @XmlElementRef(name = "ErrMsg", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> errMsg;
    @XmlElementRef(name = "MediaId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> mediaId;
    @XmlElementRef(name = "NewsItem", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<ArrayOfArticle> newsItem;

    /**
     * 获取errCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrCode() {
        return errCode;
    }

    /**
     * 设置errCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrCode(Integer value) {
        this.errCode = value;
    }

    /**
     * 获取errMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrMsg() {
        return errMsg;
    }

    /**
     * 设置errMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrMsg(JAXBElement<String> value) {
        this.errMsg = value;
    }

    /**
     * 获取mediaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMediaId() {
        return mediaId;
    }

    /**
     * 设置mediaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMediaId(JAXBElement<String> value) {
        this.mediaId = value;
    }

    /**
     * 获取newsItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArticle }{@code >}
     *     
     */
    public JAXBElement<ArrayOfArticle> getNewsItem() {
        return newsItem;
    }

    /**
     * 设置newsItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArticle }{@code >}
     *     
     */
    public void setNewsItem(JAXBElement<ArrayOfArticle> value) {
        this.newsItem = value;
    }

}
