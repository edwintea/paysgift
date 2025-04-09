package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentCampaignTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentCampaignTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentCampaign.class);
        PaymentCampaign paymentCampaign1 = getPaymentCampaignSample1();
        PaymentCampaign paymentCampaign2 = new PaymentCampaign();
        assertThat(paymentCampaign1).isNotEqualTo(paymentCampaign2);

        paymentCampaign2.setId(paymentCampaign1.getId());
        assertThat(paymentCampaign1).isEqualTo(paymentCampaign2);

        paymentCampaign2 = getPaymentCampaignSample2();
        assertThat(paymentCampaign1).isNotEqualTo(paymentCampaign2);
    }
}
