package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionLogTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TransactionLog getTransactionLogSample1() {
        return new TransactionLog().id(1L).transactionId(1L).title("title1").info("info1").createdBy(1L).updatedBy(1L);
    }

    public static TransactionLog getTransactionLogSample2() {
        return new TransactionLog().id(2L).transactionId(2L).title("title2").info("info2").createdBy(2L).updatedBy(2L);
    }

    public static TransactionLog getTransactionLogRandomSampleGenerator() {
        return new TransactionLog()
            .id(longCount.incrementAndGet())
            .transactionId(longCount.incrementAndGet())
            .title(UUID.randomUUID().toString())
            .info(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
