package com.example.demo.service;

import com.example.demo.model.dto.CampaignDto;
import com.example.demo.model.entity.Campaign;
import com.example.demo.model.enums.DiscountType;

import java.util.List;
import java.util.Set;

public interface CampaignService {

    CampaignDto createCampaign(CampaignDto dto);

    CampaignDto findById(Long id);

    List<CampaignDto> findCampaignsByCategoryIds(List<Long> ids, DiscountType discountType);
}
