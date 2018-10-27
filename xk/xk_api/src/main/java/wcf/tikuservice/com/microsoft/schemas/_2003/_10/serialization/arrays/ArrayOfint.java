
package wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>ArrayOfint complex type的 Java 类。 <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="int" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfint", propOrder = {"_int"})
public class ArrayOfint
{

    @XmlElement(name = "int", type = Integer.class)
    protected List<Integer> _int;

    /**
     * Gets the value of the int property. <p> This accessor method returns a reference to the live
     * list, not a snapshot. Therefore any modification you make to the returned list will be
     * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
     * int property. <p> For example, to add a new item, do as follows:
     * 
     * <pre>
     * getInt().add(newItem);
     * </pre>
     * 
     * <p> Objects of the following type(s) are allowed in the list {@link Integer }
     */
    public List<Integer> getInt()
    {
        if (_int == null)
        {
            _int = new ArrayList<Integer>();
        }
        return this._int;
    }

    /**
     * <描述方法的作用>
     * 
     * @Title: setInt
     * @author 幸仁强
     * @param questionIds
     */

    public void setInt(List<Integer> questionIds)
    {
        this._int = questionIds;
    }

}
