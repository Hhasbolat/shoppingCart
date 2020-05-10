package com.example.demo.service;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.request.AddItemsRequest;

public interface CartService {

    CartDto addProducts(Long cartId, AddItemsRequest addItemsRequest);

   // Double getDeliveryCost(CartDto cartDto);
}
