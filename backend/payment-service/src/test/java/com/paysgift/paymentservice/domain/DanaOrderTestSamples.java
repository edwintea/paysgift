package com.paysgift.paymentservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DanaOrderTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static DanaOrder getDanaOrderSample1() {
        return new DanaOrder()
            .id(1L)
            .version("version1")
            .functionName("functionName1")
            .reqMsgId("reqMsgId1")
            .requestId("requestId1")
            .orderId("orderId1")
            .code("code1")
            .status("status1")
            .message("message1")
            .productId("productId1")
            .issuanceId("issuanceId1")
            .voucherCode("voucherCode1")
            .voucherPin("voucherPin1")
            .extendInfo("extendInfo1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static DanaOrder getDanaOrderSample2() {
        return new DanaOrder()
            .id(2L)
            .version("version2")
            .functionName("functionName2")
            .reqMsgId("reqMsgId2")
            .requestId("requestId2")
            .orderId("orderId2")
            .code("code2")
            .status("status2")
            .message("message2")
            .productId("productId2")
            .issuanceId("issuanceId2")
            .voucherCode("voucherCode2")
            .voucherPin("voucherPin2")
            .extendInfo("extendInfo2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static DanaOrder getDanaOrderRandomSampleGenerator() {
        return new DanaOrder()
            .id(longCount.incrementAndGet())
            .version(UUID.randomUUID().toString())
            .functionName(UUID.randomUUID().toString())
            .reqMsgId(UUID.randomUUID().toString())
            .requestId(UUID.randomUUID().toString())
            .orderId(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .status(UUID.randomUUID().toString())
            .message(UUID.randomUUID().toString())
            .productId(UUID.randomUUID().toString())
            .issuanceId(UUID.randomUUID().toString())
            .voucherCode(UUID.randomUUID().toString())
            .voucherPin(UUID.randomUUID().toString())
            .extendInfo(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
