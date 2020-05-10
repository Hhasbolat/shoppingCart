package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.model.dto.CategoryDto;
import com.trendyol.shoppingcart.model.entity.Category;
import com.trendyol.shoppingcart.repository.CategoryRepository;
import com.trendyol.shoppingcart.service.CategoryService;
import com.trendyol.shoppingcart.service.converter.CategoryDtoConverter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    @Override
    public CategoryDto findCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()){
            throw new EntityNotFoundException();
        }
        return categoryDtoConverter.convert(optionalCategory.get());
    }
}
