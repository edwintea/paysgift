package com.paysgift.productservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ProductTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Product getProductSample1() {
        return new Product()
            .id(1L)
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
            .qty(1)
            .purchaseQty(1)
            .remainingQty(1)
            .validityPurchase(1)
            .tag("tag1")
            .permalink("permalink1")
            .updatedSync("updatedSync1")
            .createdBy(1L)
            .updatedBy(1L);
    }

    public static Product getProductSample2() {
        return new Product()
            .id(2L)
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
            .qty(2)
            .purchaseQty(2)
            .remainingQty(2)
            .validityPurchase(2)
            .tag("tag2")
            .permalink("permalink2")
            .updatedSync("updatedSync2")
            .createdBy(2L)
            .updatedBy(2L);
    }

    public static Product getProductRandomSampleGenerator() {
        return new Product()
            .id(longCount.incrementAndGet())
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
            .qty(intCount.incrementAndGet())
            .purchaseQty(intCount.incrementAndGet())
            .remainingQty(intCount.incrementAndGet())
            .validityPurchase(intCount.incrementAndGet())
            .tag(UUID.randomUUID().toString())
            .permalink(UUID.randomUUID().toString())
            .updatedSync(UUID.randomUUID().toString())
            .createdBy(longCount.incrementAndGet())
            .updatedBy(longCount.incrementAndGet());
    }
}
