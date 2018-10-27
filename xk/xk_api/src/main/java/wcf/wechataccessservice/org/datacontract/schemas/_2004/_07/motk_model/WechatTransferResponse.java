
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WechatTransferResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WechatTransferResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DeviceInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ErrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ErrCodeDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MchAppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NonceStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PartnerTradeNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReturnMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WechatTransferResponse", propOrder = {
    "deviceInfo",
    "errCode",
    "errCodeDes",
    "mchAppId",
    "mchId",
    "nonceStr",
    "partnerTradeNo",
    "paymentNo",
    "paymentTime",
    "resultCode",
    "returnCode",
    "returnMsg"
})
public class WechatTransferResponse {

    @XmlElementRef(name = "DeviceInfo", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> deviceInfo;
    @XmlElementRef(name = "ErrCode", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> errCode;
    @XmlElementRef(name = "ErrCodeDes", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> errCodeDes;
    @XmlElementRef(name = "MchAppId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> mchAppId;
    @XmlElementRef(name = "MchId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> mchId;
    @XmlElementRef(name = "NonceStr", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> nonceStr;
    @XmlElementRef(name = "PartnerTradeNo", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> partnerTradeNo;
    @XmlElementRef(name = "PaymentNo", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> paymentNo;
    @XmlElementRef(name = "PaymentTime", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> paymentTime;
    @XmlElementRef(name = "ResultCode", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> resultCode;
    @XmlElementRef(name = "ReturnCode", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> returnCode;
    @XmlElementRef(name = "ReturnMsg", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.WeChat", type = JAXBElement.class)
    protected JAXBElement<String> returnMsg;

    /**
     * 获取deviceInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * 设置deviceInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeviceInfo(JAXBElement<String> value) {
        this.deviceInfo = value;
    }

    /**
     * 获取errCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrCode() {
        return errCode;
    }

    /**
     * 设置errCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrCode(JAXBElement<String> value) {
        this.errCode = value;
    }

    /**
     * 获取errCodeDes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrCodeDes() {
        return errCodeDes;
    }

    /**
     * 设置errCodeDes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrCodeDes(JAXBElement<String> value) {
        this.errCodeDes = value;
    }

    /**
     * 获取mchAppId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMchAppId() {
        return mchAppId;
    }

    /**
     * 设置mchAppId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMchAppId(JAXBElement<String> value) {
        this.mchAppId = value;
    }

    /**
     * 获取mchId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMchId() {
        return mchId;
    }

    /**
     * 设置mchId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMchId(JAXBElement<String> value) {
        this.mchId = value;
    }

    /**
     * 获取nonceStr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNonceStr() {
        return nonceStr;
    }

    /**
     * 设置nonceStr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNonceStr(JAXBElement<String> value) {
        this.nonceStr = value;
    }

    /**
     * 获取partnerTradeNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerTradeNo() {
        return partnerTradeNo;
    }

    /**
     * 设置partnerTradeNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerTradeNo(JAXBElement<String> value) {
        this.partnerTradeNo = value;
    }

    /**
     * 获取paymentNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentNo() {
        return paymentNo;
    }

    /**
     * 设置paymentNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentNo(JAXBElement<String> value) {
        this.paymentNo = value;
    }

    /**
     * 获取paymentTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置paymentTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTime(JAXBElement<String> value) {
        this.paymentTime = value;
    }

    /**
     * 获取resultCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultCode() {
        return resultCode;
    }

    /**
     * 设置resultCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultCode(JAXBElement<String> value) {
        this.resultCode = value;
    }

    /**
     * 获取returnCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnCode() {
        return returnCode;
    }

    /**
     * 设置returnCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnCode(JAXBElement<String> value) {
        this.returnCode = value;
    }

    /**
     * 获取returnMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReturnMsg() {
        return returnMsg;
    }

    /**
     * 设置returnMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReturnMsg(JAXBElement<String> value) {
        this.returnMsg = value;
    }

}
