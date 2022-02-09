
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WayBillGenerationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WayBillGenerationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AWBNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AWBPrintContent" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="CCRCRDREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsError" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}ArrayOfWayBillGenerationStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WayBillGenerationResponse", propOrder = {
    "awbNo",
    "awbPrintContent",
    "ccrcrdref",
    "destinationArea",
    "destinationLocation",
    "isError",
    "status"
})
public class WayBillGenerationResponse {

    @XmlElementRef(name = "AWBNo", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> awbNo;
    @XmlElementRef(name = "AWBPrintContent", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<byte[]> awbPrintContent;
    @XmlElementRef(name = "CCRCRDREF", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> ccrcrdref;
    @XmlElementRef(name = "DestinationArea", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> destinationArea;
    @XmlElementRef(name = "DestinationLocation", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> destinationLocation;
    @XmlElement(name = "IsError")
    protected Boolean isError;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<ArrayOfWayBillGenerationStatus> status;

    /**
     * Gets the value of the awbNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAWBNo() {
        return awbNo;
    }

    /**
     * Sets the value of the awbNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAWBNo(JAXBElement<String> value) {
        this.awbNo = value;
    }

    /**
     * Gets the value of the awbPrintContent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getAWBPrintContent() {
        return awbPrintContent;
    }

    /**
     * Sets the value of the awbPrintContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setAWBPrintContent(JAXBElement<byte[]> value) {
        this.awbPrintContent = value;
    }

    /**
     * Gets the value of the ccrcrdref property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCCRCRDREF() {
        return ccrcrdref;
    }

    /**
     * Sets the value of the ccrcrdref property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCCRCRDREF(JAXBElement<String> value) {
        this.ccrcrdref = value;
    }

    /**
     * Gets the value of the destinationArea property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestinationArea() {
        return destinationArea;
    }

    /**
     * Sets the value of the destinationArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestinationArea(JAXBElement<String> value) {
        this.destinationArea = value;
    }

    /**
     * Gets the value of the destinationLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * Sets the value of the destinationLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDestinationLocation(JAXBElement<String> value) {
        this.destinationLocation = value;
    }

    /**
     * Gets the value of the isError property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsError() {
        return isError;
    }

    /**
     * Sets the value of the isError property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsError(Boolean value) {
        this.isError = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWayBillGenerationStatus }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWayBillGenerationStatus> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWayBillGenerationStatus }{@code >}
     *     
     */
    public void setStatus(JAXBElement<ArrayOfWayBillGenerationStatus> value) {
        this.status = value;
    }

}
