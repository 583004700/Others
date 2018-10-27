
package wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ChapterSection;


/**
 * <p>ArrayOfKeyValueOfintChapterSectionyH_Sjzk5H complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfKeyValueOfintChapterSectionyH_Sjzk5H"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeyValueOfintChapterSectionyH_Sjzk5H" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Value" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ChapterSection"/&gt;
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
@XmlType(name = "ArrayOfKeyValueOfintChapterSectionyH_Sjzk5H", propOrder = {
    "keyValueOfintChapterSectionyHSjzk5H"
})
public class ArrayOfKeyValueOfintChapterSectionyHSjzk5H {

    @XmlElement(name = "KeyValueOfintChapterSectionyH_Sjzk5H")
    protected List<ArrayOfKeyValueOfintChapterSectionyHSjzk5H.KeyValueOfintChapterSectionyHSjzk5H> keyValueOfintChapterSectionyHSjzk5H;

    /**
     * Gets the value of the keyValueOfintChapterSectionyHSjzk5H property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyValueOfintChapterSectionyHSjzk5H property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyValueOfintChapterSectionyHSjzk5H().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H.KeyValueOfintChapterSectionyHSjzk5H }
     * 
     * 
     */
    public List<ArrayOfKeyValueOfintChapterSectionyHSjzk5H.KeyValueOfintChapterSectionyHSjzk5H> getKeyValueOfintChapterSectionyHSjzk5H() {
        if (keyValueOfintChapterSectionyHSjzk5H == null) {
            keyValueOfintChapterSectionyHSjzk5H = new ArrayList<ArrayOfKeyValueOfintChapterSectionyHSjzk5H.KeyValueOfintChapterSectionyHSjzk5H>();
        }
        return this.keyValueOfintChapterSectionyHSjzk5H;
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
     *         &lt;element name="Value" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku}ChapterSection"/&gt;
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
    public static class KeyValueOfintChapterSectionyHSjzk5H {

        @XmlElement(name = "Key")
        protected int key;
        @XmlElement(name = "Value", required = true, nillable = true)
        protected ChapterSection value;

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
         *     {@link ChapterSection }
         *     
         */
        public ChapterSection getValue() {
            return value;
        }

        /**
         * 设置value属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ChapterSection }
         *     
         */
        public void setValue(ChapterSection value) {
            this.value = value;
        }

    }

}
