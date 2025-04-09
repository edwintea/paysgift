package com.paysgift.orderservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CartDeleteTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static CartDelete getCartDeleteSample1() {
        return new CartDelete()
            .id(1L)
            .transactionDetailId(1L)
            .customerId(1L)
            .countryId(1L)
            .clientId(1L)
            .channelId(1L)
            .brandId(1L)
            .productId(1L)
            .qty(1)
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static CartDelete getCartDeleteSample2() {
        return new CartDelete()
            .id(2L)
            .transactionDetailId(2L)
            .customerId(2L)
            .countryId(2L)
            .clientId(2L)
            .channelId(2L)
            .brandId(2L)
            .productId(2L)
            .qty(2)
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static CartDelete getCartDeleteRandomSampleGenerator() {
        return new CartDelete()
            .id(longCount.incrementAndGet())
            .transactionDetailId(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .clientId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .qty(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
