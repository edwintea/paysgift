package com.paysgift.notification.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SendWhatsAppTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static SendWhatsApp getSendWhatsAppSample1() {
        return new SendWhatsApp()
            .id(1L)
            .countryCode("countryCode1")
            .phoneNumber("phoneNumber1")
            .message("message1")
            .imageUrl("imageUrl1")
            .dateTimeEntry("dateTimeEntry1")
            .responseTxt("responseTxt1")
            .messageId("messageId1")
            .statusMessage("statusMessage1")
            .tableRelation("tableRelation1")
            .tableId("tableId1");
    }

    public static SendWhatsApp getSendWhatsAppSample2() {
        return new SendWhatsApp()
            .id(2L)
            .countryCode("countryCode2")
            .phoneNumber("phoneNumber2")
            .message("message2")
            .imageUrl("imageUrl2")
            .dateTimeEntry("dateTimeEntry2")
            .responseTxt("responseTxt2")
            .messageId("messageId2")
            .statusMessage("statusMessage2")
            .tableRelation("tableRelation2")
            .tableId("tableId2");
    }

    public static SendWhatsApp getSendWhatsAppRandomSampleGenerator() {
        return new SendWhatsApp()
            .id(longCount.incrementAndGet())
            .countryCode(UUID.randomUUID().toString())
            .phoneNumber(UUID.randomUUID().toString())
            .message(UUID.randomUUID().toString())
            .imageUrl(UUID.randomUUID().toString())
            .dateTimeEntry(UUID.randomUUID().toString())
            .responseTxt(UUID.randomUUID().toString())
            .messageId(UUID.randomUUID().toString())
            .statusMessage(UUID.randomUUID().toString())
            .tableRelation(UUID.randomUUID().toString())
            .tableId(UUID.randomUUID().toString());
    }
}
