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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Anchor complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Anchor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute ref="{}Cursor use="required""/>
 *       &lt;attribute ref="{}Position"/>
 *       &lt;attribute ref="{}Relative"/>
 *       &lt;attribute ref="{}Offset"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Anchor")
public class Anchor {

    @XmlAttribute(name = "Cursor", required = true)
    protected Cursor cursor;
    @XmlAttribute(name = "Position")
    protected Position position;
    @XmlAttribute(name = "Relative")
    protected Boolean relative;
    @XmlAttribute(name = "Offset")
    protected Integer offset;

    /**
     * ��ȡcursor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Cursor }
     *     
     */
    public Cursor getCursor() {
        return cursor;
    }

    /**
     * ����cursor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Cursor }
     *     
     */
    public void setCursor(Cursor value) {
        this.cursor = value;
    }

    /**
     * ��ȡposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Position }
     *     
     */
    public Position getPosition() {
        return position;
    }

    /**
     * ����position���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Position }
     *     
     */
    public void setPosition(Position value) {
        this.position = value;
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

}
