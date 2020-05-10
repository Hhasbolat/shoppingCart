package com.example.demo.service.impl;

import com.example.demo.model.dto.CouponDto;
import com.example.demo.model.entity.Coupon;
import com.example.demo.repository.CouponRepository;
import com.example.demo.service.CouponService;
import com.example.demo.service.converter.CouponConverter;
import com.example.demo.service.mapper.CouponEntityManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponEntityManager couponEntityMapper;
    private final CouponConverter couponConverter;

    public CouponServiceImpl(CouponRepository couponRepository, CouponEntityManager couponEntityMapper,
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
            throw new EntityNotFoundException();
        }
        return couponConverter.convert(optionalCoupon.get());
    }
}
