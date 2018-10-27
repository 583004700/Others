
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ExamRulerTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ExamRulerTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Graduation_Exam"/&gt;
 *     &lt;enumeration value="Middle_Exam"/&gt;
 *     &lt;enumeration value="Final_Exam"/&gt;
 *     &lt;enumeration value="Monthly_Exam"/&gt;
 *     &lt;enumeration value="XueKao_Exam"/&gt;
 *     &lt;enumeration value="PeiYou_Exam_I"/&gt;
 *     &lt;enumeration value="PeiYou_Exam_II"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExamRulerTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum ExamRulerTypeEnum {

    @XmlEnumValue("Graduation_Exam")
    GRADUATION_EXAM("Graduation_Exam"),
    @XmlEnumValue("Middle_Exam")
    MIDDLE_EXAM("Middle_Exam"),
    @XmlEnumValue("Final_Exam")
    FINAL_EXAM("Final_Exam"),
    @XmlEnumValue("Monthly_Exam")
    MONTHLY_EXAM("Monthly_Exam"),
    @XmlEnumValue("XueKao_Exam")
    XUE_KAO_EXAM("XueKao_Exam"),
    @XmlEnumValue("PeiYou_Exam_I")
    PEI_YOU_EXAM_I("PeiYou_Exam_I"),
    @XmlEnumValue("PeiYou_Exam_II")
    PEI_YOU_EXAM_II("PeiYou_Exam_II");
    private final String value;

    ExamRulerTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExamRulerTypeEnum fromValue(String v) {
        for (ExamRulerTypeEnum c: ExamRulerTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
