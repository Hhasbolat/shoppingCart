package com.example.demo.service.mapper;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartEntityMapper implements EntityMapper<Cart, CartDto> {


    @Override
    public Cart map(CartDto source) {
        Cart cart = new Cart();
        cart.setId(source.getId());
        cart.setItems(convert(source.getItems()));
        cart.setTotalAmount(source.getTotalAmount());
        cart.setCampaignDiscount(source.getCampaignDiscount());
        cart.setDeliveryCost(source.getDeliveryCost());
        cart.setTotalAmountAfterDiscounts(source.getTotalAmountAfterDiscounts());
        cart.setTotalPrice(source.getTotalPrice());
        return cart;
    }

    @Override
    public List<Cart> map(List<CartDto> source) {
        return source
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private List<CartItem> convert(List<CartItemDto> cartItemDtos){
        List<CartItem> cartItems=new ArrayList<>();
        for (CartItemDto cartItemDto : cartItemDtos) {
            CartItem cartItem = new CartItem();
            cartItem.setId(cartItemDto.getId());
            cartItem.setQuantity(cartItem.getQuantity());
            cartItems.add(cartItem);
        }
        return cartItems;
    }
}
