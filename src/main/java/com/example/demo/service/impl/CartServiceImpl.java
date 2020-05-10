package com.example.demo.service.impl;

import com.example.demo.model.dto.*;
import com.example.demo.model.dummy.ProductCartItem;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.enums.DiscountType;
import com.example.demo.model.request.AddItemsRequest;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CampaignService;
import com.example.demo.service.CartService;
import com.example.demo.service.DeliveryCostCalculatorService;
import com.example.demo.service.ProductService;
import com.example.demo.service.converter.CartDtoConverter;
import com.example.demo.service.mapper.CartEntityMapper;
import com.example.demo.service.mapper.ProductEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ProductEntityMapper productEntityMapper;
    private final CartDtoConverter cartDtoConverter;
    private final CampaignService campaignService;
    private final CartItemRepository cartItemRepository;
    private final CartEntityMapper cartEntityMapper;
    private final DeliveryCostCalculatorService deliveryCostCalculatorService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService,
                           ProductEntityMapper productEntityMapper, CartDtoConverter cartDtoConverter,
                           CampaignService campaignService, CartItemRepository cartItemRepository, CartEntityMapper cartEntityMapper,
                           DeliveryCostCalculatorService deliveryCostCalculatorService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.productEntityMapper = productEntityMapper;
        this.cartDtoConverter = cartDtoConverter;
        this.campaignService = campaignService;
        this.cartItemRepository = cartItemRepository;
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
    public Double getDeliveryCost(CartDto cartDto) {
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
            ProductDto productDto = productService.findProductById(item.getProductId());
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
