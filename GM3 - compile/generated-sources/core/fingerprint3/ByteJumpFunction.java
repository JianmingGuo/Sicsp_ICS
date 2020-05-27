//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2020.05.23 ʱ�� 11:55:04 PM CST 
//


package core.fingerprint3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ByteJumpFunction complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ByteJumpFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Calc" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="((\d+)|x)([-+/*]((\d+)|x))*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{}AndThen"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}PostOffset"/>
 *       &lt;attribute ref="{}Relative"/>
 *       &lt;attribute ref="{}Endian"/>
 *       &lt;attribute ref="{}Offset"/>
 *       &lt;attribute ref="{}Bytes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByteJumpFunction", propOrder = {
    "calc",
    "andThen"
})
public class ByteJumpFunction {

    @XmlElement(name = "Calc")
    protected String calc;
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
     * ��ȡcalc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalc() {
        return calc;
    }

    /**
     * ����calc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalc(String value) {
        this.calc = value;
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
    public Integer getPostOffset() {
        return postOffset;
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
        return endian;
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
    public Integer getOffset() {
        return offset;
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
    public Integer getBytes() {
        return bytes;
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
