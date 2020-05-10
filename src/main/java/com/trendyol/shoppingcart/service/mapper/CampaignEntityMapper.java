package com.trendyol.shoppingcart.service.mapper;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.model.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CampaignEntityMapper implements EntityMapper<Campaign, CampaignDto> {
    private final CategoryEntityMapper categoryEntityMapper;

    public CampaignEntityMapper(CategoryEntityMapper categoryEntityMapper) {
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Campaign map(CampaignDto source) {
        Campaign campaign = new Campaign();
        campaign.setId(source.getId());
        campaign.setCategory(categoryEntityMapper.map(source.getCategory()));
        campaign.setDiscount(source.getDiscount());
        campaign.setDiscountType(source.getDiscountType());
        campaign.setMinimumProductCount(source.getMinimumProductCount());
        return campaign;
    }

    @Override
    public List<Campaign> map(List<CampaignDto> source) {
        return source.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
