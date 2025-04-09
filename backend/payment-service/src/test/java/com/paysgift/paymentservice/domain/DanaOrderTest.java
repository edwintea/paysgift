package com.paysgift.paymentservice.domain;

import static com.paysgift.paymentservice.domain.DanaOrderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.paymentservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DanaOrderTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DanaOrder.class);
        DanaOrder danaOrder1 = getDanaOrderSample1();
        DanaOrder danaOrder2 = new DanaOrder();
        assertThat(danaOrder1).isNotEqualTo(danaOrder2);

        danaOrder2.setId(danaOrder1.getId());
        assertThat(danaOrder1).isEqualTo(danaOrder2);

        danaOrder2 = getDanaOrderSample2();
        assertThat(danaOrder1).isNotEqualTo(danaOrder2);
    }
}
