package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.dto.CartItemDto;
import com.trendyol.shoppingcart.model.dto.CategoryDto;
import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.service.DeliveryCostCalculatorService;
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
        int numberOfDeliveries = getNumberOfDeliveriesCategory(cart);
        int numberOfProducts = getNumberOfDeliveriesProducts(cart);

        return (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;
    }

    public Integer getNumberOfDeliveriesCategory(CartDto cart) {
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

    public Integer getNumberOfDeliveriesProducts(CartDto cart) {
        List<CartItemDto> cartItems = cart.getItems();
        Integer numberOfProduct = cartItems
                .stream()
                .map(CartItemDto::getProductDto)
                .collect(Collectors.toList())
                .size();

        return numberOfProduct;
    }
}