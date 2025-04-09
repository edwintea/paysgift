package com.paysgift.orderservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CartTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Cart getCartSample1() {
        return new Cart()
            .id(1L)
            .customerId(1L)
            .countryId(1L)
            .clientId("clientId1")
            .channelId(1L)
            .brandId(1L)
            .productId(1L)
            .qty(1)
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static Cart getCartSample2() {
        return new Cart()
            .id(2L)
            .customerId(2L)
            .countryId(2L)
            .clientId("clientId2")
            .channelId(2L)
            .brandId(2L)
            .productId(2L)
            .qty(2)
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static Cart getCartRandomSampleGenerator() {
        return new Cart()
            .id(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .clientId(UUID.randomUUID().toString())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .qty(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
