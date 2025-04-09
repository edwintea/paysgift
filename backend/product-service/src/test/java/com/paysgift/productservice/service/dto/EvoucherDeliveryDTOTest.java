package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EvoucherDeliveryDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EvoucherDeliveryDTO.class);
        EvoucherDeliveryDTO evoucherDeliveryDTO1 = new EvoucherDeliveryDTO();
        evoucherDeliveryDTO1.setId(1L);
        EvoucherDeliveryDTO evoucherDeliveryDTO2 = new EvoucherDeliveryDTO();
        assertThat(evoucherDeliveryDTO1).isNotEqualTo(evoucherDeliveryDTO2);
        evoucherDeliveryDTO2.setId(evoucherDeliveryDTO1.getId());
        assertThat(evoucherDeliveryDTO1).isEqualTo(evoucherDeliveryDTO2);
        evoucherDeliveryDTO2.setId(2L);
        assertThat(evoucherDeliveryDTO1).isNotEqualTo(evoucherDeliveryDTO2);
        evoucherDeliveryDTO1.setId(null);
        assertThat(evoucherDeliveryDTO1).isNotEqualTo(evoucherDeliveryDTO2);
    }
}
