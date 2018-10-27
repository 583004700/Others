
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Success"/&gt;
 *     &lt;enumeration value="WaitPay"/&gt;
 *     &lt;enumeration value="Refund"/&gt;
 *     &lt;enumeration value="PayFailure"/&gt;
 *     &lt;enumeration value="Close"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransactionType", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums")
@XmlEnum
public enum TransactionType {

    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("WaitPay")
    WAIT_PAY("WaitPay"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("PayFailure")
    PAY_FAILURE("PayFailure"),
    @XmlEnumValue("Close")
    CLOSE("Close");
    private final String value;

    TransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionType fromValue(String v) {
        for (TransactionType c: TransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
