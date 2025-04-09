package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionRetryingDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransactionRetryingDTO.class);
        PaymentTransactionRetryingDTO paymentTransactionRetryingDTO1 = new PaymentTransactionRetryingDTO();
        paymentTransactionRetryingDTO1.setId(1L);
        PaymentTransactionRetryingDTO paymentTransactionRetryingDTO2 = new PaymentTransactionRetryingDTO();
        assertThat(paymentTransactionRetryingDTO1).isNotEqualTo(paymentTransactionRetryingDTO2);
        paymentTransactionRetryingDTO2.setId(paymentTransactionRetryingDTO1.getId());
        assertThat(paymentTransactionRetryingDTO1).isEqualTo(paymentTransactionRetryingDTO2);
        paymentTransactionRetryingDTO2.setId(2L);
        assertThat(paymentTransactionRetryingDTO1).isNotEqualTo(paymentTransactionRetryingDTO2);
        paymentTransactionRetryingDTO1.setId(null);
        assertThat(paymentTransactionRetryingDTO1).isNotEqualTo(paymentTransactionRetryingDTO2);
    }
}
