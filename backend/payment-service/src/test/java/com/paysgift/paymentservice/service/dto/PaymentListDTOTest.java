package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentListDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentListDTO.class);
        PaymentListDTO paymentListDTO1 = new PaymentListDTO();
        paymentListDTO1.setId(1L);
        PaymentListDTO paymentListDTO2 = new PaymentListDTO();
        assertThat(paymentListDTO1).isNotEqualTo(paymentListDTO2);
        paymentListDTO2.setId(paymentListDTO1.getId());
        assertThat(paymentListDTO1).isEqualTo(paymentListDTO2);
        paymentListDTO2.setId(2L);
        assertThat(paymentListDTO1).isNotEqualTo(paymentListDTO2);
        paymentListDTO1.setId(null);
        assertThat(paymentListDTO1).isNotEqualTo(paymentListDTO2);
    }
}
