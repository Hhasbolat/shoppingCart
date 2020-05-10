package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;

public interface CartService {

    CartDto addProducts(Long cartId, AddItemsRequest addItemsRequest);

    CartDto getCart(Long id);

    Double calculateDeliveryCost(CartDto cartDto);
}
