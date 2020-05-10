package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CouponDto;

import java.util.List;

public interface CouponService {

    CouponDto createCoupon(CouponDto dto);

    CouponDto findById(Long id);

    List<CouponDto> getAllCoupons();
}
