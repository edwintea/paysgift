package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.PaymentListTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentListTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentList.class);
        PaymentList paymentList1 = getPaymentListSample1();
        PaymentList paymentList2 = new PaymentList();
        assertThat(paymentList1).isNotEqualTo(paymentList2);

        paymentList2.setId(paymentList1.getId());
        assertThat(paymentList1).isEqualTo(paymentList2);

        paymentList2 = getPaymentListSample2();
        assertThat(paymentList1).isNotEqualTo(paymentList2);
    }
}
