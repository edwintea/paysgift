package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentTypeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTypeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentType.class);
        PaymentType paymentType1 = getPaymentTypeSample1();
        PaymentType paymentType2 = new PaymentType();
        assertThat(paymentType1).isNotEqualTo(paymentType2);

        paymentType2.setId(paymentType1.getId());
        assertThat(paymentType1).isEqualTo(paymentType2);

        paymentType2 = getPaymentTypeSample2();
        assertThat(paymentType1).isNotEqualTo(paymentType2);
    }
}
