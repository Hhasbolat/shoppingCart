package com.trendyol.shoppingcart.model.dto;

import java.util.List;

public class CartItemRequestDto {

    private Long id;

    private List<ProductCartItem> productCartItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductCartItem> getProductCartItems() {
        return productCartItems;
    }

    public void setProductCartItems(List<ProductCartItem> productCartItems) {
        this.productCartItems = productCartItems;
    }
}
