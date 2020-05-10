package com.trendyol.shoppingcart.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "COUPON_DISCOUNT")
    private BigDecimal couponDiscount;

    @Column(name = "CAMPAIGN_DISCOUNT")
    private BigDecimal campaignDiscount;

    @Column(name = "TOTAL_AMOUNT_AFTER_DISCOUNTS")
    private BigDecimal totalAmountAfterDiscounts;

    @Column(name = "DELIVERY_COST")
    private BigDecimal deliveryCost;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> items;

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

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
