package com.paysgift.orderservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.orderservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CartDeleteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CartDeleteDTO.class);
        CartDeleteDTO cartDeleteDTO1 = new CartDeleteDTO();
        cartDeleteDTO1.setId(1L);
        CartDeleteDTO cartDeleteDTO2 = new CartDeleteDTO();
        assertThat(cartDeleteDTO1).isNotEqualTo(cartDeleteDTO2);
        cartDeleteDTO2.setId(cartDeleteDTO1.getId());
        assertThat(cartDeleteDTO1).isEqualTo(cartDeleteDTO2);
        cartDeleteDTO2.setId(2L);
        assertThat(cartDeleteDTO1).isNotEqualTo(cartDeleteDTO2);
        cartDeleteDTO1.setId(null);
        assertThat(cartDeleteDTO1).isNotEqualTo(cartDeleteDTO2);
    }
}
