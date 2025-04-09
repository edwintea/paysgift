package com.paysgift.notification.domain;

import static com.paysgift.notification.domain.SendEmailTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendEmailTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendEmail.class);
        SendEmail sendEmail1 = getSendEmailSample1();
        SendEmail sendEmail2 = new SendEmail();
        assertThat(sendEmail1).isNotEqualTo(sendEmail2);

        sendEmail2.setId(sendEmail1.getId());
        assertThat(sendEmail1).isEqualTo(sendEmail2);

        sendEmail2 = getSendEmailSample2();
        assertThat(sendEmail1).isNotEqualTo(sendEmail2);
    }
}
