
package wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TradeTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="TradeTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="JSAPI"/&gt;
 *     &lt;enumeration value="NATIVE"/&gt;
 *     &lt;enumeration value="APP"/&gt;
 *     &lt;enumeration value="MICROPAY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TradeTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.Enums")
@XmlEnum
public enum TradeTypeEnum {

    JSAPI,
    NATIVE,
    APP,
    MICROPAY;

    public String value() {
        return name();
    }

    public static TradeTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
