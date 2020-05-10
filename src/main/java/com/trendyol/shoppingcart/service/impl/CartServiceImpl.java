package com.trendyol.shoppingcart.service.impl;


import com.trendyol.shoppingcart.error.UserException;
import com.trendyol.shoppingcart.model.dto.*;
import com.trendyol.shoppingcart.model.entity.Cart;
import com.trendyol.shoppingcart.model.enums.DiscountType;
import com.trendyol.shoppingcart.model.request.AddItemsRequest;
import com.trendyol.shoppingcart.repository.CartRepository;
import com.trendyol.shoppingcart.service.CampaignService;
import com.trendyol.shoppingcart.service.CartService;
import com.trendyol.shoppingcart.service.DeliveryCostCalculatorService;
import com.trendyol.shoppingcart.service.ProductService;
import com.trendyol.shoppingcart.service.converter.CartDtoConverter;
import com.trendyol.shoppingcart.service.mapper.CartEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartDtoConverter cartDtoConverter;
    private final CampaignService campaignService;
    private final CartEntityMapper cartEntityMapper;
    private final DeliveryCostCalculatorService deliveryCostCalculatorService;


    public CartServiceImpl(CartRepository cartRepository,
                           ProductService productService,
                           CartDtoConverter cartDtoConverter,
                           CampaignService campaignService,
                           CartEntityMapper cartEntityMapper,
                           DeliveryCostCalculatorService deliveryCostCalculatorService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.cartDtoConverter = cartDtoConverter;
        this.campaignService = campaignService;
        this.cartEntityMapper = cartEntityMapper;
        this.deliveryCostCalculatorService = deliveryCostCalculatorService;
    }

    @Override
    @Transactional
    public CartDto addProducts(Long cartId, AddItemsRequest addItemsRequest) {

        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        CartDto cartDto = cartDtoConverter.convert(optionalCart.get());
        List<CartItemDto> cartItemDtos = prepareCartItem(addItemsRequest);
        BigDecimal totalPrice = calculateTotalPrice(cartItemDtos);
        cartDto.setItems(cartItemDtos);

        cartDto.setTotalPrice(totalPrice);
        cartDto.getItems().addAll(cartItemDtos);
        BigDecimal discountByRate = calculateDiscountByRate(cartDto, totalPrice);

        if (discountByRate.compareTo(BigDecimal.ZERO) == 0) {
            BigDecimal discountByAmount = calculateDiscountByAmount(cartDto, totalPrice);
            cartDto.setCampaignDiscount(discountByAmount);
        } else {
            cartDto.setCampaignDiscount(discountByRate);
        }

        cartDto.setTotalAmountAfterDiscounts(totalPrice.subtract(cartDto.getCampaignDiscount()));
        cartDto.setDeliveryCost(BigDecimal.valueOf(deliveryCostCalculatorService.calculateFor(cartDto)));

        Cart cart = cartEntityMapper.map(cartDto);
        cartRepository.save(cart);

        return cartDto;
    }


    @Override
    public CartDto getCart(Long id) {

        Optional<Cart> optionalCart = cartRepository.findById(id);

        if (!optionalCart.isPresent()) {
            throw new UserException("entity not found");
        }

        return cartDtoConverter.convert(optionalCart.get());
    }

    @Override
    public Double calculateDeliveryCost(CartDto cartDto) {
        return deliveryCostCalculatorService.calculateFor(cartDto);
    }

    private BigDecimal calculateTotalPrice(List<CartItemDto> cartItems) {

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CartItemDto item : cartItems) {
            totalPrice = totalPrice.add(item.getProductDto().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalPrice;
    }

    private List<CartItemDto> prepareCartItem(AddItemsRequest addItemsRequest) {

        List<CartItemDto> cartItemDtos = new ArrayList<>();

        for (ProductCartItem item : addItemsRequest.getItems()) {
            ProductDto productDto = productService.getProductById(item.getProductId());
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setProductDto(productDto);
            cartItemDto.setQuantity(item.getQuantity());
            cartItemDtos.add(cartItemDto);
        }

        return cartItemDtos;
    }

    private BigDecimal calculateDiscountByRate(CartDto cartDto, BigDecimal totalPrice) {

        Map<Long, Integer> categoryIdQuantityMap = new HashMap<>();
        for (CartItemDto item : cartDto.getItems()) {
            categoryIdQuantityMap.merge(item.getProductDto().getCategoryDto().getId(), item.getQuantity(), Integer::sum);
        }

        List<Long> ids = cartDto.getItems()
                .stream()
                .map(CartItemDto::getProductDto)
                .map(ProductDto::getCategoryDto)
                .map(CategoryDto::getId)
                .collect(Collectors.toList());

        List<CampaignDto> campaigns = campaignService.findCampaignsByCategoryIds(ids, DiscountType.RATE);
        BigDecimal maximumDiscount = BigDecimal.ZERO;
        for (CampaignDto campaignDto : campaigns) {
            if (categoryIdQuantityMap.get(campaignDto.getCategory().getId()) > campaignDto.getMinimumProductCount()
                    && campaignDto.getDiscount().compareTo(maximumDiscount) >= 0) {
                maximumDiscount = campaignDto.getDiscount();

            }
        }

        return totalPrice.multiply(maximumDiscount).divide(BigDecimal.valueOf(100)).setScale(2);
    }

    private BigDecimal calculateDiscountByAmount(CartDto cartDto, BigDecimal totalPrice) {

        int itemCount = 0;
        for (CartItemDto item : cartDto.getItems()) {
            itemCount = itemCount + item.getQuantity();
        }

        List<Long> ids = cartDto.getItems()
                .stream()
                .map(CartItemDto::getProductDto)
                .map(ProductDto::getCategoryDto)
                .map(CategoryDto::getId)
                .collect(Collectors.toList());

        List<CampaignDto> campaigns = campaignService.findCampaignsByCategoryIds(ids, DiscountType.AMOUNT);
        BigDecimal maximumAmount = BigDecimal.ZERO;
        for (CampaignDto campaignDto : campaigns) {
            if (itemCount > 1
                    && campaignDto.getDiscount().compareTo(maximumAmount) >= 0) {
                maximumAmount = campaignDto.getDiscount();

            }
        }

        return totalPrice.multiply(maximumAmount).subtract(maximumAmount);
    }
}
