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
 * <p>IsDataAtFunction complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IsDataAtFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}AndThen"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Offset" use="required" type="{}FrameSize" />
 *       &lt;attribute ref="{}Relative"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsDataAtFunction", propOrder = {
    "andThen"
})
public class IsDataAtFunction {

    @XmlElement(name = "AndThen", required = true)
    protected AndThen andThen;
    @XmlAttribute(name = "Offset", required = true)
    protected int offset;
    @XmlAttribute(name = "Relative")
    protected Boolean relative;

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
     * ��ȡoffset���Ե�ֵ��
     * 
     */
    public int getOffset() {
        return offset;
    }

    /**
     * ����offset���Ե�ֵ��
     * 
     */
    public void setOffset(int value) {
        this.offset = value;
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

}
