package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentProviderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentProviderTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentProvider.class);
        PaymentProvider paymentProvider1 = getPaymentProviderSample1();
        PaymentProvider paymentProvider2 = new PaymentProvider();
        assertThat(paymentProvider1).isNotEqualTo(paymentProvider2);

        paymentProvider2.setId(paymentProvider1.getId());
        assertThat(paymentProvider1).isEqualTo(paymentProvider2);

        paymentProvider2 = getPaymentProviderSample2();
        assertThat(paymentProvider1).isNotEqualTo(paymentProvider2);
    }
}
