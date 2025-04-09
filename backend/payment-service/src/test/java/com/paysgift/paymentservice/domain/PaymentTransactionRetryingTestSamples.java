package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTransactionRetryingTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static PaymentTransactionRetrying getPaymentTransactionRetryingSample1() {
        return new PaymentTransactionRetrying()
            .id(1L)
            .paymentTransactionRecurringId(1L)
            .status("status1")
            .attemptRetry(1)
            .sendCallbackAttempt(1)
            .sendEmailAttempt(1)
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static PaymentTransactionRetrying getPaymentTransactionRetryingSample2() {
        return new PaymentTransactionRetrying()
            .id(2L)
            .paymentTransactionRecurringId(2L)
            .status("status2")
            .attemptRetry(2)
            .sendCallbackAttempt(2)
            .sendEmailAttempt(2)
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static PaymentTransactionRetrying getPaymentTransactionRetryingRandomSampleGenerator() {
        return new PaymentTransactionRetrying()
            .id(longCount.incrementAndGet())
            .paymentTransactionRecurringId(longCount.incrementAndGet())
            .status(UUID.randomUUID().toString())
            .attemptRetry(intCount.incrementAndGet())
            .sendCallbackAttempt(intCount.incrementAndGet())
            .sendEmailAttempt(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
