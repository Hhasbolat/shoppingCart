package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.model.dto.CategoryDto;
import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.entity.Product;
import com.trendyol.shoppingcart.model.request.CreateProductRequest;
import com.trendyol.shoppingcart.repository.ProductRepository;
import com.trendyol.shoppingcart.service.CategoryService;
import com.trendyol.shoppingcart.service.ProductService;
import com.trendyol.shoppingcart.service.converter.ProductConverter;
import com.trendyol.shoppingcart.service.mapper.CategoryEntityMapper;
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


    public ProductServiceImpl(CategoryService categoryService,
                              ProductRepository productRepository,
                              ProductConverter productConverter,
                              CategoryEntityMapper categoryEntityMapper) {
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
