
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ResponseMsgType;


/**
 * <p>WeChatResponseView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatResponseView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Encrypt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EventKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FromUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResponseMsgType" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Enum}ResponseMsgType" minOccurs="0"/&gt;
 *         &lt;element name="ToUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatResponseView", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", propOrder = {
    "createTime",
    "encrypt",
    "eventKey",
    "fromUserName",
    "responseMsgType",
    "toUserName"
})
public class WeChatResponseView {

    @XmlElement(name = "CreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlElementRef(name = "Encrypt", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> encrypt;
    @XmlElementRef(name = "EventKey", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> eventKey;
    @XmlElementRef(name = "FromUserName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> fromUserName;
    @XmlElement(name = "ResponseMsgType")
    @XmlSchemaType(name = "string")
    protected ResponseMsgType responseMsgType;
    @XmlElementRef(name = "ToUserName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> toUserName;

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * 获取encrypt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncrypt() {
        return encrypt;
    }

    /**
     * 设置encrypt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncrypt(JAXBElement<String> value) {
        this.encrypt = value;
    }

    /**
     * 获取eventKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEventKey() {
        return eventKey;
    }

    /**
     * 设置eventKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEventKey(JAXBElement<String> value) {
        this.eventKey = value;
    }

    /**
     * 获取fromUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFromUserName() {
        return fromUserName;
    }

    /**
     * 设置fromUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFromUserName(JAXBElement<String> value) {
        this.fromUserName = value;
    }

    /**
     * 获取responseMsgType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResponseMsgType }
     *     
     */
    public ResponseMsgType getResponseMsgType() {
        return responseMsgType;
    }

    /**
     * 设置responseMsgType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMsgType }
     *     
     */
    public void setResponseMsgType(ResponseMsgType value) {
        this.responseMsgType = value;
    }

    /**
     * 获取toUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getToUserName() {
        return toUserName;
    }

    /**
     * 设置toUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setToUserName(JAXBElement<String> value) {
        this.toUserName = value;
    }

}
