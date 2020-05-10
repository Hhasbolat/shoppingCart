package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.model.dto.ProductCartItem;
import com.trendyol.shoppingcart.model.entity.Cart;
import com.trendyol.shoppingcart.model.entity.Category;
import com.trendyol.shoppingcart.model.entity.Product;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;
import com.trendyol.shoppingcart.service.CartService;
import com.trendyol.shoppingcart.service.DeliveryCostCalculatorService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class CartServiceTest {

    DeliveryCostCalculatorService deliveryCostCalculatorService;

    CartService cartService;



    @Test
    public void addProducts() {
        AddItemsRequest addItemRequest = new AddItemsRequest();
        List<ProductCartItem> productCartItem = new ArrayList<>();
        addItemRequest.setItems(productCartItem);
        Cart cart = new Cart();
        cart.setId(1L);
        addItemRequest.getItems();
        cartService.addProducts(1L, addItemRequest);
    }

    @Test
    public void sample_product_test(){
        HashMap<Product, BigDecimal> productsWithQuantity;
        productsWithQuantity = new HashMap<>();
        Product elma = new Product("elma", 10, new Category("food"));

        productsWithQuantity.put(elma, BigDecimal.valueOf(3));
        assertEquals(productsWithQuantity.get(elma), BigDecimal.valueOf(3));
    }

    @Test
    public void sample_category_test(){

    }


}