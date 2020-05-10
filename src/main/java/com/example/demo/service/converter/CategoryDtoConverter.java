package com.example.demo.service.converter;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CategoryDtoConverter implements DtoConverter<CategoryDto, Category>{

    @Override
    public CategoryDto convert(Category source) {
       if (source == null){
           return null;
       }
       CategoryDto categoryDto = new CategoryDto();
       categoryDto.setId(source.getId());
       categoryDto.setTitle(source.getTitle());

       return categoryDto;
    }

    @Override
    public List<CategoryDto> convert(List<Category> source) {
        return source
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
