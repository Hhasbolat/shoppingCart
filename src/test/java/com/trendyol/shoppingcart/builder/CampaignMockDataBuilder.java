package com.trendyol.shoppingcart.builder;

import com.trendyol.shoppingcart.model.dto.CampaignDto;

public class CampaignMockDataBuilder {

    public CampaignMockDataBuilder() {
    }

    public static CampaignDto campaignDtoGenerate() {
       return GenericMockDataBuilder.of(CampaignDto.class).build();
    }
}
