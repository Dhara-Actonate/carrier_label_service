
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfWayBillGenerationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfWayBillGenerationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WayBillGenerationResponse" type="{http://schemas.datacontract.org/2004/07/SAPI.Entities.WayBillGeneration}WayBillGenerationResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfWayBillGenerationResponse", propOrder = {
    "wayBillGenerationResponse"
})
public class ArrayOfWayBillGenerationResponse {

    @XmlElement(name = "WayBillGenerationResponse", nillable = true)
    protected List<WayBillGenerationResponse> wayBillGenerationResponse;

    /**
     * Gets the value of the wayBillGenerationResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wayBillGenerationResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWayBillGenerationResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WayBillGenerationResponse }
     * 
     * 
     */
    public List<WayBillGenerationResponse> getWayBillGenerationResponse() {
        if (wayBillGenerationResponse == null) {
            wayBillGenerationResponse = new ArrayList<WayBillGenerationResponse>();
        }
        return this.wayBillGenerationResponse;
    }

}
