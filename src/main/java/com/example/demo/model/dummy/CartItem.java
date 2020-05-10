package com.example.demo.model.dummy;

import java.util.List;

public class CartItem {

    private List<ProductCartItem> productCartItems;

    public List<ProductCartItem> getProductCartItems() {
        return productCartItems;
    }

    public void setProductCartItems(List<ProductCartItem> productCartItems) {
        this.productCartItems = productCartItems;
    }
}
