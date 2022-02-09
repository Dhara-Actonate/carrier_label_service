
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Api_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Area" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customercode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsAdmin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LicenceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserProfile", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", propOrder = {
    "apiType",
    "area",
    "customercode",
    "isAdmin",
    "licenceKey",
    "loginID",
    "password",
    "version"
})
public class UserProfile {

    @XmlElementRef(name = "Api_type", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> apiType;
    @XmlElementRef(name = "Area", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> area;
    @XmlElementRef(name = "Customercode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> customercode;
    @XmlElementRef(name = "IsAdmin", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> isAdmin;
    @XmlElementRef(name = "LicenceKey", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> licenceKey;
    @XmlElementRef(name = "LoginID", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> loginID;
    @XmlElementRef(name = "Password", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "Version", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Admin", type = JAXBElement.class)
    protected JAXBElement<String> version;

    /**
     * Gets the value of the apiType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApiType() {
        return apiType;
    }

    /**
     * Sets the value of the apiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApiType(JAXBElement<String> value) {
        this.apiType = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setArea(JAXBElement<String> value) {
        this.area = value;
    }

    /**
     * Gets the value of the customercode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomercode() {
        return customercode;
    }

    /**
     * Sets the value of the customercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomercode(JAXBElement<String> value) {
        this.customercode = value;
    }

    /**
     * Gets the value of the isAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets the value of the isAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsAdmin(JAXBElement<String> value) {
        this.isAdmin = value;
    }

    /**
     * Gets the value of the licenceKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLicenceKey() {
        return licenceKey;
    }

    /**
     * Sets the value of the licenceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLicenceKey(JAXBElement<String> value) {
        this.licenceKey = value;
    }

    /**
     * Gets the value of the loginID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoginID() {
        return loginID;
    }

    /**
     * Sets the value of the loginID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoginID(JAXBElement<String> value) {
        this.loginID = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassword(JAXBElement<String> value) {
        this.password = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersion(JAXBElement<String> value) {
        this.version = value;
    }

}
