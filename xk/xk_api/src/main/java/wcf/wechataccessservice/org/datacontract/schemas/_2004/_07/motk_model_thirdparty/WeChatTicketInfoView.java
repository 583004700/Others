
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WeChatTicketInfoView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatTicketInfoView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RefreshTicks" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="errcode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="errmsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expires_in" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatTicketInfoView", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", propOrder = {
    "refreshTicks",
    "errcode",
    "errmsg",
    "expiresIn",
    "ticket"
})
public class WeChatTicketInfoView {

    @XmlElement(name = "RefreshTicks")
    protected Long refreshTicks;
    protected Integer errcode;
    @XmlElementRef(name = "errmsg", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> errmsg;
    @XmlElement(name = "expires_in")
    protected Integer expiresIn;
    @XmlElementRef(name = "ticket", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> ticket;

    /**
     * 获取refreshTicks属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRefreshTicks() {
        return refreshTicks;
    }

    /**
     * 设置refreshTicks属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRefreshTicks(Long value) {
        this.refreshTicks = value;
    }

    /**
     * 获取errcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrcode() {
        return errcode;
    }

    /**
     * 设置errcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrcode(Integer value) {
        this.errcode = value;
    }

    /**
     * 获取errmsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrmsg() {
        return errmsg;
    }

    /**
     * 设置errmsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrmsg(JAXBElement<String> value) {
        this.errmsg = value;
    }

    /**
     * 获取expiresIn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置expiresIn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpiresIn(Integer value) {
        this.expiresIn = value;
    }

    /**
     * 获取ticket属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTicket() {
        return ticket;
    }

    /**
     * 设置ticket属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTicket(JAXBElement<String> value) {
        this.ticket = value;
    }

}
