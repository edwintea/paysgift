package com.paysgift.notification.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendEmailDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendEmailDTO.class);
        SendEmailDTO sendEmailDTO1 = new SendEmailDTO();
        sendEmailDTO1.setId(1L);
        SendEmailDTO sendEmailDTO2 = new SendEmailDTO();
        assertThat(sendEmailDTO1).isNotEqualTo(sendEmailDTO2);
        sendEmailDTO2.setId(sendEmailDTO1.getId());
        assertThat(sendEmailDTO1).isEqualTo(sendEmailDTO2);
        sendEmailDTO2.setId(2L);
        assertThat(sendEmailDTO1).isNotEqualTo(sendEmailDTO2);
        sendEmailDTO1.setId(null);
        assertThat(sendEmailDTO1).isNotEqualTo(sendEmailDTO2);
    }
}
