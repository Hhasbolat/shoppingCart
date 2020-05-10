package com.example.demo.service;

import com.example.demo.model.dto.CouponDto;

public interface CouponService {

    CouponDto createCoupon(CouponDto dto);

    CouponDto findById(Long id);

}
