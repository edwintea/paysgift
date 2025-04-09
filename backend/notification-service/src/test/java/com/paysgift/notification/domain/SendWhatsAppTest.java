package com.paysgift.notification.domain;

import static com.paysgift.notification.domain.SendWhatsAppTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendWhatsAppTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendWhatsApp.class);
        SendWhatsApp sendWhatsApp1 = getSendWhatsAppSample1();
        SendWhatsApp sendWhatsApp2 = new SendWhatsApp();
        assertThat(sendWhatsApp1).isNotEqualTo(sendWhatsApp2);

        sendWhatsApp2.setId(sendWhatsApp1.getId());
        assertThat(sendWhatsApp1).isEqualTo(sendWhatsApp2);

        sendWhatsApp2 = getSendWhatsAppSample2();
        assertThat(sendWhatsApp1).isNotEqualTo(sendWhatsApp2);
    }
}
