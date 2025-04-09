package com.paysgift.transaction.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionProductTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static TransactionProduct getTransactionProductSample1() {
        return new TransactionProduct()
            .id(1L)
            .transactionId(1L)
            .transactionSendId(1L)
            .productId(1L)
            .countryId(1L)
            .brandId(1L)
            .code("code1")
            .parentCode("parentCode1")
            .skuCode("skuCode1")
            .name("name1")
            .nameEn("nameEn1")
            .description("description1")
            .descriptionEn("descriptionEn1")
            .tnc("tnc1")
            .tncEn("tncEn1")
            .howToClaim("howToClaim1")
            .howToClaimEn("howToClaimEn1")
            .image("image1")
            .voucherLink("voucherLink1")
            .voucherCode("voucherCode1")
            .voucherPin("voucherPin1")
            .voucherIssuance("voucherIssuance1")
            .voucherReference("voucherReference1")
            .referenceNumber("referenceNumber1")
            .errorCode("errorCode1")
            .errorReason("errorReason1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static TransactionProduct getTransactionProductSample2() {
        return new TransactionProduct()
            .id(2L)
            .transactionId(2L)
            .transactionSendId(2L)
            .productId(2L)
            .countryId(2L)
            .brandId(2L)
            .code("code2")
            .parentCode("parentCode2")
            .skuCode("skuCode2")
            .name("name2")
            .nameEn("nameEn2")
            .description("description2")
            .descriptionEn("descriptionEn2")
            .tnc("tnc2")
            .tncEn("tncEn2")
            .howToClaim("howToClaim2")
            .howToClaimEn("howToClaimEn2")
            .image("image2")
            .voucherLink("voucherLink2")
            .voucherCode("voucherCode2")
            .voucherPin("voucherPin2")
            .voucherIssuance("voucherIssuance2")
            .voucherReference("voucherReference2")
            .referenceNumber("referenceNumber2")
            .errorCode("errorCode2")
            .errorReason("errorReason2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static TransactionProduct getTransactionProductRandomSampleGenerator() {
        return new TransactionProduct()
            .id(longCount.incrementAndGet())
            .transactionId(longCount.incrementAndGet())
            .transactionSendId(longCount.incrementAndGet())
            .productId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .brandId(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .parentCode(UUID.randomUUID().toString())
            .skuCode(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .nameEn(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .descriptionEn(UUID.randomUUID().toString())
            .tnc(UUID.randomUUID().toString())
            .tncEn(UUID.randomUUID().toString())
            .howToClaim(UUID.randomUUID().toString())
            .howToClaimEn(UUID.randomUUID().toString())
            .image(UUID.randomUUID().toString())
            .voucherLink(UUID.randomUUID().toString())
            .voucherCode(UUID.randomUUID().toString())
            .voucherPin(UUID.randomUUID().toString())
            .voucherIssuance(UUID.randomUUID().toString())
            .voucherReference(UUID.randomUUID().toString())
            .referenceNumber(UUID.randomUUID().toString())
            .errorCode(UUID.randomUUID().toString())
            .errorReason(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
