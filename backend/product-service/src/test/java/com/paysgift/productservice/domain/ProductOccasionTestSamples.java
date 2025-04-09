package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class ProductOccasionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ProductOccasion getProductOccasionSample1() {
        return new ProductOccasion().id(1L).productId(1L).occasionId(1L).createdBy(1L).updatedBy(1L);
    }

    public static ProductOccasion getProductOccasionSample2() {
        return new ProductOccasion().id(2L).productId(2L).occasionId(2L).createdBy(2L).updatedBy(2L);
    }

    public static ProductOccasion getProductOccasionRandomSampleGenerator() {
        return new ProductOccasion()
            .id(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .occasionId(longCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
