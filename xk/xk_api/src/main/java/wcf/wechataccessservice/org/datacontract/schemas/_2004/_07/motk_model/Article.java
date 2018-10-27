
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Article complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Article"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContentSourceUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Digest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ShowCoverPic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ThumbMediaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ThumbUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Article", propOrder = {
    "author",
    "content",
    "contentSourceUrl",
    "digest",
    "showCoverPic",
    "thumbMediaId",
    "thumbUrl",
    "title",
    "url"
})
public class Article {

    @XmlElementRef(name = "Author", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> author;
    @XmlElementRef(name = "Content", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> content;
    @XmlElementRef(name = "ContentSourceUrl", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> contentSourceUrl;
    @XmlElementRef(name = "Digest", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> digest;
    @XmlElement(name = "ShowCoverPic")
    protected Boolean showCoverPic;
    @XmlElementRef(name = "ThumbMediaId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> thumbMediaId;
    @XmlElementRef(name = "ThumbUrl", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> thumbUrl;
    @XmlElementRef(name = "Title", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> title;
    @XmlElementRef(name = "Url", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> url;

    /**
     * 获取author属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthor() {
        return author;
    }

    /**
     * 设置author属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthor(JAXBElement<String> value) {
        this.author = value;
    }

    /**
     * 获取content属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContent() {
        return content;
    }

    /**
     * 设置content属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContent(JAXBElement<String> value) {
        this.content = value;
    }

    /**
     * 获取contentSourceUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContentSourceUrl() {
        return contentSourceUrl;
    }

    /**
     * 设置contentSourceUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContentSourceUrl(JAXBElement<String> value) {
        this.contentSourceUrl = value;
    }

    /**
     * 获取digest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDigest() {
        return digest;
    }

    /**
     * 设置digest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDigest(JAXBElement<String> value) {
        this.digest = value;
    }

    /**
     * 获取showCoverPic属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowCoverPic() {
        return showCoverPic;
    }

    /**
     * 设置showCoverPic属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowCoverPic(Boolean value) {
        this.showCoverPic = value;
    }

    /**
     * 获取thumbMediaId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * 设置thumbMediaId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThumbMediaId(JAXBElement<String> value) {
        this.thumbMediaId = value;
    }

    /**
     * 获取thumbUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThumbUrl() {
        return thumbUrl;
    }

    /**
     * 设置thumbUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThumbUrl(JAXBElement<String> value) {
        this.thumbUrl = value;
    }

    /**
     * 获取title属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitle() {
        return title;
    }

    /**
     * 设置title属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitle(JAXBElement<String> value) {
        this.title = value;
    }

    /**
     * 获取url属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUrl() {
        return url;
    }

    /**
     * 设置url属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUrl(JAXBElement<String> value) {
        this.url = value;
    }

}
