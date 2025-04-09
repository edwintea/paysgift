package com.paysgift.notification.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SendEmailTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static SendEmail getSendEmailSample1() {
        return new SendEmail()
            .id(1L)
            .mailTo("mailTo1")
            .mailToName("mailToName1")
            .subject("subject1")
            .body("body1")
            .attached1("attached11")
            .attachedUnlink1("attachedUnlink11")
            .attached2("attached21")
            .attachedUnlink2("attachedUnlink21")
            .attached3("attached31")
            .attachedUnlink3("attachedUnlink31")
            .mailFrom("mailFrom1")
            .mailFromName("mailFromName1")
            .info("info1")
            .mailCc("mailCc1")
            .mailCcName("mailCcName1")
            .tableRelation("tableRelation1")
            .tableId("tableId1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static SendEmail getSendEmailSample2() {
        return new SendEmail()
            .id(2L)
            .mailTo("mailTo2")
            .mailToName("mailToName2")
            .subject("subject2")
            .body("body2")
            .attached1("attached12")
            .attachedUnlink1("attachedUnlink12")
            .attached2("attached22")
            .attachedUnlink2("attachedUnlink22")
            .attached3("attached32")
            .attachedUnlink3("attachedUnlink32")
            .mailFrom("mailFrom2")
            .mailFromName("mailFromName2")
            .info("info2")
            .mailCc("mailCc2")
            .mailCcName("mailCcName2")
            .tableRelation("tableRelation2")
            .tableId("tableId2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static SendEmail getSendEmailRandomSampleGenerator() {
        return new SendEmail()
            .id(longCount.incrementAndGet())
            .mailTo(UUID.randomUUID().toString())
            .mailToName(UUID.randomUUID().toString())
            .subject(UUID.randomUUID().toString())
            .body(UUID.randomUUID().toString())
            .attached1(UUID.randomUUID().toString())
            .attachedUnlink1(UUID.randomUUID().toString())
            .attached2(UUID.randomUUID().toString())
            .attachedUnlink2(UUID.randomUUID().toString())
            .attached3(UUID.randomUUID().toString())
            .attachedUnlink3(UUID.randomUUID().toString())
            .mailFrom(UUID.randomUUID().toString())
            .mailFromName(UUID.randomUUID().toString())
            .info(UUID.randomUUID().toString())
            .mailCc(UUID.randomUUID().toString())
            .mailCcName(UUID.randomUUID().toString())
            .tableRelation(UUID.randomUUID().toString())
            .tableId(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
