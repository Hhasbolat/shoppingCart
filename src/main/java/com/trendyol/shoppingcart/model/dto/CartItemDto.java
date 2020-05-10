package com.trendyol.shoppingcart.model.dto;

public class CartItemDto extends BaseDto {

    private Long id;

    private ProductDto productDto;

    private Integer quantity;

    public CartItemDto() {
    }

    public CartItemDto(Long id, ProductDto productDto, Integer quantity) {
        this.id = id;
        this.productDto = productDto;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
