package com.example.demo.controller;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.request.AddItemsRequest;
import com.example.demo.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addProducts/{cartId}")
    @ResponseBody
    public ResponseEntity<?> addProducts(@PathVariable("cartId") Long cartId, @RequestBody AddItemsRequest addItemsRequest){
        return ResponseEntity.ok(cartService.addProducts(cartId,addItemsRequest));
    }

}
