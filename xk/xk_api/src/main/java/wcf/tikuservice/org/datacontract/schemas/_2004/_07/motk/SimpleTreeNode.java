
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SimpleTreeNode complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SimpleTreeNode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Children" type="{http://schemas.datacontract.org/2004/07/Motk.Model}ArrayOfSimpleTreeNode" minOccurs="0"/&gt;
 *         &lt;element name="EncodeParentPointId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EncodePointId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NodeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="NodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NodeValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="OrderIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ParentNodeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleTreeNode", propOrder = {
    "children",
    "encodeParentPointId",
    "encodePointId",
    "nodeId",
    "nodeName",
    "nodeValue",
    "orderIndex",
    "parentNodeId"
})
public class SimpleTreeNode {

    @XmlElementRef(name = "Children", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSimpleTreeNode> children;
    @XmlElementRef(name = "EncodeParentPointId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", type = JAXBElement.class)
    protected JAXBElement<String> encodeParentPointId;
    @XmlElementRef(name = "EncodePointId", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", type = JAXBElement.class)
    protected JAXBElement<String> encodePointId;
    @XmlElement(name = "NodeId")
    protected Integer nodeId;
    @XmlElementRef(name = "NodeName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", type = JAXBElement.class)
    protected JAXBElement<String> nodeName;
    @XmlElement(name = "NodeValue")
    protected Integer nodeValue;
    @XmlElement(name = "OrderIndex")
    protected Integer orderIndex;
    @XmlElement(name = "ParentNodeId")
    protected Integer parentNodeId;

    /**
     * 获取children属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSimpleTreeNode> getChildren() {
        return children;
    }

    /**
     * 设置children属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}
     *     
     */
    public void setChildren(JAXBElement<ArrayOfSimpleTreeNode> value) {
        this.children = value;
    }

    /**
     * 获取encodeParentPointId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncodeParentPointId() {
        return encodeParentPointId;
    }

    /**
     * 设置encodeParentPointId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncodeParentPointId(JAXBElement<String> value) {
        this.encodeParentPointId = value;
    }

    /**
     * 获取encodePointId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncodePointId() {
        return encodePointId;
    }

    /**
     * 设置encodePointId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncodePointId(JAXBElement<String> value) {
        this.encodePointId = value;
    }

    /**
     * 获取nodeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 设置nodeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNodeId(Integer value) {
        this.nodeId = value;
    }

    /**
     * 获取nodeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeName() {
        return nodeName;
    }

    /**
     * 设置nodeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeName(JAXBElement<String> value) {
        this.nodeName = value;
    }

    /**
     * 获取nodeValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNodeValue() {
        return nodeValue;
    }

    /**
     * 设置nodeValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNodeValue(Integer value) {
        this.nodeValue = value;
    }

    /**
     * 获取orderIndex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 设置orderIndex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderIndex(Integer value) {
        this.orderIndex = value;
    }

    /**
     * 获取parentNodeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParentNodeId() {
        return parentNodeId;
    }

    /**
     * 设置parentNodeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParentNodeId(Integer value) {
        this.parentNodeId = value;
    }

}
