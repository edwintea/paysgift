package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.PaysgiftPromoInfoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaysgiftPromoInfoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaysgiftPromoInfo.class);
        PaysgiftPromoInfo paysgiftPromoInfo1 = getPaysgiftPromoInfoSample1();
        PaysgiftPromoInfo paysgiftPromoInfo2 = new PaysgiftPromoInfo();
        assertThat(paysgiftPromoInfo1).isNotEqualTo(paysgiftPromoInfo2);

        paysgiftPromoInfo2.setId(paysgiftPromoInfo1.getId());
        assertThat(paysgiftPromoInfo1).isEqualTo(paysgiftPromoInfo2);

        paysgiftPromoInfo2 = getPaysgiftPromoInfoSample2();
        assertThat(paysgiftPromoInfo1).isNotEqualTo(paysgiftPromoInfo2);
    }
}
