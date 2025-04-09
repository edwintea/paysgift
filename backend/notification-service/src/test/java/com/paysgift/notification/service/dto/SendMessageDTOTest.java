package com.paysgift.notification.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.notification.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SendMessageDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SendMessageDTO.class);
        SendMessageDTO sendMessageDTO1 = new SendMessageDTO();
        sendMessageDTO1.setId(1L);
        SendMessageDTO sendMessageDTO2 = new SendMessageDTO();
        assertThat(sendMessageDTO1).isNotEqualTo(sendMessageDTO2);
        sendMessageDTO2.setId(sendMessageDTO1.getId());
        assertThat(sendMessageDTO1).isEqualTo(sendMessageDTO2);
        sendMessageDTO2.setId(2L);
        assertThat(sendMessageDTO1).isNotEqualTo(sendMessageDTO2);
        sendMessageDTO1.setId(null);
        assertThat(sendMessageDTO1).isNotEqualTo(sendMessageDTO2);
    }
}
