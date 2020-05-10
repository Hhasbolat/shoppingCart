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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }


}
