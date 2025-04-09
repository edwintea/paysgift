package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTransactionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static PaymentTransaction getPaymentTransactionSample1() {
        return new PaymentTransaction()
            .id(1L)
            .status("status1")
            .paymentProviderId(1L)
            .paymentListId(1L)
            .orderId(1L)
            .orderNo("orderNo1")
            .invoiceId("invoiceId1")
            .referenceId("referenceId1")
            .clientId(1L)
            .paymentCode("paymentCode1")
            .paymentDeeplink("paymentDeeplink1")
            .paymentObj("paymentObj1")
            .notes("notes1")
            .sgiUid("sgiUid1")
            .customerName("customerName1")
            .customerEmail("customerEmail1")
            .customerMobileNumber("customerMobileNumber1")
            .totalRecurring(1)
            .retryTotal(1)
            .retryInterval(1)
            .cycleActive(1)
            .mode("mode1")
            .modeInterval("modeInterval1")
            .sendCallbackAttempt(1)
            .sendEmailAttempt(1)
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static PaymentTransaction getPaymentTransactionSample2() {
        return new PaymentTransaction()
            .id(2L)
            .status("status2")
            .paymentProviderId(2L)
            .paymentListId(2L)
            .orderId(2L)
            .orderNo("orderNo2")
            .invoiceId("invoiceId2")
            .referenceId("referenceId2")
            .clientId(2L)
            .paymentCode("paymentCode2")
            .paymentDeeplink("paymentDeeplink2")
            .paymentObj("paymentObj2")
            .notes("notes2")
            .sgiUid("sgiUid2")
            .customerName("customerName2")
            .customerEmail("customerEmail2")
            .customerMobileNumber("customerMobileNumber2")
            .totalRecurring(2)
            .retryTotal(2)
            .retryInterval(2)
            .cycleActive(2)
            .mode("mode2")
            .modeInterval("modeInterval2")
            .sendCallbackAttempt(2)
            .sendEmailAttempt(2)
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static PaymentTransaction getPaymentTransactionRandomSampleGenerator() {
        return new PaymentTransaction()
            .id(longCount.incrementAndGet())
            .status(UUID.randomUUID().toString())
            .paymentProviderId(longCount.incrementAndGet())
            .paymentListId(longCount.incrementAndGet())
            .orderId(longCount.incrementAndGet())
            .orderNo(UUID.randomUUID().toString())
            .invoiceId(UUID.randomUUID().toString())
            .referenceId(UUID.randomUUID().toString())
            .clientId(longCount.incrementAndGet())
            .paymentCode(UUID.randomUUID().toString())
            .paymentDeeplink(UUID.randomUUID().toString())
            .paymentObj(UUID.randomUUID().toString())
            .notes(UUID.randomUUID().toString())
            .sgiUid(UUID.randomUUID().toString())
            .customerName(UUID.randomUUID().toString())
            .customerEmail(UUID.randomUUID().toString())
            .customerMobileNumber(UUID.randomUUID().toString())
            .totalRecurring(intCount.incrementAndGet())
            .retryTotal(intCount.incrementAndGet())
            .retryInterval(intCount.incrementAndGet())
            .cycleActive(intCount.incrementAndGet())
            .mode(UUID.randomUUID().toString())
            .modeInterval(UUID.randomUUID().toString())
            .sendCallbackAttempt(intCount.incrementAndGet())
            .sendEmailAttempt(intCount.incrementAndGet())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
