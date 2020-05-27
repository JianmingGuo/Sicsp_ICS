//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.05.23 时间 11:55:04 PM CST 
//


package core.fingerprint3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="Convert" type="{}ContentType" />
 *       &lt;attribute name="Lookup">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="BACNET"/>
 *             &lt;enumeration value="ENIPVENDOR"/>
 *             &lt;enumeration value="ENIPDEVICE"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Post")
public class Post {

    @XmlAttribute(name = "Convert")
    protected ContentType convert;
    @XmlAttribute(name = "Lookup")
    protected String lookup;

    /**
     * 获取convert属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getConvert() {
        return convert;
    }

    /**
     * 设置convert属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setConvert(ContentType value) {
        this.convert = value;
    }

    /**
     * 获取lookup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookup() {
        return lookup;
    }

    /**
     * 设置lookup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookup(String value) {
        this.lookup = value;
    }

}
