package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.entity.Cart;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;

public class CartMockDataBuilder {

    public CartMockDataBuilder() {
    }

    public static AddItemsRequest generateCartRequest() {
        return GenericMockDataBuilder.of(AddItemsRequest.class).build();
    }

    public static CartDto generateCartDto(){
        return GenericMockDataBuilder.of(CartDto.class).build();
    }

    public static Cart generateCart(){
        return GenericMockDataBuilder.of(Cart.class).build();
    }
}
