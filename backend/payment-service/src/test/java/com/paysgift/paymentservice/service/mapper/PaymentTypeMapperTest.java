package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentTypeAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentTypeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTypeMapperTest {

    private PaymentTypeMapper paymentTypeMapper;

    @BeforeEach
    void setUp() {
        paymentTypeMapper = new PaymentTypeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentTypeSample1();
        var actual = paymentTypeMapper.toEntity(paymentTypeMapper.toDto(expected));
        assertPaymentTypeAllPropertiesEquals(expected, actual);
    }
}
