package com.example.demo.service.impl;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.service.DeliveryCostCalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryCostCalculatorServiceImpl implements DeliveryCostCalculatorService {


    public DeliveryCostCalculatorServiceImpl() {
    }

    @Override
    public Double calculateFor(CartDto cart) {
        Double fixedCost = 2.99;
        Double costPerDelivery = 5.0;
        Double costPerProduct = 2.0;
        if (cart == null) {
            throw new IllegalArgumentException();
        }
        int numberOfDeliveries = getNumberOfDeliveries(cart);
        int numberOfProducts = getNumberOfProducts(cart);

        return (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;
    }

    public Integer getNumberOfDeliveries(CartDto cart) {
        List<CartItemDto> cartItems = cart.getItems();
        Integer numberOfCategory = cartItems
                .stream()
                .map(CartItemDto::getProductDto)
                .map(ProductDto::getCategoryDto)
                .map(CategoryDto::getId)
                .distinct()
                .collect(Collectors.toList())
                .size();

        return numberOfCategory;
    }

    public Integer getNumberOfProducts(CartDto cart) {
        List<CartItemDto> cartItems = cart.getItems();
        Integer numberOfProduct = cartItems
                .stream()
                .map(CartItemDto::getProductDto)
                .collect(Collectors.toList())
                .size();

        return numberOfProduct;
    }
}