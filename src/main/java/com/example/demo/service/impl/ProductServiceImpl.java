package com.example.demo.service.impl;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.request.CreateProductRequest;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.converter.ProductConverter;
import com.example.demo.service.mapper.CategoryEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryEntityMapper categoryEntityMapper;


    public ProductServiceImpl(CategoryService categoryService, ProductRepository productRepository, ProductConverter productConverter, CategoryEntityMapper categoryEntityMapper) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.categoryEntityMapper = categoryEntityMapper;
    }


    @Override
    @Transactional
    public ProductDto createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setPrice(request.getPrice());
        CategoryDto categoryDto = categoryService.findCategoryById(request.getCategoryId());
        product.setCategory(categoryEntityMapper.map(categoryDto));
        return productConverter.convert(productRepository.save(product));
    }

    @Override
    public ProductDto findProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            throw new EntityNotFoundException();
        }
        return productConverter.convert(optionalProduct.get());
    }

    @Override
    public List<ProductDto> findAllProductByIds(List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        return productConverter.convert(products);
    }


}
