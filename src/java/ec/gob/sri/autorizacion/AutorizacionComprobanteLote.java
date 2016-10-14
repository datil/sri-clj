
package ec.gob.sri.autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for autorizacionComprobanteLote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="autorizacionComprobanteLote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="claveAccesoLote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autorizacionComprobanteLote", propOrder = {
    "claveAccesoLote"
})
public class AutorizacionComprobanteLote {

    protected String claveAccesoLote;

    /**
     * Gets the value of the claveAccesoLote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveAccesoLote() {
        return claveAccesoLote;
    }

    /**
     * Sets the value of the claveAccesoLote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveAccesoLote(String value) {
        this.claveAccesoLote = value;
    }

}
