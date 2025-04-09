package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.CouponCodeAsserts.*;
import static com.paysgift.productservice.domain.CouponCodeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CouponCodeMapperTest {

    private CouponCodeMapper couponCodeMapper;

    @BeforeEach
    void setUp() {
        couponCodeMapper = new CouponCodeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCouponCodeSample1();
        var actual = couponCodeMapper.toEntity(couponCodeMapper.toDto(expected));
        assertCouponCodeAllPropertiesEquals(expected, actual);
    }
}
