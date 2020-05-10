package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.model.dto.CouponDto;
import com.trendyol.shoppingcart.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
