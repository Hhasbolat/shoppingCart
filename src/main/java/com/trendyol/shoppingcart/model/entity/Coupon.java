package com.trendyol.shoppingcart.model.entity;

import com.trendyol.shoppingcart.model.enums.DiscountType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Coupon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MINIMUM_PURCHASE_AMOUNT")
    private BigDecimal minimumPurchaseAmount;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    @Column(name = "DISCOUNT_TYPE")
    private DiscountType discountType;

    public Coupon() {
    }

    public Coupon(BigDecimal minimumPurchaseAmount, BigDecimal discount, DiscountType discountType) {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinimumPurchaseAmount() {
        return minimumPurchaseAmount;
    }

    public void setMinimumPurchaseAmount(BigDecimal minimumPurchaseAmount) {
        this.minimumPurchaseAmount = minimumPurchaseAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
