package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.PaysgiftPromoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaysgiftPromoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaysgiftPromo.class);
        PaysgiftPromo paysgiftPromo1 = getPaysgiftPromoSample1();
        PaysgiftPromo paysgiftPromo2 = new PaysgiftPromo();
        assertThat(paysgiftPromo1).isNotEqualTo(paysgiftPromo2);

        paysgiftPromo2.setId(paysgiftPromo1.getId());
        assertThat(paysgiftPromo1).isEqualTo(paysgiftPromo2);

        paysgiftPromo2 = getPaysgiftPromoSample2();
        assertThat(paysgiftPromo1).isNotEqualTo(paysgiftPromo2);
    }
}
