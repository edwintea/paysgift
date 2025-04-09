package com.paysgift.notification.service.mapper;

import static com.paysgift.notification.domain.SendEmailAsserts.*;
import static com.paysgift.notification.domain.SendEmailTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SendEmailMapperTest {

    private SendEmailMapper sendEmailMapper;

    @BeforeEach
    void setUp() {
        sendEmailMapper = new SendEmailMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSendEmailSample1();
        var actual = sendEmailMapper.toEntity(sendEmailMapper.toDto(expected));
        assertSendEmailAllPropertiesEquals(expected, actual);
    }
}
