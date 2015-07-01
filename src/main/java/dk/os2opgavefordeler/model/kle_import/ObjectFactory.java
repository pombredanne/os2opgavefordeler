//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.22 at 12:38:52 PM CEST 
//


package dk.os2opgavefordeler.model.kle_import;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.os2opgavefordeler.model.kle_import package. 
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

    private final static QName _GruppeNr_QNAME = new QName("", "GruppeNr");
    private final static QName _EmneNr_QNAME = new QName("", "EmneNr");
    private final static QName _KLEEmneplan_QNAME = new QName("", "KLE-Emneplan");
    private final static QName _HovedgruppeNr_QNAME = new QName("", "HovedgruppeNr");
    private final static QName _HandlingsfacetNr_QNAME = new QName("", "HandlingsfacetNr");
    private final static QName _BevaringJaevnfoerArkivloven_QNAME = new QName("", "BevaringJaevnfoerArkivloven");
    private final static QName _VejledningKomponentVejledningTekstPB_QNAME = new QName("", "b");
    private final static QName _VejledningKomponentVejledningTekstPUl_QNAME = new QName("", "ul");
    private final static QName _VejledningKomponentVejledningTekstPI_QNAME = new QName("", "i");
    private final static QName _VejledningKomponentVejledningTekstPOl_QNAME = new QName("", "ol");
    private final static QName _RetskildeReferenceKomponentRetsinfoAccessionsNr_QNAME = new QName("", "RetsinfoAccessionsNr");
    private final static QName _RetskildeReferenceKomponentParagrafEllerKapitel_QNAME = new QName("", "ParagrafEllerKapitel");
    private final static QName _RetskildeReferenceKomponentRetskildeTitel_QNAME = new QName("", "RetskildeTitel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.os2opgavefordeler.model.kle_import
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KLEAdministrativInfoKomponent }
     * 
     */
    public KLEAdministrativInfoKomponent createKLEAdministrativInfoKomponent() {
        return new KLEAdministrativInfoKomponent();
    }

    /**
     * Create an instance of {@link KLEAdministrativInfoKomponent.Historisk }
     * 
     */
    public KLEAdministrativInfoKomponent.Historisk createKLEAdministrativInfoKomponentHistorisk() {
        return new KLEAdministrativInfoKomponent.Historisk();
    }

    /**
     * Create an instance of {@link KLEAdministrativInfoKomponent.Historisk.Flyttet }
     * 
     */
    public KLEAdministrativInfoKomponent.Historisk.Flyttet createKLEAdministrativInfoKomponentHistoriskFlyttet() {
        return new KLEAdministrativInfoKomponent.Historisk.Flyttet();
    }

    /**
     * Create an instance of {@link VejledningKomponent }
     * 
     */
    public VejledningKomponent createVejledningKomponent() {
        return new VejledningKomponent();
    }

    /**
     * Create an instance of {@link VejledningKomponent.VejledningTekst }
     * 
     */
    public VejledningKomponent.VejledningTekst createVejledningKomponentVejledningTekst() {
        return new VejledningKomponent.VejledningTekst();
    }

    /**
     * Create an instance of {@link VejledningKomponent.VejledningTekst.P }
     * 
     */
    public VejledningKomponent.VejledningTekst.P createVejledningKomponentVejledningTekstP() {
        return new VejledningKomponent.VejledningTekst.P();
    }

    /**
     * Create an instance of {@link KLEEmneplanKomponent }
     * 
     */
    public KLEEmneplanKomponent createKLEEmneplanKomponent() {
        return new KLEEmneplanKomponent();
    }

    /**
     * Create an instance of {@link EmneKomponent }
     * 
     */
    public EmneKomponent createEmneKomponent() {
        return new EmneKomponent();
    }

    /**
     * Create an instance of {@link HovedgruppeKomponent }
     * 
     */
    public HovedgruppeKomponent createHovedgruppeKomponent() {
        return new HovedgruppeKomponent();
    }

    /**
     * Create an instance of {@link RetskildeReferenceKomponent }
     * 
     */
    public RetskildeReferenceKomponent createRetskildeReferenceKomponent() {
        return new RetskildeReferenceKomponent();
    }

    /**
     * Create an instance of {@link FilterKomponent }
     * 
     */
    public FilterKomponent createFilterKomponent() {
        return new FilterKomponent();
    }

    /**
     * Create an instance of {@link GruppeKomponent }
     * 
     */
    public GruppeKomponent createGruppeKomponent() {
        return new GruppeKomponent();
    }

    /**
     * Create an instance of {@link KLEAdministrativInfoKomponent.Historisk.Flyttet.AfloestAf }
     * 
     */
    public KLEAdministrativInfoKomponent.Historisk.Flyttet.AfloestAf createKLEAdministrativInfoKomponentHistoriskFlyttetAfloestAf() {
        return new KLEAdministrativInfoKomponent.Historisk.Flyttet.AfloestAf();
    }

    /**
     * Create an instance of {@link VejledningKomponent.VejledningTekst.P.Ul }
     * 
     */
    public VejledningKomponent.VejledningTekst.P.Ul createVejledningKomponentVejledningTekstPUl() {
        return new VejledningKomponent.VejledningTekst.P.Ul();
    }

    /**
     * Create an instance of {@link VejledningKomponent.VejledningTekst.P.Ol }
     * 
     */
    public VejledningKomponent.VejledningTekst.P.Ol createVejledningKomponentVejledningTekstPOl() {
        return new VejledningKomponent.VejledningTekst.P.Ol();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GruppeNr")
    public JAXBElement<String> createGruppeNr(String value) {
        return new JAXBElement<String>(_GruppeNr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EmneNr")
    public JAXBElement<String> createEmneNr(String value) {
        return new JAXBElement<String>(_EmneNr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KLEEmneplanKomponent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "KLE-Emneplan")
    public JAXBElement<KLEEmneplanKomponent> createKLEEmneplan(KLEEmneplanKomponent value) {
        return new JAXBElement<KLEEmneplanKomponent>(_KLEEmneplan_QNAME, KLEEmneplanKomponent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HovedgruppeNr")
    public JAXBElement<String> createHovedgruppeNr(String value) {
        return new JAXBElement<String>(_HovedgruppeNr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HandlingsfacetNr")
    public JAXBElement<String> createHandlingsfacetNr(String value) {
        return new JAXBElement<String>(_HandlingsfacetNr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BevaringJaevnfoerArkivloven")
    public JAXBElement<String> createBevaringJaevnfoerArkivloven(String value) {
        return new JAXBElement<String>(_BevaringJaevnfoerArkivloven_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "b", scope = VejledningKomponent.VejledningTekst.P.class)
    public JAXBElement<Object> createVejledningKomponentVejledningTekstPB(Object value) {
        return new JAXBElement<Object>(_VejledningKomponentVejledningTekstPB_QNAME, Object.class, VejledningKomponent.VejledningTekst.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VejledningKomponent.VejledningTekst.P.Ul }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ul", scope = VejledningKomponent.VejledningTekst.P.class)
    public JAXBElement<VejledningKomponent.VejledningTekst.P.Ul> createVejledningKomponentVejledningTekstPUl(VejledningKomponent.VejledningTekst.P.Ul value) {
        return new JAXBElement<VejledningKomponent.VejledningTekst.P.Ul>(_VejledningKomponentVejledningTekstPUl_QNAME, VejledningKomponent.VejledningTekst.P.Ul.class, VejledningKomponent.VejledningTekst.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "i", scope = VejledningKomponent.VejledningTekst.P.class)
    public JAXBElement<Object> createVejledningKomponentVejledningTekstPI(Object value) {
        return new JAXBElement<Object>(_VejledningKomponentVejledningTekstPI_QNAME, Object.class, VejledningKomponent.VejledningTekst.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VejledningKomponent.VejledningTekst.P.Ol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ol", scope = VejledningKomponent.VejledningTekst.P.class)
    public JAXBElement<VejledningKomponent.VejledningTekst.P.Ol> createVejledningKomponentVejledningTekstPOl(VejledningKomponent.VejledningTekst.P.Ol value) {
        return new JAXBElement<VejledningKomponent.VejledningTekst.P.Ol>(_VejledningKomponentVejledningTekstPOl_QNAME, VejledningKomponent.VejledningTekst.P.Ol.class, VejledningKomponent.VejledningTekst.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RetsinfoAccessionsNr", scope = RetskildeReferenceKomponent.class)
    public JAXBElement<String> createRetskildeReferenceKomponentRetsinfoAccessionsNr(String value) {
        return new JAXBElement<String>(_RetskildeReferenceKomponentRetsinfoAccessionsNr_QNAME, String.class, RetskildeReferenceKomponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ParagrafEllerKapitel", scope = RetskildeReferenceKomponent.class)
    public JAXBElement<String> createRetskildeReferenceKomponentParagrafEllerKapitel(String value) {
        return new JAXBElement<String>(_RetskildeReferenceKomponentParagrafEllerKapitel_QNAME, String.class, RetskildeReferenceKomponent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RetskildeTitel", scope = RetskildeReferenceKomponent.class)
    public JAXBElement<String> createRetskildeReferenceKomponentRetskildeTitel(String value) {
        return new JAXBElement<String>(_RetskildeReferenceKomponentRetskildeTitel_QNAME, String.class, RetskildeReferenceKomponent.class, value);
    }

}
