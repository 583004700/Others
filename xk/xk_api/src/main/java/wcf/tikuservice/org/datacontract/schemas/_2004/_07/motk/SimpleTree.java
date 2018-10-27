
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SimpleTree complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SimpleTree"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Roots" type="{http://schemas.datacontract.org/2004/07/Motk.Model}ArrayOfSimpleTreeNode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleTree", propOrder = {
    "roots"
})
public class SimpleTree {

    @XmlElementRef(name = "Roots", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSimpleTreeNode> roots;

    /**
     * 获取roots属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSimpleTreeNode> getRoots() {
        return roots;
    }

    /**
     * 设置roots属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}
     *     
     */
    public void setRoots(JAXBElement<ArrayOfSimpleTreeNode> value) {
        this.roots = value;
    }

}
