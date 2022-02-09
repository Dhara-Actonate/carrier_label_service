
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities_enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Docs"/>
 *     &lt;enumeration value="Dutiables"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProductType", namespace = "http://schemas.datacontract.org/2004/07/SAPI.Entities.Enums.AWBGeneration")
@XmlEnum
public enum ProductType {

    @XmlEnumValue("Docs")
    DOCS("Docs"),
    @XmlEnumValue("Dutiables")
    DUTIABLES("Dutiables");
    private final String value;

    ProductType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductType fromValue(String v) {
        for (ProductType c: ProductType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
