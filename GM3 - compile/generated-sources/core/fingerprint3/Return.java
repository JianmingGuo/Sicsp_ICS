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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Return complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取details属性的值。
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
     * 设置details属性的值。
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
     * 获取direction属性的值。
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
     * 设置direction属性的值。
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
     * 获取confidence属性的值。
     * 
     */
    public int getConfidence() {
        return confidence;
    }

    /**
     * 设置confidence属性的值。
     * 
     */
    public void setConfidence(int value) {
        this.confidence = value;
    }

}
