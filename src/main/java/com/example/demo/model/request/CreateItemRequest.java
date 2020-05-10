package com.example.demo.model.request;

import com.example.demo.model.dummy.CartItem;

import java.util.List;

public class CreateItemRequest {

    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
