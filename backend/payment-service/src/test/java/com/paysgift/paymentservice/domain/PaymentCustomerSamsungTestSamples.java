package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentCustomerSamsungTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaymentCustomerSamsung getPaymentCustomerSamsungSample1() {
        return new PaymentCustomerSamsung()
            .id(1L)
            .sgiUid("sgiUid1")
            .name("name1")
            .email("email1")
            .mobileNumber("mobileNumber1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static PaymentCustomerSamsung getPaymentCustomerSamsungSample2() {
        return new PaymentCustomerSamsung()
            .id(2L)
            .sgiUid("sgiUid2")
            .name("name2")
            .email("email2")
            .mobileNumber("mobileNumber2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static PaymentCustomerSamsung getPaymentCustomerSamsungRandomSampleGenerator() {
        return new PaymentCustomerSamsung()
            .id(longCount.incrementAndGet())
            .sgiUid(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .email(UUID.randomUUID().toString())
            .mobileNumber(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
