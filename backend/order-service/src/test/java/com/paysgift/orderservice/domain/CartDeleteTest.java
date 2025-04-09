package com.paysgift.orderservice.domain;

import static com.paysgift.orderservice.domain.CartDeleteTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.orderservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CartDeleteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CartDelete.class);
        CartDelete cartDelete1 = getCartDeleteSample1();
        CartDelete cartDelete2 = new CartDelete();
        assertThat(cartDelete1).isNotEqualTo(cartDelete2);

        cartDelete2.setId(cartDelete1.getId());
        assertThat(cartDelete1).isEqualTo(cartDelete2);

        cartDelete2 = getCartDeleteSample2();
        assertThat(cartDelete1).isNotEqualTo(cartDelete2);
    }
}
