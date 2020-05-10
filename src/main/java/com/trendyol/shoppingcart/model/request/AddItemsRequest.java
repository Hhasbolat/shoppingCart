package com.trendyol.shoppingcart.model.request;

import com.trendyol.shoppingcart.model.dummy.ProductCartItem;

import java.util.List;

public class AddItemsRequest {

    private List<ProductCartItem> items;

    public List<ProductCartItem> getItems() {
        return items;
    }

    public void setItems(List<ProductCartItem> items) {
        this.items = items;
    }
}
