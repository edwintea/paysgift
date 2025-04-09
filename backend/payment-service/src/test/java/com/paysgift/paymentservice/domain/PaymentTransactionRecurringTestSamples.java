package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTransactionRecurringTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static PaymentTransactionRecurring getPaymentTransactionRecurringSample1() {
        return new PaymentTransactionRecurring()
            .id(1L)
            .paymentProviderId(1L)
            .paymentListId(1L)
            .paymentTransactionId(1L)
            .customerId(1L)
            .paymentMethodId(1L)
            .recurringPlanId(1L)
            .cycleId(1L)
            .scheduleId(1L)
            .actionId(1L)
            .cycle(1)
            .totalRetry(1)
            .attemptRetry(1)
            .sendCallbackAttempt(1)
            .paymentLink("paymentLink1")
            .referenceId("referenceId1")
            .dataObj("dataObj1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static PaymentTransactionRecurring getPaymentTransactionRecurringSample2() {
        return new PaymentTransactionRecurring()
            .id(2L)
            .paymentProviderId(2L)
            .paymentListId(2L)
            .paymentTransactionId(2L)
            .customerId(2L)
            .paymentMethodId(2L)
            .recurringPlanId(2L)
            .cycleId(2L)
            .scheduleId(2L)
            .actionId(2L)
            .cycle(2)
            .totalRetry(2)
            .attemptRetry(2)
            .sendCallbackAttempt(2)
            .paymentLink("paymentLink2")
            .referenceId("referenceId2")
            .dataObj("dataObj2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static PaymentTransactionRecurring getPaymentTransactionRecurringRandomSampleGenerator() {
        return new PaymentTransactionRecurring()
            .id(longCount.incrementAndGet())
            .paymentProviderId(longCount.incrementAndGet())
            .paymentListId(longCount.incrementAndGet())
            .paymentTransactionId(longCount.incrementAndGet())
            .customerId(longCount.incrementAndGet())
            .paymentMethodId(longCount.incrementAndGet())
            .recurringPlanId(longCount.incrementAndGet())
            .cycleId(longCount.incrementAndGet())
            .scheduleId(longCount.incrementAndGet())
            .actionId(longCount.incrementAndGet())
            .cycle(intCount.incrementAndGet())
            .totalRetry(intCount.incrementAndGet())
            .attemptRetry(intCount.incrementAndGet())
            .sendCallbackAttempt(intCount.incrementAndGet())
            .paymentLink(UUID.randomUUID().toString())
            .referenceId(UUID.randomUUID().toString())
            .dataObj(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
