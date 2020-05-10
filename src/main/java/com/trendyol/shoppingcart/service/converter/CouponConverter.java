package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.model.entity.Coupon;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouponConverter implements DtoConverter<CouponDto, Coupon> {

    @Override
    public CouponDto convert(Coupon source) {

        CouponDto couponDto = new CouponDto();
        couponDto.setDiscount(source.getDiscount());
        couponDto.setDiscountType(source.getDiscountType());
        couponDto.setId(source.getId());
        couponDto.setMinimumPurchaseAmount(source.getMinimumPurchaseAmount());

        return couponDto;
    }

    @Override
    public List<CouponDto> convert(List<Coupon> source) {

        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
