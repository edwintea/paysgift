package com.paysgift.notification.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendWhatsAppDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendWhatsAppDTO.class);
        SendWhatsAppDTO sendWhatsAppDTO1 = new SendWhatsAppDTO();
        sendWhatsAppDTO1.setId(1L);
        SendWhatsAppDTO sendWhatsAppDTO2 = new SendWhatsAppDTO();
        assertThat(sendWhatsAppDTO1).isNotEqualTo(sendWhatsAppDTO2);
        sendWhatsAppDTO2.setId(sendWhatsAppDTO1.getId());
        assertThat(sendWhatsAppDTO1).isEqualTo(sendWhatsAppDTO2);
        sendWhatsAppDTO2.setId(2L);
        assertThat(sendWhatsAppDTO1).isNotEqualTo(sendWhatsAppDTO2);
        sendWhatsAppDTO1.setId(null);
        assertThat(sendWhatsAppDTO1).isNotEqualTo(sendWhatsAppDTO2);
    }
}
