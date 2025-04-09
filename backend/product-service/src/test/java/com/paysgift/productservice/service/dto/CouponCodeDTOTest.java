package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CouponCodeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CouponCodeDTO.class);
        CouponCodeDTO couponCodeDTO1 = new CouponCodeDTO();
        couponCodeDTO1.setId(1L);
        CouponCodeDTO couponCodeDTO2 = new CouponCodeDTO();
        assertThat(couponCodeDTO1).isNotEqualTo(couponCodeDTO2);
        couponCodeDTO2.setId(couponCodeDTO1.getId());
        assertThat(couponCodeDTO1).isEqualTo(couponCodeDTO2);
        couponCodeDTO2.setId(2L);
        assertThat(couponCodeDTO1).isNotEqualTo(couponCodeDTO2);
        couponCodeDTO1.setId(null);
        assertThat(couponCodeDTO1).isNotEqualTo(couponCodeDTO2);
    }
}
