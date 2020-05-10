package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.request.CreateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

public class ProductMocDataBuilder {

    private ProductMocDataBuilder() {
    }



    public static CreateProductRequest generateProductRequest() {
        return GenericMockDataBuilder.of(CreateProductRequest.class).build();
    }


}
