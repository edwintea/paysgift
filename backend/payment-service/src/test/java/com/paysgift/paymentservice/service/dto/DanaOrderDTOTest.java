package com.paysgift.paymentservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DanaOrderDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanaOrderDTO.class);
        DanaOrderDTO danaOrderDTO1 = new DanaOrderDTO();
        danaOrderDTO1.setId(1L);
        DanaOrderDTO danaOrderDTO2 = new DanaOrderDTO();
        assertThat(danaOrderDTO1).isNotEqualTo(danaOrderDTO2);
        danaOrderDTO2.setId(danaOrderDTO1.getId());
        assertThat(danaOrderDTO1).isEqualTo(danaOrderDTO2);
        danaOrderDTO2.setId(2L);
        assertThat(danaOrderDTO1).isNotEqualTo(danaOrderDTO2);
        danaOrderDTO1.setId(null);
        assertThat(danaOrderDTO1).isNotEqualTo(danaOrderDTO2);
    }
}
