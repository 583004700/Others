
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GradeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="GradeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Seven"/&gt;
 *     &lt;enumeration value="Eight"/&gt;
 *     &lt;enumeration value="Nine"/&gt;
 *     &lt;enumeration value="SeniorOne"/&gt;
 *     &lt;enumeration value="SeniorTwo"/&gt;
 *     &lt;enumeration value="SeniorThree"/&gt;
 *     &lt;enumeration value="GradeOne"/&gt;
 *     &lt;enumeration value="GradeTwo"/&gt;
 *     &lt;enumeration value="GradeThree"/&gt;
 *     &lt;enumeration value="GradeFour"/&gt;
 *     &lt;enumeration value="GradeFive"/&gt;
 *     &lt;enumeration value="GradeSix"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GradeEnum", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum GradeEnum {

    @XmlEnumValue("Seven")
    SEVEN("Seven"),
    @XmlEnumValue("Eight")
    EIGHT("Eight"),
    @XmlEnumValue("Nine")
    NINE("Nine"),
    @XmlEnumValue("SeniorOne")
    SENIOR_ONE("SeniorOne"),
    @XmlEnumValue("SeniorTwo")
    SENIOR_TWO("SeniorTwo"),
    @XmlEnumValue("SeniorThree")
    SENIOR_THREE("SeniorThree"),
    @XmlEnumValue("GradeOne")
    GRADE_ONE("GradeOne"),
    @XmlEnumValue("GradeTwo")
    GRADE_TWO("GradeTwo"),
    @XmlEnumValue("GradeThree")
    GRADE_THREE("GradeThree"),
    @XmlEnumValue("GradeFour")
    GRADE_FOUR("GradeFour"),
    @XmlEnumValue("GradeFive")
    GRADE_FIVE("GradeFive"),
    @XmlEnumValue("GradeSix")
    GRADE_SIX("GradeSix");
    private final String value;

    GradeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GradeEnum fromValue(String v) {
        for (GradeEnum c: GradeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
