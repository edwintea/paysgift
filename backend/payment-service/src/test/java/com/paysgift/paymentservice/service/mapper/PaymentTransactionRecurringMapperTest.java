package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentTransactionRecurringAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentTransactionRecurringTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTransactionRecurringMapperTest {

    private PaymentTransactionRecurringMapper paymentTransactionRecurringMapper;

    @BeforeEach
    void setUp() {
        paymentTransactionRecurringMapper = new PaymentTransactionRecurringMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentTransactionRecurringSample1();
        var actual = paymentTransactionRecurringMapper.toEntity(paymentTransactionRecurringMapper.toDto(expected));
        assertPaymentTransactionRecurringAllPropertiesEquals(expected, actual);
    }
}
