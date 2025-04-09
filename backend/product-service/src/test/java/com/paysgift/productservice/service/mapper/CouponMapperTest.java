package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.CouponAsserts.*;
import static com.paysgift.productservice.domain.CouponTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CouponMapperTest {

    private CouponMapper couponMapper;

    @BeforeEach
    void setUp() {
        couponMapper = new CouponMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCouponSample1();
        var actual = couponMapper.toEntity(couponMapper.toDto(expected));
        assertCouponAllPropertiesEquals(expected, actual);
    }
}
