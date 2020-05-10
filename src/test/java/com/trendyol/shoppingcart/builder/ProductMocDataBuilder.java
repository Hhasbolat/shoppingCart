package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.request.CreateProductRequest;

public class ProductMocDataBuilder {

    private ProductMocDataBuilder() {
    }

    public static CreateProductRequest generateProductRequest() {
        return GenericMockDataBuilder.of(CreateProductRequest.class).build();
    }

     public static ProductDto generateProduct(){
        return GenericMockDataBuilder.of(ProductDto.class).build();
     }

}
