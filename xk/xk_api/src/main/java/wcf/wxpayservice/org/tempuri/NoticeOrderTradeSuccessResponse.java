
package wcf.wxpayservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult;

/**
 * <p>anonymous complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NoticeOrderTradeSuccessResult" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common}ServiceResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"noticeOrderTradeSuccessResult"})
@XmlRootElement(name = "NoticeOrderTradeSuccessResponse")
public class NoticeOrderTradeSuccessResponse
{

    @XmlElementRef(name = "NoticeOrderTradeSuccessResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ServiceResult> noticeOrderTradeSuccessResult;

    /**
     * 获取noticeOrderTradeSuccessResult属性的值。
     * 
     * @return possible object is {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}
     */
    public JAXBElement<ServiceResult> getNoticeOrderTradeSuccessResult()
    {
        return noticeOrderTradeSuccessResult;
    }

    /**
     * 设置noticeOrderTradeSuccessResult属性的值。
     * 
     * @param value
     *            allowed object is {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}
     */
    public void setNoticeOrderTradeSuccessResult(JAXBElement<ServiceResult> value)
    {
        this.noticeOrderTradeSuccessResult = value;
    }

}
