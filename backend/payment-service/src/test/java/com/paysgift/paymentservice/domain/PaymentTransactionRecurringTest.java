package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentTransactionRecurringTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionRecurringTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionRecurring.class);
        PaymentTransactionRecurring paymentTransactionRecurring1 = getPaymentTransactionRecurringSample1();
        PaymentTransactionRecurring paymentTransactionRecurring2 = new PaymentTransactionRecurring();
        assertThat(paymentTransactionRecurring1).isNotEqualTo(paymentTransactionRecurring2);

        paymentTransactionRecurring2.setId(paymentTransactionRecurring1.getId());
        assertThat(paymentTransactionRecurring1).isEqualTo(paymentTransactionRecurring2);

        paymentTransactionRecurring2 = getPaymentTransactionRecurringSample2();
        assertThat(paymentTransactionRecurring1).isNotEqualTo(paymentTransactionRecurring2);
    }
}
