
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResultTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ResultTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Success"/&gt;
 *     &lt;enumeration value="ValidateError"/&gt;
 *     &lt;enumeration value="Error"/&gt;
 *     &lt;enumeration value="Exception"/&gt;
 *     &lt;enumeration value="AuthorityCheck"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResultTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum ResultTypeEnum {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("ValidateError")
    VALIDATE_ERROR("ValidateError"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Exception")
    EXCEPTION("Exception"),
    @XmlEnumValue("AuthorityCheck")
    AUTHORITY_CHECK("AuthorityCheck");
    private final String value;

    ResultTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultTypeEnum fromValue(String v) {
        for (ResultTypeEnum c: ResultTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
