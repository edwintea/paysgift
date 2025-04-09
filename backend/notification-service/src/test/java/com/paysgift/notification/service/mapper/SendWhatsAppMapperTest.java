package com.paysgift.notification.service.mapper;

import static com.paysgift.notification.domain.SendWhatsAppAsserts.*;
import static com.paysgift.notification.domain.SendWhatsAppTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SendWhatsAppMapperTest {

    private SendWhatsAppMapper sendWhatsAppMapper;

    @BeforeEach
    void setUp() {
        sendWhatsAppMapper = new SendWhatsAppMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSendWhatsAppSample1();
        var actual = sendWhatsAppMapper.toEntity(sendWhatsAppMapper.toDto(expected));
        assertSendWhatsAppAllPropertiesEquals(expected, actual);
    }
}
