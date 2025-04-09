package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionCampaignDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionCampaignDTO.class);
        PaymentTransactionCampaignDTO paymentTransactionCampaignDTO1 = new PaymentTransactionCampaignDTO();
        paymentTransactionCampaignDTO1.setId(1L);
        PaymentTransactionCampaignDTO paymentTransactionCampaignDTO2 = new PaymentTransactionCampaignDTO();
        assertThat(paymentTransactionCampaignDTO1).isNotEqualTo(paymentTransactionCampaignDTO2);
        paymentTransactionCampaignDTO2.setId(paymentTransactionCampaignDTO1.getId());
        assertThat(paymentTransactionCampaignDTO1).isEqualTo(paymentTransactionCampaignDTO2);
        paymentTransactionCampaignDTO2.setId(2L);
        assertThat(paymentTransactionCampaignDTO1).isNotEqualTo(paymentTransactionCampaignDTO2);
        paymentTransactionCampaignDTO1.setId(null);
        assertThat(paymentTransactionCampaignDTO1).isNotEqualTo(paymentTransactionCampaignDTO2);
    }
}
