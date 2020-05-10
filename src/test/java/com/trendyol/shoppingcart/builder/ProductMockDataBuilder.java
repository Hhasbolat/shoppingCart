package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.entity.Product;
import com.trendyol.shoppingcart.model.request.CreateProductRequest;

public class ProductMockDataBuilder {

    private ProductMockDataBuilder() {
    }

    public static CreateProductRequest generateProductRequest() {
        return GenericMockDataBuilder.of(CreateProductRequest.class).build();
    }

    public static ProductDto generateProductDto() {
        return GenericMockDataBuilder.of(ProductDto.class).build();
    }

    public static Product generateProduct() {
        return GenericMockDataBuilder.of(Product.class).build();
    }

}
