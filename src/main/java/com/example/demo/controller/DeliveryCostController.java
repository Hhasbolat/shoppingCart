package com.example.demo.controller;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.CartService;
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
    public ResponseEntity<Double> calculateDeliveryCost(@RequestBody CartDto request){
        return ResponseEntity.ok(cartService.calculateDeliveryCost(request));
    }

}
