package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class EvoucherDeliveryTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static EvoucherDelivery getEvoucherDeliverySample1() {
        return new EvoucherDelivery().id(1L).countryId(1L).type("type1").createdBy(1L).updatedBy(1L);
    }

    public static EvoucherDelivery getEvoucherDeliverySample2() {
        return new EvoucherDelivery().id(2L).countryId(2L).type("type2").createdBy(2L).updatedBy(2L);
    }

    public static EvoucherDelivery getEvoucherDeliveryRandomSampleGenerator() {
        return new EvoucherDelivery()
            .id(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .type(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
