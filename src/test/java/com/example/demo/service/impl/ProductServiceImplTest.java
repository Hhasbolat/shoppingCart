package com.example.demo.service.impl;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.request.CreateProductRequest;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.converter.ProductConverter;
import com.example.demo.service.mapper.CategoryEntityMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    private  CategoryService categoryService;
    @Mock
    private  ProductRepository productRepository;
    @Mock
    private  ProductConverter productConverter;
    @Mock
    private CategoryEntityMapper categoryEntityMapper;


    private CreateProductRequest request;
    private ProductDto productDto;
    private  CategoryDto categoryDto;

    @Before
    public void setUp() throws Exception {
        request = new CreateProductRequest();
        categoryDto = new CategoryDto();
        productDto = new ProductDto();

        categoryDto.setId(1L);
        categoryDto.setTitle("food");
        request.setTitle("elma");
        request.setCategoryId(1L);
        request.setPrice(BigDecimal.TEN);
        productDto.setId(1L);
        productDto.setTitle(request.getTitle());
        productDto.setPrice(request.getPrice());
        productDto.setCategoryDto(categoryDto);
    }

    @Test
    public void createProduct_Success() {


    }

    @Test
    public void findProductById() {



        Optional<Product> optionalProduct = productRepository.findById(productDto.getId());

        assertThat(optionalProduct, is(Optional.empty()));
    }

    @Test
    public void findAllProductByIds() {
    }
}