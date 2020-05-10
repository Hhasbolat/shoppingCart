package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.BaseDto;
import com.trendyol.shoppingcart.model.entity.BaseEntity;

import java.util.List;

public interface DtoConverter<T extends BaseDto,S extends BaseEntity> {

    T convert(S source);
    List<T> convert(List<S> source);
}
