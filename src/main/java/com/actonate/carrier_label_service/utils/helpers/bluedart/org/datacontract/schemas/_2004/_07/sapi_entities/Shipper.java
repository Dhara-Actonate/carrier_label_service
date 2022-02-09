
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Shipper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Shipper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerAddress3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerEmailID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerPincode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsToPayCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OriginArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VendorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Shipper", propOrder = {
    "customerAddress1",
    "customerAddress2",
    "customerAddress3",
    "customerCode",
    "customerEmailID",
    "customerMobile",
    "customerName",
    "customerPincode",
    "customerTelephone",
    "isToPayCustomer",
    "originArea",
    "sender",
    "vendorCode"
})
public class Shipper {

    @XmlElementRef(name = "CustomerAddress1", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerAddress1;
    @XmlElementRef(name = "CustomerAddress2", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerAddress2;
    @XmlElementRef(name = "CustomerAddress3", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerAddress3;
    @XmlElementRef(name = "CustomerCode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerCode;
    @XmlElementRef(name = "CustomerEmailID", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerEmailID;
    @XmlElementRef(name = "CustomerMobile", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerMobile;
    @XmlElementRef(name = "CustomerName", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerName;
    @XmlElementRef(name = "CustomerPincode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerPincode;
    @XmlElementRef(name = "CustomerTelephone", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> customerTelephone;
    @XmlElement(name = "IsToPayCustomer")
    protected Boolean isToPayCustomer;
    @XmlElementRef(name = "OriginArea", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> originArea;
    @XmlElementRef(name = "Sender", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> sender;
    @XmlElementRef(name = "VendorCode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> vendorCode;

    /**
     * Gets the value of the customerAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerAddress1() {
        return customerAddress1;
    }

    /**
     * Sets the value of the customerAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerAddress1(JAXBElement<String> value) {
        this.customerAddress1 = value;
    }

    /**
     * Gets the value of the customerAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerAddress2() {
        return customerAddress2;
    }

    /**
     * Sets the value of the customerAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerAddress2(JAXBElement<String> value) {
        this.customerAddress2 = value;
    }

    /**
     * Gets the value of the customerAddress3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerAddress3() {
        return customerAddress3;
    }

    /**
     * Sets the value of the customerAddress3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerAddress3(JAXBElement<String> value) {
        this.customerAddress3 = value;
    }

    /**
     * Gets the value of the customerCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerCode() {
        return customerCode;
    }

    /**
     * Sets the value of the customerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerCode(JAXBElement<String> value) {
        this.customerCode = value;
    }

    /**
     * Gets the value of the customerEmailID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerEmailID() {
        return customerEmailID;
    }

    /**
     * Sets the value of the customerEmailID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerEmailID(JAXBElement<String> value) {
        this.customerEmailID = value;
    }

    /**
     * Gets the value of the customerMobile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerMobile() {
        return customerMobile;
    }

    /**
     * Sets the value of the customerMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerMobile(JAXBElement<String> value) {
        this.customerMobile = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerName(JAXBElement<String> value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the customerPincode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerPincode() {
        return customerPincode;
    }

    /**
     * Sets the value of the customerPincode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerPincode(JAXBElement<String> value) {
        this.customerPincode = value;
    }

    /**
     * Gets the value of the customerTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerTelephone() {
        return customerTelephone;
    }

    /**
     * Sets the value of the customerTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerTelephone(JAXBElement<String> value) {
        this.customerTelephone = value;
    }

    /**
     * Gets the value of the isToPayCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsToPayCustomer() {
        return isToPayCustomer;
    }

    /**
     * Sets the value of the isToPayCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsToPayCustomer(Boolean value) {
        this.isToPayCustomer = value;
    }

    /**
     * Gets the value of the originArea property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginArea() {
        return originArea;
    }

    /**
     * Sets the value of the originArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginArea(JAXBElement<String> value) {
        this.originArea = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSender(JAXBElement<String> value) {
        this.sender = value;
    }

    /**
     * Gets the value of the vendorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVendorCode() {
        return vendorCode;
    }

    /**
     * Sets the value of the vendorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVendorCode(JAXBElement<String> value) {
        this.vendorCode = value;
    }

}
