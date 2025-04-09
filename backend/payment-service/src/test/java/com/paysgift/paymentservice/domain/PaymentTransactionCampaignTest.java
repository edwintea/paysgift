package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentTransactionCampaignTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionCampaignTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionCampaign.class);
        PaymentTransactionCampaign paymentTransactionCampaign1 = getPaymentTransactionCampaignSample1();
        PaymentTransactionCampaign paymentTransactionCampaign2 = new PaymentTransactionCampaign();
        assertThat(paymentTransactionCampaign1).isNotEqualTo(paymentTransactionCampaign2);

        paymentTransactionCampaign2.setId(paymentTransactionCampaign1.getId());
        assertThat(paymentTransactionCampaign1).isEqualTo(paymentTransactionCampaign2);

        paymentTransactionCampaign2 = getPaymentTransactionCampaignSample2();
        assertThat(paymentTransactionCampaign1).isNotEqualTo(paymentTransactionCampaign2);
    }
}
