package com.trendyol.shoppingcart.service.converter;

import com.trendyol.shoppingcart.model.dto.CartDto;
import com.trendyol.shoppingcart.model.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CartDtoConverter implements DtoConverter<CartDto, Cart> {

    private final CartItemConverter cartItemConverter;

    public CartDtoConverter(CartItemConverter cartItemConverter) {
        this.cartItemConverter = cartItemConverter;
    }
    @Override
    public CartDto convert(Cart source) {
        CartDto cartDto = new CartDto();
        cartDto.setCampaignDiscount(source.getCampaignDiscount());
        cartDto.setCouponDiscount(source.getCouponDiscount());
        cartDto.setDeliveryCost(source.getDeliveryCost());
        cartDto.setItems(cartItemConverter.convert(source.getItems()));
        cartDto.setTotalAmount(source.getTotalAmount());
        cartDto.setTotalPrice(source.getTotalPrice());
        cartDto.setTotalAmountAfterDiscounts(source.getTotalAmountAfterDiscounts());
        cartDto.setId(source.getId());

        return cartDto;
    }

    @Override
    public List<CartDto> convert(List<Cart> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
