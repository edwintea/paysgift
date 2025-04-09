package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentCampaignDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentCampaignDTO.class);
        PaymentCampaignDTO paymentCampaignDTO1 = new PaymentCampaignDTO();
        paymentCampaignDTO1.setId(1L);
        PaymentCampaignDTO paymentCampaignDTO2 = new PaymentCampaignDTO();
        assertThat(paymentCampaignDTO1).isNotEqualTo(paymentCampaignDTO2);
        paymentCampaignDTO2.setId(paymentCampaignDTO1.getId());
        assertThat(paymentCampaignDTO1).isEqualTo(paymentCampaignDTO2);
        paymentCampaignDTO2.setId(2L);
        assertThat(paymentCampaignDTO1).isNotEqualTo(paymentCampaignDTO2);
        paymentCampaignDTO1.setId(null);
        assertThat(paymentCampaignDTO1).isNotEqualTo(paymentCampaignDTO2);
    }
}
