//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2020.05.23 ʱ�� 11:55:04 PM CST 
//


package core.fingerprint3;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ByteTestFunction complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡgt���Ե�ֵ��
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
     * ����gt���Ե�ֵ��
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
     * ��ȡlt���Ե�ֵ��
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
     * ����lt���Ե�ֵ��
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
     * ��ȡgte���Ե�ֵ��
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
     * ����gte���Ե�ֵ��
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
     * ��ȡlte���Ե�ֵ��
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
     * ����lte���Ե�ֵ��
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
     * ��ȡeq���Ե�ֵ��
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
     * ����eq���Ե�ֵ��
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
     * ��ȡand���Ե�ֵ��
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
     * ����and���Ե�ֵ��
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
     * ��ȡor���Ե�ֵ��
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
     * ����or���Ե�ֵ��
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
     * ��ȡandThen���Ե�ֵ��
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
     * ����andThen���Ե�ֵ��
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
     * ��ȡpostOffset���Ե�ֵ��
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
     * ����postOffset���Ե�ֵ��
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
     * ��ȡrelative���Ե�ֵ��
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
     * ����relative���Ե�ֵ��
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
     * ��ȡendian���Ե�ֵ��
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
     * ����endian���Ե�ֵ��
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
     * ��ȡoffset���Ե�ֵ��
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
     * ����offset���Ե�ֵ��
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
     * ��ȡbytes���Ե�ֵ��
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
     * ����bytes���Ե�ֵ��
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
