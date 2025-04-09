package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentTransactionRetryingTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionRetryingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionRetrying.class);
        PaymentTransactionRetrying paymentTransactionRetrying1 = getPaymentTransactionRetryingSample1();
        PaymentTransactionRetrying paymentTransactionRetrying2 = new PaymentTransactionRetrying();
        assertThat(paymentTransactionRetrying1).isNotEqualTo(paymentTransactionRetrying2);

        paymentTransactionRetrying2.setId(paymentTransactionRetrying1.getId());
        assertThat(paymentTransactionRetrying1).isEqualTo(paymentTransactionRetrying2);

        paymentTransactionRetrying2 = getPaymentTransactionRetryingSample2();
        assertThat(paymentTransactionRetrying1).isNotEqualTo(paymentTransactionRetrying2);
    }
}
