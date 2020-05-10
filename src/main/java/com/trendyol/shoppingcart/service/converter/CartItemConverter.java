package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.CartItemDto;
import com.trendyol.shoppingcart.model.dto.CategoryDto;
import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.entity.CartItem;
import com.trendyol.shoppingcart.model.entity.Category;
import com.trendyol.shoppingcart.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CartItemConverter implements DtoConverter<CartItemDto, CartItem> {
    @Override
    public CartItemDto convert(CartItem source) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(source.getId());
        cartItemDto.setProductDto(create(source.getProduct()));
        cartItemDto.setQuantity(source.getQuantity());
        return cartItemDto;
    }

    @Override
    public List<CartItemDto> convert(List<CartItem> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public ProductDto create(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setTitle(product.getTitle());
        productDto.setCategoryDto(create(product.getCategory()));
        return productDto;
    }

    public CategoryDto create(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        return categoryDto;
    }
}
