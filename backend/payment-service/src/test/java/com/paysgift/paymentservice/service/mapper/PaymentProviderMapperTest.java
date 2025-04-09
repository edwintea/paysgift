package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentProviderAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentProviderTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentProviderMapperTest {

    private PaymentProviderMapper paymentProviderMapper;

    @BeforeEach
    void setUp() {
        paymentProviderMapper = new PaymentProviderMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentProviderSample1();
        var actual = paymentProviderMapper.toEntity(paymentProviderMapper.toDto(expected));
        assertPaymentProviderAllPropertiesEquals(expected, actual);
    }
}
