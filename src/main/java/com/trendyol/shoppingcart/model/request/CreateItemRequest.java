package com.trendyol.shoppingcart.model.request;

import com.trendyol.shoppingcart.model.dummy.CartItem;

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
