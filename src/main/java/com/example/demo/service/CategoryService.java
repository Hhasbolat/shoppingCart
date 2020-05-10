package com.example.demo.service;

import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.entity.Category;

public interface CategoryService {

    CategoryDto findCategoryById(Long id);
}
