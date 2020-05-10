package com.example.demo.controller;

import com.example.demo.model.dto.CampaignDto;
import com.example.demo.service.CampaignService;
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

    @PostMapping("/campaign")
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto request) {
        return ResponseEntity.ok(campaignService.createCampaign(request));
    }
}
