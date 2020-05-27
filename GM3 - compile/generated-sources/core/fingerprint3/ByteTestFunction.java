//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.05.23 时间 11:55:04 PM CST 
//


package core.fingerprint3;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ByteTestFunction complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ByteTestFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="GT" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="LT" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="GTE" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="LTE" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="EQ" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="AND" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element name="OR" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;/choice>
 *         &lt;element ref="{}AndThen"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}PostOffset default="0""/>
 *       &lt;attribute ref="{}Relative"/>
 *       &lt;attribute ref="{}Endian default="BIG""/>
 *       &lt;attribute ref="{}Offset default="0""/>
 *       &lt;attribute ref="{}Bytes default="1""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByteTestFunction", propOrder = {
    "gt",
    "lt",
    "gte",
    "lte",
    "eq",
    "and",
    "or",
    "andThen"
})
public class ByteTestFunction {

    @XmlElement(name = "GT")
    protected BigInteger gt;
    @XmlElement(name = "LT")
    protected BigInteger lt;
    @XmlElement(name = "GTE")
    protected BigInteger gte;
    @XmlElement(name = "LTE")
    protected BigInteger lte;
    @XmlElement(name = "EQ")
    protected BigInteger eq;
    @XmlElement(name = "AND")
    protected BigInteger and;
    @XmlElement(name = "OR")
    protected BigInteger or;
    @XmlElement(name = "AndThen", required = true)
    protected AndThen andThen;
    @XmlAttribute(name = "PostOffset")
    protected Integer postOffset;
    @XmlAttribute(name = "Relative")
    protected Boolean relative;
    @XmlAttribute(name = "Endian")
    protected String endian;
    @XmlAttribute(name = "Offset")
    protected Integer offset;
    @XmlAttribute(name = "Bytes")
    protected Integer bytes;

    /**
     * 获取gt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGT() {
        return gt;
    }

    /**
     * 设置gt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGT(BigInteger value) {
        this.gt = value;
    }

    /**
     * 获取lt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLT() {
        return lt;
    }

    /**
     * 设置lt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLT(BigInteger value) {
        this.lt = value;
    }

    /**
     * 获取gte属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGTE() {
        return gte;
    }

    /**
     * 设置gte属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGTE(BigInteger value) {
        this.gte = value;
    }

    /**
     * 获取lte属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLTE() {
        return lte;
    }

    /**
     * 设置lte属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLTE(BigInteger value) {
        this.lte = value;
    }

    /**
     * 获取eq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEQ() {
        return eq;
    }

    /**
     * 设置eq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEQ(BigInteger value) {
        this.eq = value;
    }

    /**
     * 获取and属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAND() {
        return and;
    }

    /**
     * 设置and属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAND(BigInteger value) {
        this.and = value;
    }

    /**
     * 获取or属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOR() {
        return or;
    }

    /**
     * 设置or属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOR(BigInteger value) {
        this.or = value;
    }

    /**
     * 获取andThen属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AndThen }
     *     
     */
    public AndThen getAndThen() {
        return andThen;
    }

    /**
     * 设置andThen属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AndThen }
     *     
     */
    public void setAndThen(AndThen value) {
        this.andThen = value;
    }

    /**
     * 获取postOffset属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getPostOffset() {
        if (postOffset == null) {
            return  0;
        } else {
            return postOffset;
        }
    }

    /**
     * 设置postOffset属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPostOffset(Integer value) {
        this.postOffset = value;
    }

    /**
     * 获取relative属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRelative() {
        if (relative == null) {
            return false;
        } else {
            return relative;
        }
    }

    /**
     * 设置relative属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRelative(Boolean value) {
        this.relative = value;
    }

    /**
     * 获取endian属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndian() {
        if (endian == null) {
            return "BIG";
        } else {
            return endian;
        }
    }

    /**
     * 设置endian属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndian(String value) {
        this.endian = value;
    }

    /**
     * 获取offset属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getOffset() {
        if (offset == null) {
            return  0;
        } else {
            return offset;
        }
    }

    /**
     * 设置offset属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOffset(Integer value) {
        this.offset = value;
    }

    /**
     * 获取bytes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getBytes() {
        if (bytes == null) {
            return  1;
        } else {
            return bytes;
        }
    }

    /**
     * 设置bytes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBytes(Integer value) {
        this.bytes = value;
    }

}
