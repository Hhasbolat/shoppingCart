package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.request.CreateProductRequest;

import java.util.List;

public interface ProductService {

     ProductDto createProduct(CreateProductRequest request);

     ProductDto findProductById(Long id);

     List<ProductDto> findAllProductByIds(List<Long> productIds);
}
