package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaysgiftPromoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaysgiftPromoDTO.class);
        PaysgiftPromoDTO paysgiftPromoDTO1 = new PaysgiftPromoDTO();
        paysgiftPromoDTO1.setId(1L);
        PaysgiftPromoDTO paysgiftPromoDTO2 = new PaysgiftPromoDTO();
        assertThat(paysgiftPromoDTO1).isNotEqualTo(paysgiftPromoDTO2);
        paysgiftPromoDTO2.setId(paysgiftPromoDTO1.getId());
        assertThat(paysgiftPromoDTO1).isEqualTo(paysgiftPromoDTO2);
        paysgiftPromoDTO2.setId(2L);
        assertThat(paysgiftPromoDTO1).isNotEqualTo(paysgiftPromoDTO2);
        paysgiftPromoDTO1.setId(null);
        assertThat(paysgiftPromoDTO1).isNotEqualTo(paysgiftPromoDTO2);
    }
}
