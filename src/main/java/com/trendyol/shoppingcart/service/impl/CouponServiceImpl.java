package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.error.UserException;
import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.model.entity.Coupon;
import com.trendyol.shoppingcart.repository.CouponRepository;
import com.trendyol.shoppingcart.service.CouponService;
import com.trendyol.shoppingcart.service.converter.CouponConverter;
import com.trendyol.shoppingcart.service.mapper.CouponEntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponEntityManager couponEntityMapper;
    private final CouponConverter couponConverter;

    public CouponServiceImpl(CouponRepository couponRepository,
                             CouponEntityManager couponEntityMapper,
                             CouponConverter couponConverter) {
        this.couponRepository = couponRepository;
        this.couponEntityMapper = couponEntityMapper;
        this.couponConverter = couponConverter;
    }


    @Override
    public CouponDto createCoupon(CouponDto dto) {

        Coupon coupon = couponRepository.save(couponEntityMapper.map(dto));

        return couponConverter.convert(coupon);
    }

    @Override
    public CouponDto findById(Long id) {

        Optional<Coupon> optionalCoupon = couponRepository.findById(id);

        if (!optionalCoupon.isPresent()) {
            throw new UserException("entity not found");
        }

        return couponConverter.convert(optionalCoupon.get());
    }

    @Override
    public List<CouponDto> getAllCoupons() {
        List<Coupon> coupons = couponRepository.findAll();

        if (coupons.isEmpty()){
            throw new UserException("no coupons in entity");
        }

        return couponConverter.convert(coupons);
    }
}
