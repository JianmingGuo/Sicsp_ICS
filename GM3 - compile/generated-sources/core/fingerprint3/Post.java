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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡconvert���Ե�ֵ��
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
     * ����convert���Ե�ֵ��
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
     * ��ȡlookup���Ե�ֵ��
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
     * ����lookup���Ե�ֵ��
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
