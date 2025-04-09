package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentTransactionCampaignAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentTransactionCampaignTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTransactionCampaignMapperTest {

    private PaymentTransactionCampaignMapper paymentTransactionCampaignMapper;

    @BeforeEach
    void setUp() {
        paymentTransactionCampaignMapper = new PaymentTransactionCampaignMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentTransactionCampaignSample1();
        var actual = paymentTransactionCampaignMapper.toEntity(paymentTransactionCampaignMapper.toDto(expected));
        assertPaymentTransactionCampaignAllPropertiesEquals(expected, actual);
    }
}
