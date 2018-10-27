
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RequestFromTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="RequestFromTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Pc"/&gt;
 *     &lt;enumeration value="Android"/&gt;
 *     &lt;enumeration value="Ios"/&gt;
 *     &lt;enumeration value="Ahd"/&gt;
 *     &lt;enumeration value="Wap"/&gt;
 *     &lt;enumeration value="Ihd"/&gt;
 *     &lt;enumeration value="Api"/&gt;
 *     &lt;enumeration value="Java"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RequestFromTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum RequestFromTypeEnum {

    @XmlEnumValue("Pc")
    PC("Pc"),
    @XmlEnumValue("Android")
    ANDROID("Android"),
    @XmlEnumValue("Ios")
    IOS("Ios"),
    @XmlEnumValue("Ahd")
    AHD("Ahd"),
    @XmlEnumValue("Wap")
    WAP("Wap"),
    @XmlEnumValue("Ihd")
    IHD("Ihd"),
    @XmlEnumValue("Api")
    API("Api"),
    @XmlEnumValue("Java")
    JAVA("Java");
    private final String value;

    RequestFromTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequestFromTypeEnum fromValue(String v) {
        for (RequestFromTypeEnum c: RequestFromTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
