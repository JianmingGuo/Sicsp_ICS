//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2020.05.23 ʱ�� 11:55:04 PM CST 
//


package core.fingerprint3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence>
 *         &lt;element name="Header" type="{}Header"/>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element name="Filter">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence maxOccurs="unbounded">
 *                     &lt;element name="Ack" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="MSS" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="Dsize" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="DsizeWithin" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                             &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="DstPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="Ethertype" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="Flags" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;pattern value="((NS)|(CWR)|(ECE)|(URG)|(ACK)|(PSH)|(RST)|(SYN)|(FIN)){1,9}"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="Seq" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="SrcPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="TransportProtocol" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="TTL" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;element name="TTLWithin" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                             &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Window" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="For" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *         &lt;element name="Payload" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;sequence>
 *                     &lt;element name="Always" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{}Return" maxOccurs="unbounded"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;group ref="{}Operation" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="For" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "filter",
    "payload"
})
@XmlRootElement(name = "Fingerprint")
public class Fingerprint {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "Filter", required = true)
    protected List<Fingerprint.Filter> filter;
    @XmlElement(name = "Payload")
    protected List<Fingerprint.Payload> payload;

    /**
     * ��ȡheader���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * ����header���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fingerprint.Filter }
     * 
     * 
     */
    public List<Fingerprint.Filter> getFilter() {
        if (filter == null) {
            filter = new ArrayList<Fingerprint.Filter>();
        }
        return this.filter;
    }

    /**
     * Gets the value of the payload property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payload property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayload().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fingerprint.Payload }
     * 
     * 
     */
    public List<Fingerprint.Payload> getPayload() {
        if (payload == null) {
            payload = new ArrayList<Fingerprint.Payload>();
        }
        return this.payload;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Ack" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="MSS" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Dsize" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="DsizeWithin" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DstPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Ethertype" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Flags" maxOccurs="unbounded" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="((NS)|(CWR)|(ECE)|(URG)|(ACK)|(PSH)|(RST)|(SYN)|(FIN)){1,9}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Seq" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="SrcPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="TransportProtocol" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="TTL" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="TTLWithin" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Window" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="For" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ackAndMSSAndDsize"
    })
    public static class Filter {

        @XmlElementRefs({
            @XmlElementRef(name = "Ethertype", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "MSS", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Seq", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Dsize", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "DstPort", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Flags", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "TTL", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "TransportProtocol", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "TTLWithin", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "DsizeWithin", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Window", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "Ack", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "SrcPort", type = JAXBElement.class, required = false)
        })
        protected List<JAXBElement<?>> ackAndMSSAndDsize;
        @XmlAttribute(name = "For", required = true)
        protected String _for;
        @XmlAttribute(name = "Name")
        protected String name;

        /**
         * Gets the value of the ackAndMSSAndDsize property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ackAndMSSAndDsize property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAckAndMSSAndDsize().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link Integer }{@code >}
         * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
         * {@link JAXBElement }{@code <}{@link Long }{@code >}
         * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
         * {@link JAXBElement }{@code <}{@link Integer }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
         * {@link JAXBElement }{@code <}{@link Short }{@code >}
         * {@link JAXBElement }{@code <}{@link Fingerprint.Filter.TTLWithin }{@code >}
         * {@link JAXBElement }{@code <}{@link Fingerprint.Filter.DsizeWithin }{@code >}
         * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
         * {@link JAXBElement }{@code <}{@link Long }{@code >}
         * {@link JAXBElement }{@code <}{@link Integer }{@code >}
         * 
         * 
         */
        public List<JAXBElement<?>> getAckAndMSSAndDsize() {
            if (ackAndMSSAndDsize == null) {
                ackAndMSSAndDsize = new ArrayList<JAXBElement<?>>();
            }
            return this.ackAndMSSAndDsize;
        }

        /**
         * ��ȡfor���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFor() {
            return _for;
        }

        /**
         * ����for���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFor(String value) {
            this._for = value;
        }

        /**
         * ��ȡname���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * ����name���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }


        /**
         * <p>anonymous complex type�� Java �ࡣ
         * 
         * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DsizeWithin {

            @XmlAttribute(name = "Min")
            protected BigInteger min;
            @XmlAttribute(name = "Max")
            protected BigInteger max;

            /**
             * ��ȡmin���Ե�ֵ��
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMin() {
                return min;
            }

            /**
             * ����min���Ե�ֵ��
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMin(BigInteger value) {
                this.min = value;
            }

            /**
             * ��ȡmax���Ե�ֵ��
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMax() {
                return max;
            }

            /**
             * ����max���Ե�ֵ��
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMax(BigInteger value) {
                this.max = value;
            }

        }


        /**
         * <p>anonymous complex type�� Java �ࡣ
         * 
         * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="Min" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="Max" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TTLWithin {

            @XmlAttribute(name = "Min")
            protected BigInteger min;
            @XmlAttribute(name = "Max")
            protected BigInteger max;

            /**
             * ��ȡmin���Ե�ֵ��
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMin() {
                return min;
            }

            /**
             * ����min���Ե�ֵ��
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMin(BigInteger value) {
                this.min = value;
            }

            /**
             * ��ȡmax���Ե�ֵ��
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMax() {
                return max;
            }

            /**
             * ����max���Ե�ֵ��
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMax(BigInteger value) {
                this.max = value;
            }

        }

    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;sequence>
     *           &lt;element name="Always" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{}Return" maxOccurs="unbounded"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;group ref="{}Operation" maxOccurs="unbounded"/>
     *         &lt;/sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="For" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description",
        "always",
        "operation"
    })
    public static class Payload {

        @XmlElement(name = "Description")
        protected String description;
        @XmlElement(name = "Always")
        protected Fingerprint.Payload.Always always;
        @XmlElements({
            @XmlElement(name = "Match", type = MatchFunction.class),
            @XmlElement(name = "ByteTest", type = ByteTestFunction.class),
            @XmlElement(name = "IsDataAt", type = IsDataAtFunction.class),
            @XmlElement(name = "ByteJump", type = ByteJumpFunction.class),
            @XmlElement(name = "Anchor", type = Anchor.class),
            @XmlElement(name = "Return", type = Return.class)
        })
        protected List<Object> operation;
        @XmlAttribute(name = "For", required = true)
        protected String _for;

        /**
         * ��ȡdescription���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * ����description���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * ��ȡalways���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link Fingerprint.Payload.Always }
         *     
         */
        public Fingerprint.Payload.Always getAlways() {
            return always;
        }

        /**
         * ����always���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link Fingerprint.Payload.Always }
         *     
         */
        public void setAlways(Fingerprint.Payload.Always value) {
            this.always = value;
        }

        /**
         * Gets the value of the operation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MatchFunction }
         * {@link ByteTestFunction }
         * {@link IsDataAtFunction }
         * {@link ByteJumpFunction }
         * {@link Anchor }
         * {@link Return }
         * 
         * 
         */
        public List<Object> getOperation() {
            if (operation == null) {
                operation = new ArrayList<Object>();
            }
            return this.operation;
        }

        /**
         * ��ȡfor���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFor() {
            return _for;
        }

        /**
         * ����for���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFor(String value) {
            this._for = value;
        }


        /**
         * <p>anonymous complex type�� Java �ࡣ
         * 
         * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{}Return" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "_return"
        })
        public static class Always {

            @XmlElement(name = "Return", required = true)
            protected List<Return> _return;

            /**
             * Gets the value of the return property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the return property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReturn().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Return }
             * 
             * 
             */
            public List<Return> getReturn() {
                if (_return == null) {
                    _return = new ArrayList<Return>();
                }
                return this._return;
            }

        }

    }

}
