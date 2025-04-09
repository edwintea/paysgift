package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentTransactionRetryingAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentTransactionRetryingTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTransactionRetryingMapperTest {

    private PaymentTransactionRetryingMapper paymentTransactionRetryingMapper;

    @BeforeEach
    void setUp() {
        paymentTransactionRetryingMapper = new PaymentTransactionRetryingMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentTransactionRetryingSample1();
        var actual = paymentTransactionRetryingMapper.toEntity(paymentTransactionRetryingMapper.toDto(expected));
        assertPaymentTransactionRetryingAllPropertiesEquals(expected, actual);
    }
}
