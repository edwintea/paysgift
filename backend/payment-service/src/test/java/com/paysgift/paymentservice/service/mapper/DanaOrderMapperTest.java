package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.DanaOrderAsserts.*;
import static com.paysgift.paymentservice.domain.DanaOrderTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DanaOrderMapperTest {

    private DanaOrderMapper danaOrderMapper;

    @BeforeEach
    void setUp() {
        danaOrderMapper = new DanaOrderMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getDanaOrderSample1();
        var actual = danaOrderMapper.toEntity(danaOrderMapper.toDto(expected));
        assertDanaOrderAllPropertiesEquals(expected, actual);
    }
}
