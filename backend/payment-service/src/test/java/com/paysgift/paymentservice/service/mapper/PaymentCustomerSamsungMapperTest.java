package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentCustomerSamsungAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentCustomerSamsungTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentCustomerSamsungMapperTest {

    private PaymentCustomerSamsungMapper paymentCustomerSamsungMapper;

    @BeforeEach
    void setUp() {
        paymentCustomerSamsungMapper = new PaymentCustomerSamsungMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentCustomerSamsungSample1();
        var actual = paymentCustomerSamsungMapper.toEntity(paymentCustomerSamsungMapper.toDto(expected));
        assertPaymentCustomerSamsungAllPropertiesEquals(expected, actual);
    }
}
