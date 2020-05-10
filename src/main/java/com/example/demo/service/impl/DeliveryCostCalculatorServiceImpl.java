package com.example.demo.service.impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.service.DeliveryCostCalculatorService;

import java.util.List;
import java.util.stream.Collectors;


public class DeliveryCostCalculatorServiceImpl implements DeliveryCostCalculatorService {

    private final Double fixedCost;
    private final Double costPerDelivery;
    private final Double costPerProduct;


    public DeliveryCostCalculatorServiceImpl(Double fixedCost, Double costPerDelivery, Double costPerProduct) {
        this.fixedCost = fixedCost;
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
    }

   /* @Override
    public Double calculateFor(CartDto cart) {
        if (cart == null) {
            throw new IllegalArgumentException();
        }
        int numberOfDeliveries = getNumberOfDeliveries(cart);
        int numberOfProducts = getNumberOfProducts(cart);
        return (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;
    }
*/
    public Integer getNumberOfDeliveries(CartDto cart) {
        List<CartItemDto> cartItems = cart.getItems();
        Integer numberOfCategory = cartItems.stream()
                .map(CartItemDto::getProductDto).map(ProductDto::getCategoryDto).map(
                        CategoryDto::getId).distinct()
                .collect(Collectors.toList()).size();

        return numberOfCategory;
    }

    public Integer getNumberOfProducts(CartDto cart) {
        List<CartItemDto> cartItems = cart.getItems();
        Integer numberOfProduct = cartItems.stream()
                .map(CartItemDto::getProductDto)
                .collect(Collectors.toList()).size();

        return numberOfProduct;
    }
}