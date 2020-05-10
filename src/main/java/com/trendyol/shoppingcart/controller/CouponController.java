package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/create")
    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto request){
        return ResponseEntity.ok(couponService.createCoupon(request));
    }
}
