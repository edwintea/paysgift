package com.paysgift.notification.domain;

import static com.paysgift.notification.domain.SendMessageTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendMessageTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendMessage.class);
        SendMessage sendMessage1 = getSendMessageSample1();
        SendMessage sendMessage2 = new SendMessage();
        assertThat(sendMessage1).isNotEqualTo(sendMessage2);

        sendMessage2.setId(sendMessage1.getId());
        assertThat(sendMessage1).isEqualTo(sendMessage2);

        sendMessage2 = getSendMessageSample2();
        assertThat(sendMessage1).isNotEqualTo(sendMessage2);
    }
}
