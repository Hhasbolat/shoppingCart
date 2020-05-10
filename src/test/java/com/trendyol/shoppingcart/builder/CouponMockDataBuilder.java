package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.dto.CouponDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CouponMockDataBuilder {

    public CouponMockDataBuilder() {
    }

    public static CouponDto generateCoupons(){
        return GenericMockDataBuilder.of(CouponDto.class).build();
    }

    public static CouponDto generateCoupon(){
        return GenericMockDataBuilder.of(CouponDto.class).build();
    }

}
