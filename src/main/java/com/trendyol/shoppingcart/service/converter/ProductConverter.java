package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.CategoryDto;
import com.trendyol.shoppingcart.model.dto.ProductDto;
import com.trendyol.shoppingcart.model.entity.Product;
import com.trendyol.shoppingcart.service.CategoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter implements DtoConverter<ProductDto,Product> {

    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;

    public ProductConverter(CategoryService categoryService, CategoryDtoConverter categoryDtoConverter) {
        this.categoryService = categoryService;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    @Override
    public ProductDto convert(Product source) {
        if (source == null){
            return null;
        }
        CategoryDto categoryDto = categoryService.findCategoryById(source.getCategory().getId());

        ProductDto productDto=new ProductDto();
        productDto.setId(source.getId());
        productDto.setTitle(source.getTitle());
        productDto.setPrice(source.getPrice());
        productDto.setCategoryDto(categoryDto);
        return productDto;
    }

    @Override
    public List<ProductDto> convert(List<Product> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
