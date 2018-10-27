
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ;


/**
 * <p>ChapterSectionView complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ChapterSectionView"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChapterSectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParentSectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Parents" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ" minOccurs="0"/&gt;
 *         &lt;element name="RootSectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SectionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChapterSectionView", propOrder = {
    "chapterSectionName",
    "parentSectionId",
    "parents",
    "rootSectionId",
    "sectionId",
    "sectionName"
})
public class ChapterSectionView {

    @XmlElementRef(name = "ChapterSectionName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> chapterSectionName;
    @XmlElement(name = "ParentSectionId")
    protected Integer parentSectionId;
    @XmlElementRef(name = "Parents", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ> parents;
    @XmlElement(name = "RootSectionId")
    protected Integer rootSectionId;
    @XmlElement(name = "SectionId")
    protected Integer sectionId;
    @XmlElementRef(name = "SectionName", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", type = JAXBElement.class)
    protected JAXBElement<String> sectionName;

    /**
     * 获取chapterSectionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChapterSectionName() {
        return chapterSectionName;
    }

    /**
     * 设置chapterSectionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChapterSectionName(JAXBElement<String> value) {
        this.chapterSectionName = value;
    }

    /**
     * 获取parentSectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParentSectionId() {
        return parentSectionId;
    }

    /**
     * 设置parentSectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParentSectionId(Integer value) {
        this.parentSectionId = value;
    }

    /**
     * 获取parents属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ> getParents() {
        return parents;
    }

    /**
     * 设置parents属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ }{@code >}
     *     
     */
    public void setParents(JAXBElement<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ> value) {
        this.parents = value;
    }

    /**
     * 获取rootSectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRootSectionId() {
        return rootSectionId;
    }

    /**
     * 设置rootSectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRootSectionId(Integer value) {
        this.rootSectionId = value;
    }

    /**
     * 获取sectionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 设置sectionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSectionId(Integer value) {
        this.sectionId = value;
    }

    /**
     * 获取sectionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSectionName() {
        return sectionName;
    }

    /**
     * 设置sectionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSectionName(JAXBElement<String> value) {
        this.sectionName = value;
    }

}
