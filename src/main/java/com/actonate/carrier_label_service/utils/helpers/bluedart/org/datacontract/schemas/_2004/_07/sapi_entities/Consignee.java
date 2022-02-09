
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Consignee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Consignee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsigneeAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeAddress3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeAttention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneePincode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConsigneeTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Consignee", propOrder = {
    "consigneeAddress1",
    "consigneeAddress2",
    "consigneeAddress3",
    "consigneeAttention",
    "consigneeMobile",
    "consigneeName",
    "consigneePincode",
    "consigneeTelephone"
})
public class Consignee {

    @XmlElementRef(name = "ConsigneeAddress1", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAddress1;
    @XmlElementRef(name = "ConsigneeAddress2", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAddress2;
    @XmlElementRef(name = "ConsigneeAddress3", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAddress3;
    @XmlElementRef(name = "ConsigneeAttention", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAttention;
    @XmlElementRef(name = "ConsigneeMobile", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeMobile;
    @XmlElementRef(name = "ConsigneeName", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeName;
    @XmlElementRef(name = "ConsigneePincode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneePincode;
    @XmlElementRef(name = "ConsigneeTelephone", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> consigneeTelephone;

    /**
     * Gets the value of the consigneeAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAddress1() {
        return consigneeAddress1;
    }

    /**
     * Sets the value of the consigneeAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAddress1(JAXBElement<String> value) {
        this.consigneeAddress1 = value;
    }

    /**
     * Gets the value of the consigneeAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAddress2() {
        return consigneeAddress2;
    }

    /**
     * Sets the value of the consigneeAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAddress2(JAXBElement<String> value) {
        this.consigneeAddress2 = value;
    }

    /**
     * Gets the value of the consigneeAddress3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAddress3() {
        return consigneeAddress3;
    }

    /**
     * Sets the value of the consigneeAddress3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAddress3(JAXBElement<String> value) {
        this.consigneeAddress3 = value;
    }

    /**
     * Gets the value of the consigneeAttention property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAttention() {
        return consigneeAttention;
    }

    /**
     * Sets the value of the consigneeAttention property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAttention(JAXBElement<String> value) {
        this.consigneeAttention = value;
    }

    /**
     * Gets the value of the consigneeMobile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeMobile() {
        return consigneeMobile;
    }

    /**
     * Sets the value of the consigneeMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeMobile(JAXBElement<String> value) {
        this.consigneeMobile = value;
    }

    /**
     * Gets the value of the consigneeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeName() {
        return consigneeName;
    }

    /**
     * Sets the value of the consigneeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeName(JAXBElement<String> value) {
        this.consigneeName = value;
    }

    /**
     * Gets the value of the consigneePincode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneePincode() {
        return consigneePincode;
    }

    /**
     * Sets the value of the consigneePincode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneePincode(JAXBElement<String> value) {
        this.consigneePincode = value;
    }

    /**
     * Gets the value of the consigneeTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeTelephone() {
        return consigneeTelephone;
    }

    /**
     * Sets the value of the consigneeTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeTelephone(JAXBElement<String> value) {
        this.consigneeTelephone = value;
    }

}
