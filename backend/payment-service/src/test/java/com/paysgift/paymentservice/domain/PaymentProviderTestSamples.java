package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentProviderTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaymentProvider getPaymentProviderSample1() {
        return new PaymentProvider().id(1L).provider("provider1").createdBy(1L).updatedBy(1L);
    }

    public static PaymentProvider getPaymentProviderSample2() {
        return new PaymentProvider().id(2L).provider("provider2").createdBy(2L).updatedBy(2L);
    }

    public static PaymentProvider getPaymentProviderRandomSampleGenerator() {
        return new PaymentProvider()
            .id(longCount.incrementAndGet())
            .provider(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
