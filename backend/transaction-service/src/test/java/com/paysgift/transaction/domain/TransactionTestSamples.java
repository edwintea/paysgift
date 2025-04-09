package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Transaction getTransactionSample1() {
        return new Transaction()
            .id(1L)
            .customerId(1L)
            .countryId(1L)
            .clientId(1L)
            .channelId(1L)
            .brandId(1L)
            .currencyId(1L)
            .currencyCode("currencyCode1")
            .paymentId(1L)
            .couponCodeId(1L)
            .shopbackReference("shopbackReference1")
            .code("code1")
            .invoiceCode("invoiceCode1")
            .paymentNumber("paymentNumber1")
            .paymentQr("paymentQr1")
            .paymentLink("paymentLink1")
            .paymentReferenceId("paymentReferenceId1")
            .status("status1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static Transaction getTransactionSample2() {
        return new Transaction()
            .id(2L)
            .customerId(2L)
            .countryId(2L)
            .clientId(2L)
            .channelId(2L)
            .brandId(2L)
            .currencyId(2L)
            .currencyCode("currencyCode2")
            .paymentId(2L)
            .couponCodeId(2L)
            .shopbackReference("shopbackReference2")
            .code("code2")
            .invoiceCode("invoiceCode2")
            .paymentNumber("paymentNumber2")
            .paymentQr("paymentQr2")
            .paymentLink("paymentLink2")
            .paymentReferenceId("paymentReferenceId2")
            .status("status2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static Transaction getTransactionRandomSampleGenerator() {
        return new Transaction()
            .id(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .clientId(longCount.incrementAndGet())
            .channelId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .currencyId(longCount.incrementAndGet())
            .currencyCode(UUID.randomUUID().toString())
            .paymentId(longCount.incrementAndGet())
            .couponCodeId(longCount.incrementAndGet())
            .shopbackReference(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .invoiceCode(UUID.randomUUID().toString())
            .paymentNumber(UUID.randomUUID().toString())
            .paymentQr(UUID.randomUUID().toString())
            .paymentLink(UUID.randomUUID().toString())
            .paymentReferenceId(UUID.randomUUID().toString())
            .status(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
