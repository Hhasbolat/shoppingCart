package com.example.demo.service.impl;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dummy.ProductCartItem;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import com.example.demo.model.request.AddItemsRequest;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.DeliveryCostCalculatorService;
import com.example.demo.service.ProductService;
import org.junit.Test;
import org.mockito.Mock;

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