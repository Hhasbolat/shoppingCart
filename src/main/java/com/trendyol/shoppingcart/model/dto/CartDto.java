package com.trendyol.shoppingcart.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartDto extends BaseDto{

    private Long id;

    private BigDecimal totalPrice;

    private BigDecimal couponDiscount;

    private BigDecimal campaignDiscount;

    private BigDecimal totalAmountAfterDiscounts;

    private BigDecimal deliveryCost;

    private BigDecimal totalAmount;

    private List<CartItemDto> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(BigDecimal couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(BigDecimal campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public BigDecimal getTotalAmountAfterDiscounts() {
        return totalAmountAfterDiscounts;
    }

    public void setTotalAmountAfterDiscounts(BigDecimal totalAmountAfterDiscounts) {
        this.totalAmountAfterDiscounts = totalAmountAfterDiscounts;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
}
