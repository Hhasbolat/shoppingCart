package com.trendyol.shoppingcart.model.dto;

import java.math.BigDecimal;

public class ProductDto extends BaseDto{

    private Long id;
    private String title;
    private BigDecimal price;
    private CategoryDto categoryDto;

    public ProductDto() {
    }

    public ProductDto(Long id, String title, BigDecimal price, CategoryDto categoryDto) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryDto = categoryDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
