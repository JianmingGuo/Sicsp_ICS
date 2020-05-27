//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2020.05.23 ʱ�� 11:55:04 PM CST 
//


package core.fingerprint3;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the core.fingerprint3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Anchor_QNAME = new QName("", "Anchor");
    private final static QName _Return_QNAME = new QName("", "Return");
    private final static QName _FingerprintFilterWindow_QNAME = new QName("", "Window");
    private final static QName _FingerprintFilterSrcPort_QNAME = new QName("", "SrcPort");
    private final static QName _FingerprintFilterAck_QNAME = new QName("", "Ack");
    private final static QName _FingerprintFilterDstPort_QNAME = new QName("", "DstPort");
    private final static QName _FingerprintFilterFlags_QNAME = new QName("", "Flags");
    private final static QName _FingerprintFilterMSS_QNAME = new QName("", "MSS");
    private final static QName _FingerprintFilterTTL_QNAME = new QName("", "TTL");
    private final static QName _FingerprintFilterDsize_QNAME = new QName("", "Dsize");
    private final static QName _FingerprintFilterTTLWithin_QNAME = new QName("", "TTLWithin");
    private final static QName _FingerprintFilterDsizeWithin_QNAME = new QName("", "DsizeWithin");
    private final static QName _FingerprintFilterEthertype_QNAME = new QName("", "Ethertype");
    private final static QName _FingerprintFilterTransportProtocol_QNAME = new QName("", "TransportProtocol");
    private final static QName _FingerprintFilterSeq_QNAME = new QName("", "Seq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: core.fingerprint3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fingerprint }
     * 
     */
    public Fingerprint createFingerprint() {
        return new Fingerprint();
    }

    /**
     * Create an instance of {@link DetailGroup }
     * 
     */
    public DetailGroup createDetailGroup() {
        return new DetailGroup();
    }

    /**
     * Create an instance of {@link MatchFunction }
     * 
     */
    public MatchFunction createMatchFunction() {
        return new MatchFunction();
    }

    /**
     * Create an instance of {@link Fingerprint.Payload }
     * 
     */
    public Fingerprint.Payload createFingerprintPayload() {
        return new Fingerprint.Payload();
    }

    /**
     * Create an instance of {@link Fingerprint.Filter }
     * 
     */
    public Fingerprint.Filter createFingerprintFilter() {
        return new Fingerprint.Filter();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Anchor }
     * 
     */
    public Anchor createAnchor() {
        return new Anchor();
    }

    /**
     * Create an instance of {@link Return }
     * 
     */
    public Return createReturn() {
        return new Return();
    }

    /**
     * Create an instance of {@link Post }
     * 
     */
    public Post createPost() {
        return new Post();
    }

    /**
     * Create an instance of {@link AndThen }
     * 
     */
    public AndThen createAndThen() {
        return new AndThen();
    }

    /**
     * Create an instance of {@link ByteTestFunction }
     * 
     */
    public ByteTestFunction createByteTestFunction() {
        return new ByteTestFunction();
    }

    /**
     * Create an instance of {@link IsDataAtFunction }
     * 
     */
    public IsDataAtFunction createIsDataAtFunction() {
        return new IsDataAtFunction();
    }

    /**
     * Create an instance of {@link ByteJumpFunction }
     * 
     */
    public ByteJumpFunction createByteJumpFunction() {
        return new ByteJumpFunction();
    }

    /**
     * Create an instance of {@link Extract }
     * 
     */
    public Extract createExtract() {
        return new Extract();
    }

    /**
     * Create an instance of {@link OPERATOR }
     * 
     */
    public OPERATOR createOPERATOR() {
        return new OPERATOR();
    }

    /**
     * Create an instance of {@link DetailGroup.Detail }
     * 
     */
    public DetailGroup.Detail createDetailGroupDetail() {
        return new DetailGroup.Detail();
    }

    /**
     * Create an instance of {@link MatchFunction.Content }
     * 
     */
    public MatchFunction.Content createMatchFunctionContent() {
        return new MatchFunction.Content();
    }

    /**
     * Create an instance of {@link Fingerprint.Payload.Always }
     * 
     */
    public Fingerprint.Payload.Always createFingerprintPayloadAlways() {
        return new Fingerprint.Payload.Always();
    }

    /**
     * Create an instance of {@link Fingerprint.Filter.DsizeWithin }
     * 
     */
    public Fingerprint.Filter.DsizeWithin createFingerprintFilterDsizeWithin() {
        return new Fingerprint.Filter.DsizeWithin();
    }

    /**
     * Create an instance of {@link Fingerprint.Filter.TTLWithin }
     * 
     */
    public Fingerprint.Filter.TTLWithin createFingerprintFilterTTLWithin() {
        return new Fingerprint.Filter.TTLWithin();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Anchor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Anchor")
    public JAXBElement<Anchor> createAnchor(Anchor value) {
        return new JAXBElement<Anchor>(_Anchor_QNAME, Anchor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Return }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Return")
    public JAXBElement<Return> createReturn(Return value) {
        return new JAXBElement<Return>(_Return_QNAME, Return.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Window", scope = Fingerprint.Filter.class)
    public JAXBElement<BigInteger> createFingerprintFilterWindow(BigInteger value) {
        return new JAXBElement<BigInteger>(_FingerprintFilterWindow_QNAME, BigInteger.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SrcPort", scope = Fingerprint.Filter.class)
    public JAXBElement<Integer> createFingerprintFilterSrcPort(Integer value) {
        return new JAXBElement<Integer>(_FingerprintFilterSrcPort_QNAME, Integer.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ack", scope = Fingerprint.Filter.class)
    public JAXBElement<Long> createFingerprintFilterAck(Long value) {
        return new JAXBElement<Long>(_FingerprintFilterAck_QNAME, Long.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DstPort", scope = Fingerprint.Filter.class)
    public JAXBElement<Integer> createFingerprintFilterDstPort(Integer value) {
        return new JAXBElement<Integer>(_FingerprintFilterDstPort_QNAME, Integer.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Flags", scope = Fingerprint.Filter.class)
    public JAXBElement<String> createFingerprintFilterFlags(String value) {
        return new JAXBElement<String>(_FingerprintFilterFlags_QNAME, String.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MSS", scope = Fingerprint.Filter.class)
    public JAXBElement<BigInteger> createFingerprintFilterMSS(BigInteger value) {
        return new JAXBElement<BigInteger>(_FingerprintFilterMSS_QNAME, BigInteger.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TTL", scope = Fingerprint.Filter.class)
    public JAXBElement<BigInteger> createFingerprintFilterTTL(BigInteger value) {
        return new JAXBElement<BigInteger>(_FingerprintFilterTTL_QNAME, BigInteger.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Dsize", scope = Fingerprint.Filter.class)
    public JAXBElement<BigInteger> createFingerprintFilterDsize(BigInteger value) {
        return new JAXBElement<BigInteger>(_FingerprintFilterDsize_QNAME, BigInteger.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fingerprint.Filter.TTLWithin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TTLWithin", scope = Fingerprint.Filter.class)
    public JAXBElement<Fingerprint.Filter.TTLWithin> createFingerprintFilterTTLWithin(Fingerprint.Filter.TTLWithin value) {
        return new JAXBElement<Fingerprint.Filter.TTLWithin>(_FingerprintFilterTTLWithin_QNAME, Fingerprint.Filter.TTLWithin.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fingerprint.Filter.DsizeWithin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DsizeWithin", scope = Fingerprint.Filter.class)
    public JAXBElement<Fingerprint.Filter.DsizeWithin> createFingerprintFilterDsizeWithin(Fingerprint.Filter.DsizeWithin value) {
        return new JAXBElement<Fingerprint.Filter.DsizeWithin>(_FingerprintFilterDsizeWithin_QNAME, Fingerprint.Filter.DsizeWithin.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ethertype", scope = Fingerprint.Filter.class)
    public JAXBElement<Integer> createFingerprintFilterEthertype(Integer value) {
        return new JAXBElement<Integer>(_FingerprintFilterEthertype_QNAME, Integer.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TransportProtocol", scope = Fingerprint.Filter.class)
    public JAXBElement<Short> createFingerprintFilterTransportProtocol(Short value) {
        return new JAXBElement<Short>(_FingerprintFilterTransportProtocol_QNAME, Short.class, Fingerprint.Filter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Seq", scope = Fingerprint.Filter.class)
    public JAXBElement<Long> createFingerprintFilterSeq(Long value) {
        return new JAXBElement<Long>(_FingerprintFilterSeq_QNAME, Long.class, Fingerprint.Filter.class, value);
    }

}
