package com.example.demo.service;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.request.CreateProductRequest;

import java.util.List;

public interface ProductService {
     ProductDto createProduct(CreateProductRequest request);
     ProductDto findProductById(Long id);
     List<ProductDto> findAllProductByIds(List<Long> productIds);

}
