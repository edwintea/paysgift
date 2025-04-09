package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaysgiftPromoInfoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaysgiftPromoInfoDTO.class);
        PaysgiftPromoInfoDTO paysgiftPromoInfoDTO1 = new PaysgiftPromoInfoDTO();
        paysgiftPromoInfoDTO1.setId(1L);
        PaysgiftPromoInfoDTO paysgiftPromoInfoDTO2 = new PaysgiftPromoInfoDTO();
        assertThat(paysgiftPromoInfoDTO1).isNotEqualTo(paysgiftPromoInfoDTO2);
        paysgiftPromoInfoDTO2.setId(paysgiftPromoInfoDTO1.getId());
        assertThat(paysgiftPromoInfoDTO1).isEqualTo(paysgiftPromoInfoDTO2);
        paysgiftPromoInfoDTO2.setId(2L);
        assertThat(paysgiftPromoInfoDTO1).isNotEqualTo(paysgiftPromoInfoDTO2);
        paysgiftPromoInfoDTO1.setId(null);
        assertThat(paysgiftPromoInfoDTO1).isNotEqualTo(paysgiftPromoInfoDTO2);
    }
}
