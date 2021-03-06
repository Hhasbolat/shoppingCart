package com.trendyol.shoppingcart.controller;

import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;
import com.trendyol.shoppingcart.service.CartService;
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

    @GetMapping("{cartId}")
    @ResponseBody
    public ResponseEntity<CartDto> getCart(@PathVariable("cartId") Long cartId){
        return ResponseEntity.ok(cartService.getCart(cartId));
    }

}
