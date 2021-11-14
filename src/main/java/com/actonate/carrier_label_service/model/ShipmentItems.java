package com.actonate.carrier_label_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipment_items")
public class ShipmentItems {
    /**
     * Primary key id.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String tenantId;

    private String skuCode;

    private String shipmentId;

    private String orderId;

    private Integer quantity;

    private String skuUnitCode;

    private String skuUnitGroupCode;

    private Integer unitWeight;

    private Integer totalWeight;

    private Integer totalPackagedWeight;

    private Boolean isHazardous;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Boolean isDeleted;
}