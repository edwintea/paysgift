package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentCustomerSamsungTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentCustomerSamsungTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentCustomerSamsung.class);
        PaymentCustomerSamsung paymentCustomerSamsung1 = getPaymentCustomerSamsungSample1();
        PaymentCustomerSamsung paymentCustomerSamsung2 = new PaymentCustomerSamsung();
        assertThat(paymentCustomerSamsung1).isNotEqualTo(paymentCustomerSamsung2);

        paymentCustomerSamsung2.setId(paymentCustomerSamsung1.getId());
        assertThat(paymentCustomerSamsung1).isEqualTo(paymentCustomerSamsung2);

        paymentCustomerSamsung2 = getPaymentCustomerSamsungSample2();
        assertThat(paymentCustomerSamsung1).isNotEqualTo(paymentCustomerSamsung2);
    }
}
