package com.trendyol.shoppingcart.service.mapper;

import com.trendyol.shoppingcart.model.dto.BaseDto;
import com.trendyol.shoppingcart.model.entity.BaseEntity;

import java.util.List;

public interface EntityMapper<T extends BaseEntity,S extends BaseDto>{

    T map(S source);
    List<T> map(List<S> source);
}
