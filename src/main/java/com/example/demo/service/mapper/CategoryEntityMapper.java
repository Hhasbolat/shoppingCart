package com.example.demo.service.mapper;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryEntityMapper implements EntityMapper<Category, CategoryDto> {

    @Override
    public Category map(CategoryDto source) {
        Category category = new Category();
        category.setTitle(source.getTitle());
        category.setId(source.getId());
        return category;
    }

    @Override
    public List<Category> map(List<CategoryDto> source) {
        return source.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
