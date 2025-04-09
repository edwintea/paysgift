package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.PaysgiftPromoAsserts.*;
import static com.paysgift.productservice.domain.PaysgiftPromoTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaysgiftPromoMapperTest {

    private PaysgiftPromoMapper paysgiftPromoMapper;

    @BeforeEach
    void setUp() {
        paysgiftPromoMapper = new PaysgiftPromoMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaysgiftPromoSample1();
        var actual = paysgiftPromoMapper.toEntity(paysgiftPromoMapper.toDto(expected));
        assertPaysgiftPromoAllPropertiesEquals(expected, actual);
    }
}
