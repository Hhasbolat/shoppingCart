package com.trendyol.shoppingcart.controller;


import com.trendyol.shoppingcart.base.BaseControllerTest;
import com.trendyol.shoppingcart.model.dto.CampaignDto;
import com.trendyol.shoppingcart.service.CampaignService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CampaignController.class)
class CampaignControllerTest extends BaseControllerTest {


    private CampaignDto campaignDto;

    @MockBean
    CampaignService campaignService;

    @BeforeEach
    void setUp() {
    }

    @Ignore
    @Test
    void createCampaign() {
        when(campaignService.createCampaign(campaignDto)).thenReturn(campaignDto);
        try {
            mockMvc.perform(post("/campaign/create")
                    .contentType(contentType)
                    .content(json(campaignDto))

            )
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail(e);
        }

    }
}