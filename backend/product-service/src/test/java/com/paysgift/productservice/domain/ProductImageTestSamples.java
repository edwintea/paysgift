package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ProductImageTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ProductImage getProductImageSample1() {
        return new ProductImage()
            .id(1L)
            .productId(1L)
            .clientId(1L)
            .channelId(1L)
            .brandId(1L)
            .image("image1")
            .priority("priority1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static ProductImage getProductImageSample2() {
        return new ProductImage()
            .id(2L)
            .productId(2L)
            .clientId(2L)
            .channelId(2L)
            .brandId(2L)
            .image("image2")
            .priority("priority2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static ProductImage getProductImageRandomSampleGenerator() {
        return new ProductImage()
            .id(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .clientId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .image(UUID.randomUUID().toString())
            .priority(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
