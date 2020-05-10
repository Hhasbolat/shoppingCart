package com.trendyol.shoppingcart.service.mapper;

import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductEntityMapper implements EntityMapper<Product, ProductDto> {
    @Override
    public Product map(ProductDto source) {
        Product product = new Product();
        product.setId(source.getId());
        product.setPrice(source.getPrice());
        product.setTitle(source.getTitle());
        return product;
    }

    @Override
    public List<Product> map(List<ProductDto> source) {
        return source.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
