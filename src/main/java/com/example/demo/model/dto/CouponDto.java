package com.example.demo.model.dto;

import com.example.demo.model.enums.DiscountType;

import java.math.BigDecimal;

public class CouponDto extends BaseDto {

    private Long id;

    private BigDecimal minimumPurchaseAmount;

    private BigDecimal discount;

    private DiscountType discountType;

    public CouponDto() {
    }

    public CouponDto(Long id, BigDecimal minimumPurchaseAmount, BigDecimal discount, DiscountType discountType) {
        this.id = id;
        this.minimumPurchaseAmount = minimumPurchaseAmount;
        this.discount = discount;
        this.discountType = discountType;
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
