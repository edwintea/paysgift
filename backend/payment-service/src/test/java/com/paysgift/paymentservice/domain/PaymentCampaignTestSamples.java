package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentCampaignTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static PaymentCampaign getPaymentCampaignSample1() {
        return new PaymentCampaign().id(1L).campaignId(1L).freeMonth(1).createdBy(1L).updatedAt(1L).updatedBy(1L);
    }

    public static PaymentCampaign getPaymentCampaignSample2() {
        return new PaymentCampaign().id(2L).campaignId(2L).freeMonth(2).createdBy(2L).updatedAt(2L).updatedBy(2L);
    }

    public static PaymentCampaign getPaymentCampaignRandomSampleGenerator() {
        return new PaymentCampaign()
            .id(longCount.incrementAndGet())
            .campaignId(longCount.incrementAndGet())
            .freeMonth(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedAt(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
