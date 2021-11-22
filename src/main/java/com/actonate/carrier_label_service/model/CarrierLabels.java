package com.actonate.carrier_label_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carrier_labels")
public class CarrierLabels {

    /**
     * Primary key id.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "shipment_tracking_code")
    private String shipmentTrackingCode;

    @Column(name = "airway_bill_code")
    private String airwayBillCode;

    @Column(name = "carrier_id")
    private String carrierId;

    @Column(name = "carrier_service_id")
    private String carrierServiceId;

    @Column(name = "order_tracking_code")
    private String orderTrackingCode;

    @Column(name = "shipment_tracking_url")
    private String shipmentTrackingUrl;

    @Column(name = "shipment_id")
    private String shipmentId;

    @Column(name = "label_generate_response_raw")
    private String labelGenerateResponseRaw;

    @Column(name = "tracking_response_raw")
    private String trackingResponseRaw;

    @Column(name = "label_generated_at")
    private Date labelGeneratedAt;

    @Column(name = "label_generate_status")
    private String labelGenerateStatus;

    @Column(name = "tracking_status_log")
    private String trackingStatusLog;

    @Column(name = "tracking_staus")
    private String trackingStaus;

    @Column(name = "label_download_url")
    private String labelDownloadUrl;

}
