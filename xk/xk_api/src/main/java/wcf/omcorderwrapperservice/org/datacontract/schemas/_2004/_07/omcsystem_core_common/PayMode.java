
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PayMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="PayMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="WeChat"/&gt;
 *     &lt;enumeration value="Alipay"/&gt;
 *     &lt;enumeration value="Exchange"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PayMode", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums")
@XmlEnum
public enum PayMode {

    @XmlEnumValue("WeChat")
    WE_CHAT("WeChat"),
    @XmlEnumValue("Alipay")
    ALIPAY("Alipay"),
    @XmlEnumValue("Exchange")
    EXCHANGE("Exchange");
    private final String value;

    PayMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PayMode fromValue(String v) {
        for (PayMode c: PayMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
