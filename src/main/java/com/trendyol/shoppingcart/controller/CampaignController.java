package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/campaign")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping("/create")
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto request) {
        return ResponseEntity.ok(campaignService.createCampaign(request));
    }
}
