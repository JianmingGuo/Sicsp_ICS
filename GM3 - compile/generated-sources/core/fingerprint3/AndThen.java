//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.05.23 时间 11:55:04 PM CST 
//


package core.fingerprint3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}Operation"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "matchOrByteTestOrIsDataAt"
})
@XmlRootElement(name = "AndThen")
public class AndThen {

    @XmlElements({
        @XmlElement(name = "Match", type = MatchFunction.class),
        @XmlElement(name = "ByteTest", type = ByteTestFunction.class),
        @XmlElement(name = "IsDataAt", type = IsDataAtFunction.class),
        @XmlElement(name = "ByteJump", type = ByteJumpFunction.class),
        @XmlElement(name = "Anchor", type = Anchor.class),
        @XmlElement(name = "Return", type = Return.class)
    })
    protected List<Object> matchOrByteTestOrIsDataAt;

    /**
     * Gets the value of the matchOrByteTestOrIsDataAt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchOrByteTestOrIsDataAt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchOrByteTestOrIsDataAt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchFunction }
     * {@link ByteTestFunction }
     * {@link IsDataAtFunction }
     * {@link ByteJumpFunction }
     * {@link Anchor }
     * {@link Return }
     * 
     * 
     */
    public List<Object> getMatchOrByteTestOrIsDataAt() {
        if (matchOrByteTestOrIsDataAt == null) {
            matchOrByteTestOrIsDataAt = new ArrayList<Object>();
        }
        return this.matchOrByteTestOrIsDataAt;
    }

}
