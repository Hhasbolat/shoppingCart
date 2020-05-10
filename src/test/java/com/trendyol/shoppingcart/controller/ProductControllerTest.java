package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.base.BaseControllerTest;
import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.request.CreateProductRequest;
import com.trendyol.shoppingcart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static com.trendyol.shoppingcart.builder.ProductMockDataBuilder.generateProductDto;
import static com.trendyol.shoppingcart.builder.ProductMockDataBuilder.generateProductRequest;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(value = ProductController.class)
class ProductControllerTest extends BaseControllerTest {

    private static final Long PRODUCT_ID = 1L;
    private List<ProductDto> productResponseList;
    private CreateProductRequest productRequest;
    private ProductDto product;

    @MockBean
    ProductService productService;

    @BeforeEach
    void setUp() {
        productRequest = generateProductRequest();

        product = generateProductDto();

        productResponseList = Collections.singletonList(generateProductDto());
    }

    @Test
    void getProductById() {
        when(productService.getProductById(PRODUCT_ID)).thenReturn(product);
        try {
            mockMvc.perform(get("/product/{id}", PRODUCT_ID))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }

        verify(productService, times(1)).getProductById(PRODUCT_ID);
        verifyNoMoreInteractions(productService);
    }

    @Test
    void getAllProducts() {
        when(productService.getAllProducts()).thenReturn(productResponseList);
        try {
            mockMvc.perform(get("/product/getAll"))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }

        verify(productService, times(1)).getAllProducts();
        verifyNoMoreInteractions(productService);

    }

    @Test
    void createProduct() {

        when(productService.createProduct(productRequest)).thenReturn(product);

        try {
            mockMvc.perform(post("/product/create")
                    .contentType(contentType)
                    .content(json(productRequest))

            )
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }
    }
}