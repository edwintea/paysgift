package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentCustomerSamsungDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentCustomerSamsungDTO.class);
        PaymentCustomerSamsungDTO paymentCustomerSamsungDTO1 = new PaymentCustomerSamsungDTO();
        paymentCustomerSamsungDTO1.setId(1L);
        PaymentCustomerSamsungDTO paymentCustomerSamsungDTO2 = new PaymentCustomerSamsungDTO();
        assertThat(paymentCustomerSamsungDTO1).isNotEqualTo(paymentCustomerSamsungDTO2);
        paymentCustomerSamsungDTO2.setId(paymentCustomerSamsungDTO1.getId());
        assertThat(paymentCustomerSamsungDTO1).isEqualTo(paymentCustomerSamsungDTO2);
        paymentCustomerSamsungDTO2.setId(2L);
        assertThat(paymentCustomerSamsungDTO1).isNotEqualTo(paymentCustomerSamsungDTO2);
        paymentCustomerSamsungDTO1.setId(null);
        assertThat(paymentCustomerSamsungDTO1).isNotEqualTo(paymentCustomerSamsungDTO2);
    }
}
