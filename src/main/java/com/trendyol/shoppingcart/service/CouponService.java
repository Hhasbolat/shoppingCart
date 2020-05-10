package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CouponDto;

public interface CouponService {

    CouponDto createCoupon(CouponDto dto);

    CouponDto findById(Long id);

}
