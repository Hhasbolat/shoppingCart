package com.trendyol.shoppingcart.model.dto;

import com.trendyol.shoppingcart.model.enums.DiscountType;

import java.math.BigDecimal;

public class CampaignDto extends BaseDto {
    private Long id;

    private CategoryDto category;

    private Integer minimumProductCount;

    private BigDecimal discount;

    private DiscountType discountType;


    public CampaignDto() {
    }

    public CampaignDto(Long id, CategoryDto category, Integer minimumProductCount,
                       BigDecimal discount, DiscountType discountType) {
        this.id = id;
        this.category = category;
        this.minimumProductCount = minimumProductCount;
        this.discount = discount;
        this.discountType = discountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Integer getMinimumProductCount() {
        return minimumProductCount;
    }

    public void setMinimumProductCount(Integer minimumProductCount) {
        this.minimumProductCount = minimumProductCount;
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
