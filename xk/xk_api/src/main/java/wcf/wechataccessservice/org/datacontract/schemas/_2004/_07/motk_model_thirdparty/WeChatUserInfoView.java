
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ResultMessage;


/**
 * <p>WeChatUserInfoView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WeChatUserInfoView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty}ResultMessage"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GroupId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="HeadImgUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Openid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Subscribe" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Subscribe_time" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="UnionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeChatUserInfoView", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", propOrder = {
    "city",
    "country",
    "groupId",
    "headImgUrl",
    "language",
    "nickName",
    "openid",
    "province",
    "remark",
    "sex",
    "subscribe",
    "subscribeTime",
    "unionId"
})
public class WeChatUserInfoView
    extends ResultMessage
{

    @XmlElementRef(name = "City", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> city;
    @XmlElementRef(name = "Country", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> country;
    @XmlElement(name = "GroupId")
    protected Integer groupId;
    @XmlElementRef(name = "HeadImgUrl", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> headImgUrl;
    @XmlElementRef(name = "Language", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> language;
    @XmlElementRef(name = "NickName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> nickName;
    @XmlElementRef(name = "Openid", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> openid;
    @XmlElementRef(name = "Province", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> province;
    @XmlElementRef(name = "Remark", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElement(name = "Sex")
    protected Integer sex;
    @XmlElement(name = "Subscribe")
    protected Integer subscribe;
    @XmlElement(name = "Subscribe_time")
    protected Long subscribeTime;
    @XmlElementRef(name = "UnionId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.View", type = JAXBElement.class)
    protected JAXBElement<String> unionId;

    /**
     * 获取city属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * 设置city属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = value;
    }

    /**
     * 获取country属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountry() {
        return country;
    }

    /**
     * 设置country属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountry(JAXBElement<String> value) {
        this.country = value;
    }

    /**
     * 获取groupId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置groupId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGroupId(Integer value) {
        this.groupId = value;
    }

    /**
     * 获取headImgUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置headImgUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeadImgUrl(JAXBElement<String> value) {
        this.headImgUrl = value;
    }

    /**
     * 获取language属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguage() {
        return language;
    }

    /**
     * 设置language属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<String> value) {
        this.language = value;
    }

    /**
     * 获取nickName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNickName() {
        return nickName;
    }

    /**
     * 设置nickName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNickName(JAXBElement<String> value) {
        this.nickName = value;
    }

    /**
     * 获取openid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOpenid() {
        return openid;
    }

    /**
     * 设置openid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpenid(JAXBElement<String> value) {
        this.openid = value;
    }

    /**
     * 获取province属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvince() {
        return province;
    }

    /**
     * 设置province属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvince(JAXBElement<String> value) {
        this.province = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemark(JAXBElement<String> value) {
        this.remark = value;
    }

    /**
     * 获取sex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置sex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSex(Integer value) {
        this.sex = value;
    }

    /**
     * 获取subscribe属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubscribe() {
        return subscribe;
    }

    /**
     * 设置subscribe属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubscribe(Integer value) {
        this.subscribe = value;
    }

    /**
     * 获取subscribeTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubscribeTime() {
        return subscribeTime;
    }

    /**
     * 设置subscribeTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubscribeTime(Long value) {
        this.subscribeTime = value;
    }

    /**
     * 获取unionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnionId() {
        return unionId;
    }

    /**
     * 设置unionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnionId(JAXBElement<String> value) {
        this.unionId = value;
    }

}
