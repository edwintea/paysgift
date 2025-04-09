package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTransactionCampaignTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static PaymentTransactionCampaign getPaymentTransactionCampaignSample1() {
        return new PaymentTransactionCampaign().id(1L).paymentTransactionId(1L).cycle(1).createdBy(1L).updatedBy(1L);
    }

    public static PaymentTransactionCampaign getPaymentTransactionCampaignSample2() {
        return new PaymentTransactionCampaign().id(2L).paymentTransactionId(2L).cycle(2).createdBy(2L).updatedBy(2L);
    }

    public static PaymentTransactionCampaign getPaymentTransactionCampaignRandomSampleGenerator() {
        return new PaymentTransactionCampaign()
            .id(longCount.incrementAndGet())
            .paymentTransactionId(longCount.incrementAndGet())
            .cycle(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
