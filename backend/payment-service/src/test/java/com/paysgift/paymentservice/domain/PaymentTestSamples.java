package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Payment getPaymentSample1() {
        return new Payment()
            .id(1L)
            .paymentTypeId(1L)
            .countryId(1L)
            .name("name1")
            .description("description1")
            .descriptionEn("descriptionEn1")
            .logo("logo1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static Payment getPaymentSample2() {
        return new Payment()
            .id(2L)
            .paymentTypeId(2L)
            .countryId(2L)
            .name("name2")
            .description("description2")
            .descriptionEn("descriptionEn2")
            .logo("logo2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static Payment getPaymentRandomSampleGenerator() {
        return new Payment()
            .id(longCount.incrementAndGet())
            .paymentTypeId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .descriptionEn(UUID.randomUUID().toString())
            .logo(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
