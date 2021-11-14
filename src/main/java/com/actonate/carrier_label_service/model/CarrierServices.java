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
@Table(name = "carrier_services")
public class CarrierServices {
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

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "carrier_id")
    private String carrierId;

    @Column(name = "order_cutoff")
    private String orderCutoff;

    @Column(name = "dispatch_time")
    private Date dispatchTime;

    @Column(name = "max_weight")
    private int maxWeight;

    @Column(name = "min_weight")
    private int minWeight;

    @Column(name = "min_turnaround_time")
    private int minTurnaroundTime;

    @Column(name = "max_turnaround_time")
    private int maxTurnaroundTime;

    @Column(name = "shipping_type")
    private String shippingType;

}