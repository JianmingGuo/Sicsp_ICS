//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.05.23 时间 11:55:04 PM CST 
//


package core.fingerprint3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Position的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Position">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="START_OF_PAYLOAD"/>
 *     &lt;enumeration value="END_OF_PAYLOAD"/>
 *     &lt;enumeration value="CURSOR_START"/>
 *     &lt;enumeration value="CURSOR_MAIN"/>
 *     &lt;enumeration value="CURSOR_END"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Position")
@XmlEnum
public enum Position {

    START_OF_PAYLOAD,
    END_OF_PAYLOAD,
    CURSOR_START,
    CURSOR_MAIN,
    CURSOR_END;

    public String value() {
        return name();
    }

    public static Position fromValue(String v) {
        return valueOf(v);
    }

}
