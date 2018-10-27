
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_wechat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WechatTransferModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WechatTransferModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="_x003C_Amount_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="_x003C_CheckName_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_Desc_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_MchAppId_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_MchId_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_NonceStr_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_OpenId_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_PartnerTradeNo_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_ReUserName_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_Sign_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_SpbillCreateIp_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WechatTransferModel", propOrder = {
    "x003CAmountX003EKBackingField",
    "x003CCheckNameX003EKBackingField",
    "x003CDescX003EKBackingField",
    "x003CMchAppIdX003EKBackingField",
    "x003CMchIdX003EKBackingField",
    "x003CNonceStrX003EKBackingField",
    "x003COpenIdX003EKBackingField",
    "x003CPartnerTradeNoX003EKBackingField",
    "x003CReUserNameX003EKBackingField",
    "x003CSignX003EKBackingField",
    "x003CSpbillCreateIpX003EKBackingField"
})
public class WechatTransferModel {

    @XmlElement(name = "_x003C_Amount_x003E_k__BackingField")
    protected int x003CAmountX003EKBackingField;
    @XmlElement(name = "_x003C_CheckName_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CCheckNameX003EKBackingField;
    @XmlElement(name = "_x003C_Desc_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CDescX003EKBackingField;
    @XmlElement(name = "_x003C_MchAppId_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CMchAppIdX003EKBackingField;
    @XmlElement(name = "_x003C_MchId_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CMchIdX003EKBackingField;
    @XmlElement(name = "_x003C_NonceStr_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CNonceStrX003EKBackingField;
    @XmlElement(name = "_x003C_OpenId_x003E_k__BackingField", required = true, nillable = true)
    protected String x003COpenIdX003EKBackingField;
    @XmlElement(name = "_x003C_PartnerTradeNo_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CPartnerTradeNoX003EKBackingField;
    @XmlElement(name = "_x003C_ReUserName_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CReUserNameX003EKBackingField;
    @XmlElement(name = "_x003C_Sign_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CSignX003EKBackingField;
    @XmlElement(name = "_x003C_SpbillCreateIp_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CSpbillCreateIpX003EKBackingField;

    /**
     * 获取x003CAmountX003EKBackingField属性的值。
     * 
     */
    public int getX003CAmountX003EKBackingField() {
        return x003CAmountX003EKBackingField;
    }

    /**
     * 设置x003CAmountX003EKBackingField属性的值。
     * 
     */
    public void setX003CAmountX003EKBackingField(int value) {
        this.x003CAmountX003EKBackingField = value;
    }

    /**
     * 获取x003CCheckNameX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CCheckNameX003EKBackingField() {
        return x003CCheckNameX003EKBackingField;
    }

    /**
     * 设置x003CCheckNameX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CCheckNameX003EKBackingField(String value) {
        this.x003CCheckNameX003EKBackingField = value;
    }

    /**
     * 获取x003CDescX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CDescX003EKBackingField() {
        return x003CDescX003EKBackingField;
    }

    /**
     * 设置x003CDescX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CDescX003EKBackingField(String value) {
        this.x003CDescX003EKBackingField = value;
    }

    /**
     * 获取x003CMchAppIdX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CMchAppIdX003EKBackingField() {
        return x003CMchAppIdX003EKBackingField;
    }

    /**
     * 设置x003CMchAppIdX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CMchAppIdX003EKBackingField(String value) {
        this.x003CMchAppIdX003EKBackingField = value;
    }

    /**
     * 获取x003CMchIdX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CMchIdX003EKBackingField() {
        return x003CMchIdX003EKBackingField;
    }

    /**
     * 设置x003CMchIdX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CMchIdX003EKBackingField(String value) {
        this.x003CMchIdX003EKBackingField = value;
    }

    /**
     * 获取x003CNonceStrX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CNonceStrX003EKBackingField() {
        return x003CNonceStrX003EKBackingField;
    }

    /**
     * 设置x003CNonceStrX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CNonceStrX003EKBackingField(String value) {
        this.x003CNonceStrX003EKBackingField = value;
    }

    /**
     * 获取x003COpenIdX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003COpenIdX003EKBackingField() {
        return x003COpenIdX003EKBackingField;
    }

    /**
     * 设置x003COpenIdX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003COpenIdX003EKBackingField(String value) {
        this.x003COpenIdX003EKBackingField = value;
    }

    /**
     * 获取x003CPartnerTradeNoX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CPartnerTradeNoX003EKBackingField() {
        return x003CPartnerTradeNoX003EKBackingField;
    }

    /**
     * 设置x003CPartnerTradeNoX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CPartnerTradeNoX003EKBackingField(String value) {
        this.x003CPartnerTradeNoX003EKBackingField = value;
    }

    /**
     * 获取x003CReUserNameX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CReUserNameX003EKBackingField() {
        return x003CReUserNameX003EKBackingField;
    }

    /**
     * 设置x003CReUserNameX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CReUserNameX003EKBackingField(String value) {
        this.x003CReUserNameX003EKBackingField = value;
    }

    /**
     * 获取x003CSignX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CSignX003EKBackingField() {
        return x003CSignX003EKBackingField;
    }

    /**
     * 设置x003CSignX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CSignX003EKBackingField(String value) {
        this.x003CSignX003EKBackingField = value;
    }

    /**
     * 获取x003CSpbillCreateIpX003EKBackingField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CSpbillCreateIpX003EKBackingField() {
        return x003CSpbillCreateIpX003EKBackingField;
    }

    /**
     * 设置x003CSpbillCreateIpX003EKBackingField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CSpbillCreateIpX003EKBackingField(String value) {
        this.x003CSpbillCreateIpX003EKBackingField = value;
    }

}
