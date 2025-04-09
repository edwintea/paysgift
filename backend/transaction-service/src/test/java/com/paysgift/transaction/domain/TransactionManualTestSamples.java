package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionManualTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TransactionManual getTransactionManualSample1() {
        return new TransactionManual().id(1L).transactionId(1L).notes("notes1").createdBy(1L).updatedBy(1L);
    }

    public static TransactionManual getTransactionManualSample2() {
        return new TransactionManual().id(2L).transactionId(2L).notes("notes2").createdBy(2L).updatedBy(2L);
    }

    public static TransactionManual getTransactionManualRandomSampleGenerator() {
        return new TransactionManual()
            .id(longCount.incrementAndGet())
            .transactionId(longCount.incrementAndGet())
            .notes(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
