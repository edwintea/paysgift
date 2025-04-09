package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class ProductCategoryTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ProductCategory getProductCategorySample1() {
        return new ProductCategory().id(1L).productId(1L).categoryId(1L).createdBy(1L).updatedBy(1L);
    }

    public static ProductCategory getProductCategorySample2() {
        return new ProductCategory().id(2L).productId(2L).categoryId(2L).createdBy(2L).updatedBy(2L);
    }

    public static ProductCategory getProductCategoryRandomSampleGenerator() {
        return new ProductCategory()
            .id(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .categoryId(longCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
