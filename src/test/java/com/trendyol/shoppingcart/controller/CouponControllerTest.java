package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.base.BaseControllerTest;
import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.service.CouponService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static com.trendyol.shoppingcart.builder.CouponMockDataBuilder.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CouponController.class)
class CouponControllerTest extends BaseControllerTest {

    private List<CouponDto> coupons;

    private CouponDto couponRequest;

    private CouponDto couponResponse;


    @MockBean
    CouponService couponService;

    @BeforeEach
    void setUp() {
        coupons = Collections.singletonList(generateCoupons());
        couponResponse = generateCoupon();
    }

    @Test
    void createCoupon() {
        when(couponService.createCoupon(couponRequest)).thenReturn(couponResponse);

        try {
            mockMvc.perform(post("/coupon/create")
                    .contentType(contentType)
                    .content(json(couponResponse))

            )
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void getAllCoupons() {

        when(couponService.getAllCoupons()).thenReturn(coupons);
        try {
            mockMvc.perform(get("/coupon/getAll"))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }

        verify(couponService, times(1)).getAllCoupons();
        verifyNoMoreInteractions(couponService);
    }
}