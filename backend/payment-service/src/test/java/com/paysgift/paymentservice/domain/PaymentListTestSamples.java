package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentListTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaymentList getPaymentListSample1() {
        return new PaymentList()
            .id(1L)
            .status("status1")
            .type("type1")
            .code("code1")
            .name("name1")
            .paymentProviderId(1L)
            .paymentNotes("paymentNotes1")
            .imageUrl("imageUrl1")
            .howToPay("howToPay1")
            .note("note1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static PaymentList getPaymentListSample2() {
        return new PaymentList()
            .id(2L)
            .status("status2")
            .type("type2")
            .code("code2")
            .name("name2")
            .paymentProviderId(2L)
            .paymentNotes("paymentNotes2")
            .imageUrl("imageUrl2")
            .howToPay("howToPay2")
            .note("note2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static PaymentList getPaymentListRandomSampleGenerator() {
        return new PaymentList()
            .id(longCount.incrementAndGet())
            .status(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .paymentProviderId(longCount.incrementAndGet())
            .paymentNotes(UUID.randomUUID().toString())
            .imageUrl(UUID.randomUUID().toString())
            .howToPay(UUID.randomUUID().toString())
            .note(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
