
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
 *         &lt;element name="GetAvailGroupsResult" type="{http://msiggi.de/Sportsdata/Webservices}ArrayOfGroup" minOccurs="0"/>
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
    "getAvailGroupsResult"
})
@XmlRootElement(name = "GetAvailGroupsResponse")
public class GetAvailGroupsResponse {

    @XmlElement(name = "GetAvailGroupsResult")
    protected ArrayOfGroup getAvailGroupsResult;

    /**
     * Gets the value of the getAvailGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGroup }
     *     
     */
    public ArrayOfGroup getGetAvailGroupsResult() {
        return getAvailGroupsResult;
    }

    /**
     * Sets the value of the getAvailGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGroup }
     *     
     */
    public void setGetAvailGroupsResult(ArrayOfGroup value) {
        this.getAvailGroupsResult = value;
    }

}
