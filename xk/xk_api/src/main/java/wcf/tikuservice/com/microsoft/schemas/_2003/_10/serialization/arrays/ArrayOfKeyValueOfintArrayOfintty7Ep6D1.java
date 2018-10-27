
package wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfKeyValueOfintArrayOfintty7Ep6D1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfKeyValueOfintArrayOfintty7Ep6D1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeyValueOfintArrayOfintty7Ep6D1" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Value" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfKeyValueOfintArrayOfintty7Ep6D1", propOrder = {
    "keyValueOfintArrayOfintty7Ep6D1"
})
public class ArrayOfKeyValueOfintArrayOfintty7Ep6D1 {

    @XmlElement(name = "KeyValueOfintArrayOfintty7Ep6D1")
    protected List<ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .KeyValueOfintArrayOfintty7Ep6D1> keyValueOfintArrayOfintty7Ep6D1;

    /**
     * Gets the value of the keyValueOfintArrayOfintty7Ep6D1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyValueOfintArrayOfintty7Ep6D1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyValueOfintArrayOfintty7Ep6D1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .KeyValueOfintArrayOfintty7Ep6D1 }
     * 
     * 
     */
    public List<ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .KeyValueOfintArrayOfintty7Ep6D1> getKeyValueOfintArrayOfintty7Ep6D1() {
        if (keyValueOfintArrayOfintty7Ep6D1 == null) {
            keyValueOfintArrayOfintty7Ep6D1 = new ArrayList<ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .KeyValueOfintArrayOfintty7Ep6D1>();
        }
        return this.keyValueOfintArrayOfintty7Ep6D1;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="Value" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "key",
        "value"
    })
    public static class KeyValueOfintArrayOfintty7Ep6D1 {

        @XmlElement(name = "Key")
        protected int key;
        @XmlElement(name = "Value", required = true, nillable = true)
        protected ArrayOfint value;

        /**
         * 获取key属性的值。
         * 
         */
        public int getKey() {
            return key;
        }

        /**
         * 设置key属性的值。
         * 
         */
        public void setKey(int value) {
            this.key = value;
        }

        /**
         * 获取value属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfint }
         *     
         */
        public ArrayOfint getValue() {
            return value;
        }

        /**
         * 设置value属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfint }
         *     
         */
        public void setValue(ArrayOfint value) {
            this.value = value;
        }

    }

}
