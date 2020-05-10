package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.base.BaseControllerTest;
import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;
import com.trendyol.shoppingcart.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.trendyol.shoppingcart.builder.CartMockDataBuilder.generateCartDto;
import static com.trendyol.shoppingcart.builder.CartMockDataBuilder.generateCartRequest;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CartController.class)
class CartControllerTest extends BaseControllerTest {

    private static final Long CART_ID = 44L;
    private CartDto cartDto;
    private AddItemsRequest itemRequest;


    @MockBean
    CartService cartService;

    @BeforeEach
    void setUp() {
        itemRequest = generateCartRequest();

        cartDto = generateCartDto();
    }

    @Test
    void addProducts() {
        when(cartService.addProducts(CART_ID, itemRequest)).thenReturn(cartDto);

        try {
            mockMvc.perform(post("/cart/addProducts/{cartId}", CART_ID)
                    .contentType(contentType)
                    .content(json(itemRequest))

            )
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void getCart() {
        when(cartService.getCart(CART_ID)).thenReturn(cartDto);
        try {
            mockMvc.perform(get("/cart/{cartId}", CART_ID ))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }

        verify(cartService, times(1)).getCart(CART_ID);
        verifyNoMoreInteractions(cartService);
    }
}