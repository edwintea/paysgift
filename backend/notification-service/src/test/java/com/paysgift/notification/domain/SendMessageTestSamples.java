package com.paysgift.notification.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SendMessageTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static SendMessage getSendMessageSample1() {
        return new SendMessage()
            .id(1L)
            .phoneNumber("phoneNumber1")
            .message("message1")
            .responseText("responseText1")
            .messageId("messageId1")
            .statusMessage("statusMessage1")
            .tableRelation("tableRelation1")
            .tableId("tableId1");
    }

    public static SendMessage getSendMessageSample2() {
        return new SendMessage()
            .id(2L)
            .phoneNumber("phoneNumber2")
            .message("message2")
            .responseText("responseText2")
            .messageId("messageId2")
            .statusMessage("statusMessage2")
            .tableRelation("tableRelation2")
            .tableId("tableId2");
    }

    public static SendMessage getSendMessageRandomSampleGenerator() {
        return new SendMessage()
            .id(longCount.incrementAndGet())
            .phoneNumber(UUID.randomUUID().toString())
            .message(UUID.randomUUID().toString())
            .responseText(UUID.randomUUID().toString())
            .messageId(UUID.randomUUID().toString())
            .statusMessage(UUID.randomUUID().toString())
            .tableRelation(UUID.randomUUID().toString())
            .tableId(UUID.randomUUID().toString());
    }
}
