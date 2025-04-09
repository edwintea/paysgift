package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionDownloadTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TransactionDownload getTransactionDownloadSample1() {
        return new TransactionDownload().id(1L).transactionId(1L).customerId(1L).reason("reason1").createdBy(1L).updatedBy(1L);
    }

    public static TransactionDownload getTransactionDownloadSample2() {
        return new TransactionDownload().id(2L).transactionId(2L).customerId(2L).reason("reason2").createdBy(2L).updatedBy(2L);
    }

    public static TransactionDownload getTransactionDownloadRandomSampleGenerator() {
        return new TransactionDownload()
            .id(longCount.incrementAndGet())
            .transactionId(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .reason(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
