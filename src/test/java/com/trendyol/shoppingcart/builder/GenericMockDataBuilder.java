package com.trendyol.shoppingcart.builder;

import uk.co.jemos.podam.api.*;

public class GenericMockDataBuilder<T> {

    private final Class<T> type;
    private final PodamFactory podamFactory;
    private AbstractClassInfoStrategy classInfoStrategy;

    private GenericMockDataBuilder(Class<T> type) {
        this.type = type;
        podamFactory = new PodamFactoryImpl(new RandomDataProviderStrategyImpl());
        classInfoStrategy = DefaultClassInfoStrategy.getInstance();
    }

    static <T> GenericMockDataBuilder<T> of(Class<T> type) {
        return new GenericMockDataBuilder<>(type);
    }

    T build() {
        return podamFactory.manufacturePojo(type);
    }

}