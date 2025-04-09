package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class CouponTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Coupon getCouponSample1() {
        return new Coupon().id(1L).countryId(1L).channelId(1L).brandId(1L).name("name1").tnc("tnc1").createdBy(1L).updatedBy(1L).n("n1");
    }

    public static Coupon getCouponSample2() {
        return new Coupon().id(2L).countryId(2L).channelId(2L).brandId(2L).name("name2").tnc("tnc2").createdBy(2L).updatedBy(2L).n("n2");
    }

    public static Coupon getCouponRandomSampleGenerator() {
        return new Coupon()
            .id(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .tnc(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet())
            .n(UUID.randomUUID().toString());
    }
}
