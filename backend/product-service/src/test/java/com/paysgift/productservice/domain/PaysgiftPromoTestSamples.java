package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaysgiftPromoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaysgiftPromo getPaysgiftPromoSample1() {
        return new PaysgiftPromo().id(1L).bannerImage("bannerImage1").bannerUrl("bannerUrl1").createdBy(1L).updatedBy(1L);
    }

    public static PaysgiftPromo getPaysgiftPromoSample2() {
        return new PaysgiftPromo().id(2L).bannerImage("bannerImage2").bannerUrl("bannerUrl2").createdBy(2L).updatedBy(2L);
    }

    public static PaysgiftPromo getPaysgiftPromoRandomSampleGenerator() {
        return new PaysgiftPromo()
            .id(longCount.incrementAndGet())
            .bannerImage(UUID.randomUUID().toString())
            .bannerUrl(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
