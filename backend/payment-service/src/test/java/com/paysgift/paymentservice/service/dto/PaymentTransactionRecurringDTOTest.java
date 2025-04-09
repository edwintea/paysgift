package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionRecurringDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionRecurringDTO.class);
        PaymentTransactionRecurringDTO paymentTransactionRecurringDTO1 = new PaymentTransactionRecurringDTO();
        paymentTransactionRecurringDTO1.setId(1L);
        PaymentTransactionRecurringDTO paymentTransactionRecurringDTO2 = new PaymentTransactionRecurringDTO();
        assertThat(paymentTransactionRecurringDTO1).isNotEqualTo(paymentTransactionRecurringDTO2);
        paymentTransactionRecurringDTO2.setId(paymentTransactionRecurringDTO1.getId());
        assertThat(paymentTransactionRecurringDTO1).isEqualTo(paymentTransactionRecurringDTO2);
        paymentTransactionRecurringDTO2.setId(2L);
        assertThat(paymentTransactionRecurringDTO1).isNotEqualTo(paymentTransactionRecurringDTO2);
        paymentTransactionRecurringDTO1.setId(null);
        assertThat(paymentTransactionRecurringDTO1).isNotEqualTo(paymentTransactionRecurringDTO2);
    }
}
