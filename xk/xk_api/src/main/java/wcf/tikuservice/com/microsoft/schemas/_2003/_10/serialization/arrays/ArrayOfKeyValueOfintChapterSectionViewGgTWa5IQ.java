
package wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ChapterSectionView;


/**
 * <p>ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KeyValueOfintChapterSectionViewGgTWa5IQ" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Value" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}ChapterSectionView"/&gt;
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
@XmlType(name = "ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ", propOrder = {
    "keyValueOfintChapterSectionViewGgTWa5IQ"
})
public class ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ {

    @XmlElement(name = "KeyValueOfintChapterSectionViewGgTWa5IQ")
    protected List<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ.KeyValueOfintChapterSectionViewGgTWa5IQ> keyValueOfintChapterSectionViewGgTWa5IQ;

    /**
     * Gets the value of the keyValueOfintChapterSectionViewGgTWa5IQ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyValueOfintChapterSectionViewGgTWa5IQ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyValueOfintChapterSectionViewGgTWa5IQ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ.KeyValueOfintChapterSectionViewGgTWa5IQ }
     * 
     * 
     */
    public List<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ.KeyValueOfintChapterSectionViewGgTWa5IQ> getKeyValueOfintChapterSectionViewGgTWa5IQ() {
        if (keyValueOfintChapterSectionViewGgTWa5IQ == null) {
            keyValueOfintChapterSectionViewGgTWa5IQ = new ArrayList<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ.KeyValueOfintChapterSectionViewGgTWa5IQ>();
        }
        return this.keyValueOfintChapterSectionViewGgTWa5IQ;
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
     *         &lt;element name="Value" type="{http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View}ChapterSectionView"/&gt;
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
    public static class KeyValueOfintChapterSectionViewGgTWa5IQ {

        @XmlElement(name = "Key")
        protected int key;
        @XmlElement(name = "Value", required = true, nillable = true)
        protected ChapterSectionView value;

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
         *     {@link ChapterSectionView }
         *     
         */
        public ChapterSectionView getValue() {
            return value;
        }

        /**
         * 设置value属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ChapterSectionView }
         *     
         */
        public void setValue(ChapterSectionView value) {
            this.value = value;
        }

    }

}
