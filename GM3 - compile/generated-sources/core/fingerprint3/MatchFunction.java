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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>MatchFunction complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MatchFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Pattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="Content">
 *             &lt;complexType>
 *               &lt;simpleContent>
 *                 &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                   &lt;attribute name="Type" use="required" type="{}ContentType" />
 *                 &lt;/extension>
 *               &lt;/simpleContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element ref="{}AndThen"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Offset" type="{}FrameSize" default="0" />
 *       &lt;attribute name="Reverse" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="NoCase" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="Depth" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="0" />
 *       &lt;attribute name="Relative" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="Within" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="0" />
 *       &lt;attribute name="MoveCursors" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchFunction", propOrder = {
    "pattern",
    "content",
    "andThen"
})
public class MatchFunction {

    @XmlElement(name = "Pattern")
    protected String pattern;
    @XmlElement(name = "Content")
    protected MatchFunction.Content content;
    @XmlElement(name = "AndThen", required = true)
    protected AndThen andThen;
    @XmlAttribute(name = "Offset")
    protected Integer offset;
    @XmlAttribute(name = "Reverse")
    protected Boolean reverse;
    @XmlAttribute(name = "NoCase")
    protected Boolean noCase;
    @XmlAttribute(name = "Depth")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer depth;
    @XmlAttribute(name = "Relative")
    protected Boolean relative;
    @XmlAttribute(name = "Within")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer within;
    @XmlAttribute(name = "MoveCursors")
    protected Boolean moveCursors;

    /**
     * ��ȡpattern���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * ����pattern���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * ��ȡcontent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MatchFunction.Content }
     *     
     */
    public MatchFunction.Content getContent() {
        return content;
    }

    /**
     * ����content���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MatchFunction.Content }
     *     
     */
    public void setContent(MatchFunction.Content value) {
        this.content = value;
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
     * ��ȡreverse���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReverse() {
        if (reverse == null) {
            return true;
        } else {
            return reverse;
        }
    }

    /**
     * ����reverse���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReverse(Boolean value) {
        this.reverse = value;
    }

    /**
     * ��ȡnoCase���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNoCase() {
        if (noCase == null) {
            return false;
        } else {
            return noCase;
        }
    }

    /**
     * ����noCase���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoCase(Boolean value) {
        this.noCase = value;
    }

    /**
     * ��ȡdepth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getDepth() {
        if (depth == null) {
            return  0;
        } else {
            return depth;
        }
    }

    /**
     * ����depth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepth(Integer value) {
        this.depth = value;
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
            return true;
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
     * ��ȡwithin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getWithin() {
        if (within == null) {
            return  0;
        } else {
            return within;
        }
    }

    /**
     * ����within���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWithin(Integer value) {
        this.within = value;
    }

    /**
     * ��ȡmoveCursors���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMoveCursors() {
        if (moveCursors == null) {
            return true;
        } else {
            return moveCursors;
        }
    }

    /**
     * ����moveCursors���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMoveCursors(Boolean value) {
        this.moveCursors = value;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="Type" use="required" type="{}ContentType" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Content {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "Type", required = true)
        protected ContentType type;

        /**
         * ��ȡvalue���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * ����value���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * ��ȡtype���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link ContentType }
         *     
         */
        public ContentType getType() {
            return type;
        }

        /**
         * ����type���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link ContentType }
         *     
         */
        public void setType(ContentType value) {
            this.type = value;
        }

    }

}
