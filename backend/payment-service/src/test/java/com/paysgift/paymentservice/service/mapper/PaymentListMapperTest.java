package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentListAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentListTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentListMapperTest {

    private PaymentListMapper paymentListMapper;

    @BeforeEach
    void setUp() {
        paymentListMapper = new PaymentListMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentListSample1();
        var actual = paymentListMapper.toEntity(paymentListMapper.toDto(expected));
        assertPaymentListAllPropertiesEquals(expected, actual);
    }
}
