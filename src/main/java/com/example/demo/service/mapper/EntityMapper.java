package com.example.demo.service.mapper;

import com.example.demo.model.dto.BaseDto;
import com.example.demo.model.entity.BaseEntity;

import java.util.List;

public interface EntityMapper<T extends BaseEntity,S extends BaseDto>{
    T map(S source);
    List<T> map(List<S> source);
}
