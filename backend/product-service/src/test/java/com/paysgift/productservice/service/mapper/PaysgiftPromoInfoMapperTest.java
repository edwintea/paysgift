package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.PaysgiftPromoInfoAsserts.*;
import static com.paysgift.productservice.domain.PaysgiftPromoInfoTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaysgiftPromoInfoMapperTest {

    private PaysgiftPromoInfoMapper paysgiftPromoInfoMapper;

    @BeforeEach
    void setUp() {
        paysgiftPromoInfoMapper = new PaysgiftPromoInfoMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaysgiftPromoInfoSample1();
        var actual = paysgiftPromoInfoMapper.toEntity(paysgiftPromoInfoMapper.toDto(expected));
        assertPaysgiftPromoInfoAllPropertiesEquals(expected, actual);
    }
}
