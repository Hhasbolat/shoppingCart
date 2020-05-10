package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.model.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignConverter implements DtoConverter<CampaignDto, Campaign> {

    private final CategoryDtoConverter categoryDtoConverter;

    public CampaignConverter(CategoryDtoConverter categoryDtoConverter) {
        this.categoryDtoConverter = categoryDtoConverter;
    }

    @Override
    public CampaignDto convert(Campaign source) {

        CampaignDto campaignDto = new CampaignDto();
        campaignDto.setId(source.getId());
        campaignDto.setCategory(categoryDtoConverter.convert(source.getCategory()));
        campaignDto.setDiscount(source.getDiscount());
        campaignDto.setDiscountType(source.getDiscountType());
        campaignDto.setMinimumProductCount(source.getMinimumProductCount());

        return campaignDto;
    }

    @Override
    public List<CampaignDto> convert(List<Campaign> source) {

        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
