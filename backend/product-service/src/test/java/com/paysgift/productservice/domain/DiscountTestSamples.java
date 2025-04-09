package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DiscountTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Discount getDiscountSample1() {
        return new Discount()
            .id(1L)
            .countryId(1L)
            .clientId(1L)
            .channelId(1L)
            .brandId(1L)
            .name("name1")
            .priority("priority1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static Discount getDiscountSample2() {
        return new Discount()
            .id(2L)
            .countryId(2L)
            .clientId(2L)
            .channelId(2L)
            .brandId(2L)
            .name("name2")
            .priority("priority2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static Discount getDiscountRandomSampleGenerator() {
        return new Discount()
            .id(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .clientId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .priority(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
