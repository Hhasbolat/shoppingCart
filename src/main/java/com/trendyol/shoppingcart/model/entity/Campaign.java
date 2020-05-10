package com.trendyol.shoppingcart.model.entity;

import com.trendyol.shoppingcart.model.enums.DiscountType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Campaign extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "PRODUCT_COUNT")
    private Integer minimumProductCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "DISCOUNT_TYPE")
    private DiscountType discountType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getMinimumProductCount() {
        return minimumProductCount;
    }

    public void setMinimumProductCount(Integer productCount) {
        this.minimumProductCount = productCount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
