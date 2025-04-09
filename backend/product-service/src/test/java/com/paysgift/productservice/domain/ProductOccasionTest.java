package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.ProductOccasionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductOccasionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductOccasion.class);
        ProductOccasion productOccasion1 = getProductOccasionSample1();
        ProductOccasion productOccasion2 = new ProductOccasion();
        assertThat(productOccasion1).isNotEqualTo(productOccasion2);

        productOccasion2.setId(productOccasion1.getId());
        assertThat(productOccasion1).isEqualTo(productOccasion2);

        productOccasion2 = getProductOccasionSample2();
        assertThat(productOccasion1).isNotEqualTo(productOccasion2);
    }
}
