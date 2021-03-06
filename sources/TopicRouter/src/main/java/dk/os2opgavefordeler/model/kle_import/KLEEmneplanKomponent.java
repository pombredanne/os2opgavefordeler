//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.22 at 12:38:52 PM CEST 
//


package dk.os2opgavefordeler.model.kle_import;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for KLE-EmneplanKomponent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KLE-EmneplanKomponent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UdgivelsesDato" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element name="Hovedgruppe" type="{}HovedgruppeKomponent"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KLE-EmneplanKomponent", propOrder = {
    "udgivelsesDato",
    "hovedgruppe"
})
public class KLEEmneplanKomponent {

    @XmlElement(name = "UdgivelsesDato", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar udgivelsesDato;
    @XmlElement(name = "Hovedgruppe", required = true)
    protected List<HovedgruppeKomponent> hovedgruppe;

    /**
     * Gets the value of the udgivelsesDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUdgivelsesDato() {
        return udgivelsesDato;
    }

    /**
     * Sets the value of the udgivelsesDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUdgivelsesDato(XMLGregorianCalendar value) {
        this.udgivelsesDato = value;
    }

    /**
     * Gets the value of the hovedgruppe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hovedgruppe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHovedgruppe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HovedgruppeKomponent }
     * 
     * 
     */
    public List<HovedgruppeKomponent> getHovedgruppe() {
        if (hovedgruppe == null) {
            hovedgruppe = new ArrayList<HovedgruppeKomponent>();
        }
        return this.hovedgruppe;
    }

}
