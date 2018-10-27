
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PayMethod的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="PayMethod"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Unifiedorder"/&gt;
 *     &lt;enumeration value="Orderquery"/&gt;
 *     &lt;enumeration value="CloseOrder"/&gt;
 *     &lt;enumeration value="Refundquery"/&gt;
 *     &lt;enumeration value="Micropay"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PayMethod", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.ThirdParty.WeChat")
@XmlEnum
public enum PayMethod {

    @XmlEnumValue("Unifiedorder")
    UNIFIEDORDER("Unifiedorder"),
    @XmlEnumValue("Orderquery")
    ORDERQUERY("Orderquery"),
    @XmlEnumValue("CloseOrder")
    CLOSE_ORDER("CloseOrder"),
    @XmlEnumValue("Refundquery")
    REFUNDQUERY("Refundquery"),
    @XmlEnumValue("Micropay")
    MICROPAY("Micropay");
    private final String value;

    PayMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PayMethod fromValue(String v) {
        for (PayMethod c: PayMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
