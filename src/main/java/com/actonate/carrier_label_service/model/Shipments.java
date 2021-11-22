package com.actonate.carrier_label_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipments")
public class Shipments {
    /**
     * Primary key id.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String tenantId;

    private String warehouseId;

    private Integer status;

    private String orderId;

    private String shipmentType;

    private String carrierId;

    private String carrierServiceId;

    private Date dispatchDate;

    private Date deliveryDate;

    private String invoiceNo;

    private String trackingCode;

    private String awbNo;

    private String returnManifestUrl;

    private String invoiceUrl;

    private String trackingLabelUrl;

    private String trackingUrl;

    private Integer totalWeight;

    private Integer totalVolume;

    private String shippingRatecardId;

    private String shippingRateId;

    private String shippingZoneId;

    private Boolean isGiftWrapped;

    private String giftMessage;

    private Boolean isFragile;

    private Boolean isHazardous;

    private Integer dimensionHeight;

    private Integer dimensionWidth;

    private Integer dimensionLength;

    private Integer priority;

    private String tags;

    private Boolean isReturnRequested;

    private String returnReason;

    private String returnShipmentId;

    private String returnAction;

    private Boolean isTrackingLabelPrinted;

    private Boolean isInvoicePrinted;

    private String manifestId;

    private String carrierLabelId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shipmentId")
//    private List<CarrierLabels> labels;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipmentId")
    private List<ShipmentItems> shipmentItems;

//    @Column(name = "is_deleted")
    private boolean isDeleted;

//    @Column(name = "deleted_at")
    private Date deletedAt;

//    @Column(name = "created_at")
    private Date createdAt;

//    @Column(name = "updated_at")
    private Date updatedAt;

//    @Column(name = "deleted_by")
    private String deletedBy;

//    @Column(name = "created_by")
    private String createdBy;

//    @Column(name = "updated_by")
    private String updatedBy;
}