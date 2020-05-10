package com.example.demo.service.mapper;

import com.example.demo.model.dto.CouponDto;
import com.example.demo.model.entity.Coupon;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouponEntityManager implements EntityMapper<Coupon, CouponDto> {

    @Override
    public Coupon map(CouponDto source) {
        Coupon coupon = new Coupon();
        coupon.setId(source.getId());
        coupon.setDiscount(source.getDiscount());
        coupon.setDiscountType(source.getDiscountType());
        coupon.setMinimumPurchaseAmount(source.getMinimumPurchaseAmount());
        return null;
    }

    @Override
    public List<Coupon> map(List<CouponDto> source) {
        return source.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}

