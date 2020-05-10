package com.trendyol.shoppingcart.service.impl;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.model.entity.Campaign;
import com.trendyol.shoppingcart.model.enums.DiscountType;
import com.trendyol.shoppingcart.repository.CampaignRepository;
import com.trendyol.shoppingcart.service.CampaignService;
import com.trendyol.shoppingcart.service.CategoryService;
import com.trendyol.shoppingcart.service.converter.CampaignConverter;
import com.trendyol.shoppingcart.service.mapper.CampaignEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignEntityMapper campaignEntityMapper;
    private final CampaignConverter campaignConverter;
    private final CategoryService categoryService;

    public CampaignServiceImpl(CampaignRepository campaignRepository,
                               CampaignEntityMapper campaignEntityMapper,
                               CampaignConverter campaignConverter,
                               CategoryService categoryService) {
        this.campaignRepository = campaignRepository;
        this.campaignEntityMapper = campaignEntityMapper;
        this.campaignConverter = campaignConverter;
        this.categoryService = categoryService;
    }

    @Override
    public CampaignDto createCampaign(CampaignDto dto) {

        Campaign campaign = campaignRepository.save(campaignEntityMapper.map(dto));

        return campaignConverter.convert(campaign);
    }

    @Override
    @Transactional(readOnly = true)

    public CampaignDto findById(Long id) {

        Optional<Campaign> optionalCampaign = campaignRepository.findById(id);

        if (!optionalCampaign.isPresent()) {
            throw new EntityNotFoundException();
        }

        return campaignConverter.convert(optionalCampaign.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CampaignDto> findCampaignsByCategoryIds(List<Long> ids,DiscountType discountType) {

        List<Campaign> campaigns = campaignRepository.findAllByCategoryIds(ids, discountType);

        return campaignConverter.convert(campaigns);
    }
}
