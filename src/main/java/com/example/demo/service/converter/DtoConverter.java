package com.example.demo.service.converter;

import com.example.demo.model.dto.BaseDto;
import com.example.demo.model.entity.BaseEntity;

import java.util.List;

public interface DtoConverter<T extends BaseDto,S extends BaseEntity> {
    T convert(S source);
    List<T> convert(List<S> source);
}
