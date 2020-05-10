package com.example.demo.controller;

import com.example.demo.model.dto.CampaignDto;
import com.example.demo.model.dto.CouponDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.CreateProductRequest;
import com.example.demo.service.CampaignService;
import com.example.demo.service.CouponService;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CampaignService campaignService;
    private final CouponService couponService;

    public ProductController(ProductService productService, CampaignService campaignService,
                             CouponService couponService) {
        this.productService = productService;
        this.campaignService = campaignService;
        this.couponService = couponService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/campaign")
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto request){
        return ResponseEntity.ok(campaignService.createCampaign(request));
    }

    @PostMapping("/coupon")
    public ResponseEntity<CouponDto> createCampaign(@RequestBody CouponDto request){
        return ResponseEntity.ok(couponService.createCoupon(request));
    }
}
