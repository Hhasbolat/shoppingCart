package com.trendyol.shoppingcart.service;

import com.trendyol.shoppingcart.model.dto.CartDto;

public interface DeliveryCostCalculatorService {

    Double calculateFor(CartDto cart);

}
