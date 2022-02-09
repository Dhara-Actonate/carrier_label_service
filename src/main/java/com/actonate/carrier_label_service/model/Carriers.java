package com.actonate.carrier_label_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carriers")
public class Carriers {
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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "label_generation")
    private String labelGeneration;  // AUTO / MANUAL

    @Column(name = "tracking")
    private String tracking; // AUTO / MANUAL

    @Column(name = "label_generation_api_provider")
    private String labelGenerationApiProvider;

    @Column(name = "tracking_api_provider")
    private String trackingApiProvider;

    @JsonIgnoreProperties("carriers")
    @OneToMany(mappedBy = "carriers")
    private List<CarrierServices> carrierServices = new ArrayList<>();

}