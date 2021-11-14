package com.actonate.carrier_label_service.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Table(name = "orders")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    /**
     * Primary key id.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String code;

//  x  private String userId;

    private Integer orderIndexNumber;

    private String paymentMode;

    private String paymentGateway;

    private String deliveryAddressId;

    private String transactionId;

    private BigDecimal additionalCharges;

    private BigDecimal subTotal;

    private BigDecimal shippingCharges;

    private String remarks;

    private String orderPlacedAt;

    private String paymentType;

    private String billingAddressId;

    private BigDecimal grandTotal;

    private BigDecimal discountTotal;

    private String couponId;

    private BigDecimal taxTotal;

    private String shippingRemarks;

    private String internalRemarks;

    private Integer rating;

    private String feedback;

    private String referredById;

    private BigDecimal awardedLoyaltyPoints;

    private String dispatchStatus;

    private String currencyId;

    private String channel;

    private Boolean isOnline;

    private String courierId;

    private BigDecimal walletAmount;

    private String type;

    private BigDecimal paidAmount;

    private String deliveryDate;

    private String deliverySlot;

    private String orderNote;

    private BigDecimal cashback;

    private String deliverySlotId;

    private BigDecimal refererCashback;

    private String promotionId;

    private String universalRemarks;

    private Boolean isOrderProcessed;

    private BigDecimal loyaltyTotal;

    private String userMobile;

    private String channelOrder;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    private Boolean isDeleted;

    private Integer status;

    private Integer paymentStatus;

    private String currencyCode;

    private String tags;

    private Boolean isLegacy;

    private Integer isExpress;

    private String autoDispatchType;

    private BigDecimal couponDiscount;

    private BigDecimal loyaltyDiscount;

    private String paidAt;

    private BigDecimal totalVatTax;

    private String subscriptionId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "orderId")
//    private List<OrderItems> orderItems;

}