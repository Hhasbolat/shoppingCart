package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.model.enums.DiscountType;

import java.util.List;

public interface CampaignService {

    CampaignDto createCampaign(CampaignDto dto);

    CampaignDto findById(Long id);

    List<CampaignDto> findCampaignsByCategoryIds(List<Long> ids, DiscountType discountType);
}
