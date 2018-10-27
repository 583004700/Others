
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintArrayOfintty7Ep6D1;


/**
 * <p>PreKnowledgePointList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PreKnowledgePointList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PreKnowledgePoints" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintArrayOfintty7Ep6D1" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreKnowledgePointList", propOrder = {
    "preKnowledgePoints"
})
public class PreKnowledgePointList {

    @XmlElementRef(name = "PreKnowledgePoints", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1> preKnowledgePoints;

    /**
     * 获取preKnowledgePoints属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintArrayOfintty7Ep6D1 }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1> getPreKnowledgePoints() {
        return preKnowledgePoints;
    }

    /**
     * 设置preKnowledgePoints属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintArrayOfintty7Ep6D1 }{@code >}
     *     
     */
    public void setPreKnowledgePoints(JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1> value) {
        this.preKnowledgePoints = value;
    }

}
