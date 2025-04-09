package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.CouponCodeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CouponCodeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CouponCode.class);
        CouponCode couponCode1 = getCouponCodeSample1();
        CouponCode couponCode2 = new CouponCode();
        assertThat(couponCode1).isNotEqualTo(couponCode2);

        couponCode2.setId(couponCode1.getId());
        assertThat(couponCode1).isEqualTo(couponCode2);

        couponCode2 = getCouponCodeSample2();
        assertThat(couponCode1).isNotEqualTo(couponCode2);
    }
}
