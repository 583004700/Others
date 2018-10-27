
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.QueryParams;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TransactionType;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * <p>QueryOrdersParam complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="QueryOrdersParam"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.FormatModel}QueryParams"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderCreateUserID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderStatusTypeID" type="{http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums}TransactionType" minOccurs="0"/&gt;
 *         &lt;element name="ProductGroupIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&gt;
 *         &lt;element name="SourcePlantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryOrdersParam", propOrder = {
    "orderCreateUserID",
    "orderStatusTypeID",
    "productGroupIds",
    "sourcePlantCode"
})
public class QueryOrdersParam
    extends QueryParams
{

    @XmlElement(name = "OrderCreateUserID")
    protected Integer orderCreateUserID;
    @XmlElementRef(name = "OrderStatusTypeID", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<TransactionType> orderStatusTypeID;
    @XmlElementRef(name = "ProductGroupIds", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<ArrayOfint> productGroupIds;
    @XmlElementRef(name = "SourcePlantCode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.IModuleServices.OrderHub.Models", type = JAXBElement.class)
    protected JAXBElement<String> sourcePlantCode;

    /**
     * 获取orderCreateUserID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderCreateUserID() {
        return orderCreateUserID;
    }

    /**
     * 设置orderCreateUserID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderCreateUserID(Integer value) {
        this.orderCreateUserID = value;
    }

    /**
     * 获取orderStatusTypeID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransactionType }{@code >}
     *     
     */
    public JAXBElement<TransactionType> getOrderStatusTypeID() {
        return orderStatusTypeID;
    }

    /**
     * 设置orderStatusTypeID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransactionType }{@code >}
     *     
     */
    public void setOrderStatusTypeID(JAXBElement<TransactionType> value) {
        this.orderStatusTypeID = value;
    }

    /**
     * 获取productGroupIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getProductGroupIds() {
        return productGroupIds;
    }

    /**
     * 设置productGroupIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setProductGroupIds(JAXBElement<ArrayOfint> value) {
        this.productGroupIds = value;
    }

    /**
     * 获取sourcePlantCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourcePlantCode() {
        return sourcePlantCode;
    }

    /**
     * 设置sourcePlantCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourcePlantCode(JAXBElement<String> value) {
        this.sourcePlantCode = value;
    }

}
