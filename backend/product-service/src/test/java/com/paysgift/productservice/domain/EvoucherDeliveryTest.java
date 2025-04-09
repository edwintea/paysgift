package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.EvoucherDeliveryTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EvoucherDeliveryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EvoucherDelivery.class);
        EvoucherDelivery evoucherDelivery1 = getEvoucherDeliverySample1();
        EvoucherDelivery evoucherDelivery2 = new EvoucherDelivery();
        assertThat(evoucherDelivery1).isNotEqualTo(evoucherDelivery2);

        evoucherDelivery2.setId(evoucherDelivery1.getId());
        assertThat(evoucherDelivery1).isEqualTo(evoucherDelivery2);

        evoucherDelivery2 = getEvoucherDeliverySample2();
        assertThat(evoucherDelivery1).isNotEqualTo(evoucherDelivery2);
    }
}
