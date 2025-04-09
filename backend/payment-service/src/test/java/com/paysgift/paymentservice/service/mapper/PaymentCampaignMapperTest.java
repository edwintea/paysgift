package com.paysgift.paymentservice.service.mapper;

import static com.paysgift.paymentservice.domain.PaymentCampaignAsserts.*;
import static com.paysgift.paymentservice.domain.PaymentCampaignTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentCampaignMapperTest {

    private PaymentCampaignMapper paymentCampaignMapper;

    @BeforeEach
    void setUp() {
        paymentCampaignMapper = new PaymentCampaignMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentCampaignSample1();
        var actual = paymentCampaignMapper.toEntity(paymentCampaignMapper.toDto(expected));
        assertPaymentCampaignAllPropertiesEquals(expected, actual);
    }
}
