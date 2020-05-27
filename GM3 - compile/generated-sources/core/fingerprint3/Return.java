//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2020.05.23 ʱ�� 11:55:04 PM CST 
//


package core.fingerprint3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Return complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Return">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Details" type="{}DetailGroup"/>
 *         &lt;/choice>
 *         &lt;element ref="{}Extract" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}Direction default="SOURCE""/>
 *       &lt;attribute name="Confidence" use="required" type="{}Confidence" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Return", propOrder = {
    "details",
    "extract"
})
public class Return {

    @XmlElement(name = "Details")
    protected DetailGroup details;
    @XmlElement(name = "Extract")
    protected List<Extract> extract;
    @XmlAttribute(name = "Direction")
    protected String direction;
    @XmlAttribute(name = "Confidence", required = true)
    protected int confidence;

    /**
     * ��ȡdetails���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DetailGroup }
     *     
     */
    public DetailGroup getDetails() {
        return details;
    }

    /**
     * ����details���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DetailGroup }
     *     
     */
    public void setDetails(DetailGroup value) {
        this.details = value;
    }

    /**
     * Gets the value of the extract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extract }
     * 
     * 
     */
    public List<Extract> getExtract() {
        if (extract == null) {
            extract = new ArrayList<Extract>();
        }
        return this.extract;
    }

    /**
     * ��ȡdirection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        if (direction == null) {
            return "SOURCE";
        } else {
            return direction;
        }
    }

    /**
     * ����direction���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * ��ȡconfidence���Ե�ֵ��
     * 
     */
    public int getConfidence() {
        return confidence;
    }

    /**
     * ����confidence���Ե�ֵ��
     * 
     */
    public void setConfidence(int value) {
        this.confidence = value;
    }

}
