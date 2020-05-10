package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto request){
        return ResponseEntity.ok(couponService.createCoupon(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CouponDto>> getAllCoupons(){
        return ResponseEntity.ok(couponService.getAllCoupons());
    }
}
