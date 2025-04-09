package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionSendTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TransactionSend getTransactionSendSample1() {
        return new TransactionSend()
            .id(1L)
            .transactionId(1L)
            .code("code1")
            .pin("pin1")
            .stickerId(1L)
            .senderName("senderName1")
            .message("message1")
            .sendType("sendType1")
            .contactType("contactType1")
            .recepientName("recepientName1")
            .recepientContact("recepientContact1")
            .recepientContactHash("recepientContactHash1")
            .addressLabel("addressLabel1")
            .countryId(1L)
            .provinceId(1L)
            .cityId(1L)
            .districtId(1L)
            .villageId(1L)
            .zipcode("zipcode1")
            .address("address1")
            .courierNote("courierNote1")
            .longitude("longitude1")
            .latitude("latitude1")
            .referenceId("referenceId1")
            .sendBy("sendBy1")
            .statusDelivery("statusDelivery1")
            .statusReason("statusReason1")
            .blibliPackageId("blibliPackageId1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static TransactionSend getTransactionSendSample2() {
        return new TransactionSend()
            .id(2L)
            .transactionId(2L)
            .code("code2")
            .pin("pin2")
            .stickerId(2L)
            .senderName("senderName2")
            .message("message2")
            .sendType("sendType2")
            .contactType("contactType2")
            .recepientName("recepientName2")
            .recepientContact("recepientContact2")
            .recepientContactHash("recepientContactHash2")
            .addressLabel("addressLabel2")
            .countryId(2L)
            .provinceId(2L)
            .cityId(2L)
            .districtId(2L)
            .villageId(2L)
            .zipcode("zipcode2")
            .address("address2")
            .courierNote("courierNote2")
            .longitude("longitude2")
            .latitude("latitude2")
            .referenceId("referenceId2")
            .sendBy("sendBy2")
            .statusDelivery("statusDelivery2")
            .statusReason("statusReason2")
            .blibliPackageId("blibliPackageId2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static TransactionSend getTransactionSendRandomSampleGenerator() {
        return new TransactionSend()
            .id(longCount.incrementAndGet())
            .transactionId(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .pin(UUID.randomUUID().toString())
            .stickerId(longCount.incrementAndGet())
            .senderName(UUID.randomUUID().toString())
            .message(UUID.randomUUID().toString())
            .sendType(UUID.randomUUID().toString())
            .contactType(UUID.randomUUID().toString())
            .recepientName(UUID.randomUUID().toString())
            .recepientContact(UUID.randomUUID().toString())
            .recepientContactHash(UUID.randomUUID().toString())
            .addressLabel(UUID.randomUUID().toString())
            .countryId(longCount.incrementAndGet())
            .provinceId(longCount.incrementAndGet())
            .cityId(longCount.incrementAndGet())
            .districtId(longCount.incrementAndGet())
            .villageId(longCount.incrementAndGet())
            .zipcode(UUID.randomUUID().toString())
            .address(UUID.randomUUID().toString())
            .courierNote(UUID.randomUUID().toString())
            .longitude(UUID.randomUUID().toString())
            .latitude(UUID.randomUUID().toString())
            .referenceId(UUID.randomUUID().toString())
            .sendBy(UUID.randomUUID().toString())
            .statusDelivery(UUID.randomUUID().toString())
            .statusReason(UUID.randomUUID().toString())
            .blibliPackageId(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
