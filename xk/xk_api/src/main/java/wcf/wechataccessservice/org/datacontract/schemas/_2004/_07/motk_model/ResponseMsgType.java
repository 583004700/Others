
package wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResponseMsgType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ResponseMsgType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="News"/&gt;
 *     &lt;enumeration value="Music"/&gt;
 *     &lt;enumeration value="Image"/&gt;
 *     &lt;enumeration value="Voice"/&gt;
 *     &lt;enumeration value="Video"/&gt;
 *     &lt;enumeration value="Transfer_Customer_Service"/&gt;
 *     &lt;enumeration value="Logout"/&gt;
 *     &lt;enumeration value="subscribe"/&gt;
 *     &lt;enumeration value="unsubscribe"/&gt;
 *     &lt;enumeration value="ContactCustomer"/&gt;
 *     &lt;enumeration value="Scan"/&gt;
 *     &lt;enumeration value="MemberActivity"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResponseMsgType", namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum")
@XmlEnum
public enum ResponseMsgType {

    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("News")
    NEWS("News"),
    @XmlEnumValue("Music")
    MUSIC("Music"),
    @XmlEnumValue("Image")
    IMAGE("Image"),
    @XmlEnumValue("Voice")
    VOICE("Voice"),
    @XmlEnumValue("Video")
    VIDEO("Video"),
    @XmlEnumValue("Transfer_Customer_Service")
    TRANSFER_CUSTOMER_SERVICE("Transfer_Customer_Service"),
    @XmlEnumValue("Logout")
    LOGOUT("Logout"),
    @XmlEnumValue("subscribe")
    SUBSCRIBE("subscribe"),
    @XmlEnumValue("unsubscribe")
    UNSUBSCRIBE("unsubscribe"),
    @XmlEnumValue("ContactCustomer")
    CONTACT_CUSTOMER("ContactCustomer"),
    @XmlEnumValue("Scan")
    SCAN("Scan"),
    @XmlEnumValue("MemberActivity")
    MEMBER_ACTIVITY("MemberActivity");
    private final String value;

    ResponseMsgType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponseMsgType fromValue(String v) {
        for (ResponseMsgType c: ResponseMsgType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
