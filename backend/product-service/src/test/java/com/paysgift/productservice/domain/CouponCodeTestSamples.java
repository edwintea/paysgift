package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CouponCodeTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static CouponCode getCouponCodeSample1() {
        return new CouponCode()
            .id(1L)
            .couponId(1L)
            .productId(1L)
            .code("code1")
            .count(1)
            .countRemaining(1)
            .discountType("discountType1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static CouponCode getCouponCodeSample2() {
        return new CouponCode()
            .id(2L)
            .couponId(2L)
            .productId(2L)
            .code("code2")
            .count(2)
            .countRemaining(2)
            .discountType("discountType2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static CouponCode getCouponCodeRandomSampleGenerator() {
        return new CouponCode()
            .id(longCount.incrementAndGet())
            .couponId(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .count(intCount.incrementAndGet())
            .countRemaining(intCount.incrementAndGet())
            .discountType(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
