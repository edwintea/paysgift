package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductOccasionDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductOccasionDTO.class);
        ProductOccasionDTO productOccasionDTO1 = new ProductOccasionDTO();
        productOccasionDTO1.setId(1L);
        ProductOccasionDTO productOccasionDTO2 = new ProductOccasionDTO();
        assertThat(productOccasionDTO1).isNotEqualTo(productOccasionDTO2);
        productOccasionDTO2.setId(productOccasionDTO1.getId());
        assertThat(productOccasionDTO1).isEqualTo(productOccasionDTO2);
        productOccasionDTO2.setId(2L);
        assertThat(productOccasionDTO1).isNotEqualTo(productOccasionDTO2);
        productOccasionDTO1.setId(null);
        assertThat(productOccasionDTO1).isNotEqualTo(productOccasionDTO2);
    }
}
