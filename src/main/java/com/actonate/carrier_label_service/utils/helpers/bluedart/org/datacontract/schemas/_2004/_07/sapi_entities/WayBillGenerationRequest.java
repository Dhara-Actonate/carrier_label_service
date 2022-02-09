
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WayBillGenerationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WayBillGenerationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Consignee" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}Consignee" minOccurs="0"/>
 *         &lt;element name="Services" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}Services" minOccurs="0"/>
 *         &lt;element name="Shipper" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}Shipper" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WayBillGenerationRequest", propOrder = {
    "consignee",
    "services",
    "shipper"
})
public class WayBillGenerationRequest {

    @XmlElementRef(name = "Consignee", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<Consignee> consignee;
    @XmlElementRef(name = "Services", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<Services> services;
    @XmlElementRef(name = "Shipper", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<Shipper> shipper;

    /**
     * Gets the value of the consignee property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Consignee }{@code >}
     *     
     */
    public JAXBElement<Consignee> getConsignee() {
        return consignee;
    }

    /**
     * Sets the value of the consignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Consignee }{@code >}
     *     
     */
    public void setConsignee(JAXBElement<Consignee> value) {
        this.consignee = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Services }{@code >}
     *     
     */
    public JAXBElement<Services> getServices() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Services }{@code >}
     *     
     */
    public void setServices(JAXBElement<Services> value) {
        this.services = value;
    }

    /**
     * Gets the value of the shipper property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Shipper }{@code >}
     *     
     */
    public JAXBElement<Shipper> getShipper() {
        return shipper;
    }

    /**
     * Sets the value of the shipper property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Shipper }{@code >}
     *     
     */
    public void setShipper(JAXBElement<Shipper> value) {
        this.shipper = value;
    }

}
