package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CategoryDto;

public interface CategoryService {

    CategoryDto findCategoryById(Long id);
}
