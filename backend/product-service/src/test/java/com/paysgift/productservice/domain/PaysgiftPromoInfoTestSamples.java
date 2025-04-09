package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class PaysgiftPromoInfoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaysgiftPromoInfo getPaysgiftPromoInfoSample1() {
        return new PaysgiftPromoInfo().id(1L).paysgiftPromoId(1L).voucherId(1L).createdBy(1L).updatedBy(1L);
    }

    public static PaysgiftPromoInfo getPaysgiftPromoInfoSample2() {
        return new PaysgiftPromoInfo().id(2L).paysgiftPromoId(2L).voucherId(2L).createdBy(2L).updatedBy(2L);
    }

    public static PaysgiftPromoInfo getPaysgiftPromoInfoRandomSampleGenerator() {
        return new PaysgiftPromoInfo()
            .id(longCount.incrementAndGet())
            .paysgiftPromoId(longCount.incrementAndGet())
            .voucherId(longCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
