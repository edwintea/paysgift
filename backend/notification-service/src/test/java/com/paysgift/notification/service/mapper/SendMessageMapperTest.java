package com.paysgift.notification.service.mapper;

import static com.paysgift.notification.domain.SendMessageAsserts.*;
import static com.paysgift.notification.domain.SendMessageTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SendMessageMapperTest {

    private SendMessageMapper sendMessageMapper;

    @BeforeEach
    void setUp() {
        sendMessageMapper = new SendMessageMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSendMessageSample1();
        var actual = sendMessageMapper.toEntity(sendMessageMapper.toDto(expected));
        assertSendMessageAllPropertiesEquals(expected, actual);
    }
}
