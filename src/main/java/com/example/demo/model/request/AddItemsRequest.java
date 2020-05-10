package com.example.demo.model.request;

import com.example.demo.model.dummy.CartItem;
import com.example.demo.model.dummy.ProductCartItem;

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
