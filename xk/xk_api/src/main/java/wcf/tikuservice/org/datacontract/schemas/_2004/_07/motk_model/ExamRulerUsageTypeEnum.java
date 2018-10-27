
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExamRulerUsageTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ExamRulerUsageTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Prediction"/&gt;
 *     &lt;enumeration value="Improvement"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExamRulerUsageTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum ExamRulerUsageTypeEnum {

    @XmlEnumValue("Prediction")
    PREDICTION("Prediction"),
    @XmlEnumValue("Improvement")
    IMPROVEMENT("Improvement");
    private final String value;

    ExamRulerUsageTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExamRulerUsageTypeEnum fromValue(String v) {
        for (ExamRulerUsageTypeEnum c: ExamRulerUsageTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
