
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;

import com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities_enums.ProductType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



/**
 * <p>Java class for Services complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Services">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActualWeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CollectableAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Commodity" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}CommodityDetail" minOccurs="0"/>
 *         &lt;element name="CreditReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeclaredValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Dimensions" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}ArrayOfDimension" minOccurs="0"/>
 *         &lt;element name="InvoiceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PickupDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="PickupTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PieceCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.Enums.AWBGeneration}ProductType" minOccurs="0"/>
 *         &lt;element name="SpecialInstruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Services", propOrder = {
    "actualWeight",
    "collectableAmount",
    "commodity",
    "creditReferenceNo",
    "declaredValue",
    "dimensions",
    "invoiceNo",
    "packType",
    "pickupDate",
    "pickupTime",
    "pieceCount",
    "productCode",
    "productType",
    "specialInstruction",
    "subProductCode"
})
public class Services {

    @XmlElement(name = "ActualWeight")
    protected Double actualWeight;
    @XmlElement(name = "CollectableAmount")
    protected Double collectableAmount;
    @XmlElementRef(name = "Commodity", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<CommodityDetail> commodity;
    @XmlElementRef(name = "CreditReferenceNo", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> creditReferenceNo;
    @XmlElement(name = "DeclaredValue")
    protected Double declaredValue;
    @XmlElementRef(name = "Dimensions", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<ArrayOfDimension> dimensions;
    @XmlElementRef(name = "InvoiceNo", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> invoiceNo;
    @XmlElementRef(name = "PackType", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> packType;
    @XmlElement(name = "PickupDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pickupDate;
    @XmlElementRef(name = "PickupTime", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> pickupTime;
    @XmlElement(name = "PieceCount")
    protected Integer pieceCount;
    @XmlElementRef(name = "ProductCode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> productCode;
    @XmlElement(name = "ProductType")
    protected ProductType productType;
    @XmlElementRef(name = "SpecialInstruction", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> specialInstruction;
    @XmlElementRef(name = "SubProductCode", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration", type = JAXBElement.class)
    protected JAXBElement<String> subProductCode;

    /**
     * Gets the value of the actualWeight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActualWeight() {
        return actualWeight;
    }

    /**
     * Sets the value of the actualWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActualWeight(Double value) {
        this.actualWeight = value;
    }

    /**
     * Gets the value of the collectableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCollectableAmount() {
        return collectableAmount;
    }

    /**
     * Sets the value of the collectableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCollectableAmount(Double value) {
        this.collectableAmount = value;
    }

    /**
     * Gets the value of the commodity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CommodityDetail }{@code >}
     *     
     */
    public JAXBElement<CommodityDetail> getCommodity() {
        return commodity;
    }

    /**
     * Sets the value of the commodity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CommodityDetail }{@code >}
     *     
     */
    public void setCommodity(JAXBElement<CommodityDetail> value) {
        this.commodity = value;
    }

    /**
     * Gets the value of the creditReferenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditReferenceNo() {
        return creditReferenceNo;
    }

    /**
     * Sets the value of the creditReferenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditReferenceNo(JAXBElement<String> value) {
        this.creditReferenceNo = value;
    }

    /**
     * Gets the value of the declaredValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeclaredValue() {
        return declaredValue;
    }

    /**
     * Sets the value of the declaredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeclaredValue(Double value) {
        this.declaredValue = value;
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDimension }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDimension> getDimensions() {
        return dimensions;
    }

    /**
     * Sets the value of the dimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDimension }{@code >}
     *     
     */
    public void setDimensions(JAXBElement<ArrayOfDimension> value) {
        this.dimensions = value;
    }

    /**
     * Gets the value of the invoiceNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the value of the invoiceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvoiceNo(JAXBElement<String> value) {
        this.invoiceNo = value;
    }

    /**
     * Gets the value of the packType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackType() {
        return packType;
    }

    /**
     * Sets the value of the packType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackType(JAXBElement<String> value) {
        this.packType = value;
    }

    /**
     * Gets the value of the pickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPickupDate() {
        return pickupDate;
    }

    /**
     * Sets the value of the pickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPickupDate(XMLGregorianCalendar value) {
        this.pickupDate = value;
    }

    /**
     * Gets the value of the pickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPickupTime() {
        return pickupTime;
    }

    /**
     * Sets the value of the pickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPickupTime(JAXBElement<String> value) {
        this.pickupTime = value;
    }

    /**
     * Gets the value of the pieceCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPieceCount() {
        return pieceCount;
    }

    /**
     * Sets the value of the pieceCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPieceCount(Integer value) {
        this.pieceCount = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductCode(JAXBElement<String> value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductType }
     *     
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType }
     *     
     */
    public void setProductType(ProductType value) {
        this.productType = value;
    }

    /**
     * Gets the value of the specialInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecialInstruction() {
        return specialInstruction;
    }

    /**
     * Sets the value of the specialInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecialInstruction(JAXBElement<String> value) {
        this.specialInstruction = value;
    }

    /**
     * Gets the value of the subProductCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubProductCode() {
        return subProductCode;
    }

    /**
     * Sets the value of the subProductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubProductCode(JAXBElement<String> value) {
        this.subProductCode = value;
    }

}
