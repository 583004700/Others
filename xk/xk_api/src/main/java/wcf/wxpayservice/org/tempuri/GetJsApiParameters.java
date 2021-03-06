
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>anonymous complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"orderNumber", "orderFrom"})
@XmlRootElement(name = "GetJsApiParameters")
public class GetJsApiParameters
{

    @XmlElementRef(name = "orderNumber", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> orderNumber;

    protected Integer orderFrom;

    /**
     * 获取orderNumber属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getOrderNumber()
    {
        return orderNumber;
    }

    /**
     * 设置orderNumber属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setOrderNumber(JAXBElement<String> value)
    {
        this.orderNumber = value;
    }

    /**
     * 获取orderFrom属性的值。
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getOrderFrom()
    {
        return orderFrom;
    }

    /**
     * 设置orderFrom属性的值。
     * 
     * @param value
     *            allowed object is {@link Integer }
     */
    public void setOrderFrom(Integer value)
    {
        this.orderFrom = value;
    }

}
