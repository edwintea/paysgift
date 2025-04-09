package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class ProductFavouriteTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ProductFavourite getProductFavouriteSample1() {
        return new ProductFavourite()
            .id(1L)
            .productId(1L)
            .customerId(1L)
            .countryId(1L)
            .channelId(1L)
            .brandId(1L)
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static ProductFavourite getProductFavouriteSample2() {
        return new ProductFavourite()
            .id(2L)
            .productId(2L)
            .customerId(2L)
            .countryId(2L)
            .channelId(2L)
            .brandId(2L)
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static ProductFavourite getProductFavouriteRandomSampleGenerator() {
        return new ProductFavourite()
            .id(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
