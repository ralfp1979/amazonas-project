
package de.msiggi.sportsdata.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAvailSportsResult" type="{http://msiggi.de/Sportsdata/Webservices}ArrayOfSport" minOccurs="0"/>
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
    "getAvailSportsResult"
})
@XmlRootElement(name = "GetAvailSportsResponse")
public class GetAvailSportsResponse {

    @XmlElement(name = "GetAvailSportsResult")
    protected ArrayOfSport getAvailSportsResult;

    /**
     * Gets the value of the getAvailSportsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSport }
     *     
     */
    public ArrayOfSport getGetAvailSportsResult() {
        return getAvailSportsResult;
    }

    /**
     * Sets the value of the getAvailSportsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSport }
     *     
     */
    public void setGetAvailSportsResult(ArrayOfSport value) {
        this.getAvailSportsResult = value;
    }

}
