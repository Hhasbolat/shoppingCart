package com.example.demo.controller;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.request.CreateProductRequest;
import com.example.demo.service.CartService;
import com.example.demo.service.DeliveryCostCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryCostController {

    private final CartService cartService;


    public DeliveryCostController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> createProduct(@RequestBody CartDto request){
        return ResponseEntity.ok(cartService.getDeliveryCost(request));
    }

}
