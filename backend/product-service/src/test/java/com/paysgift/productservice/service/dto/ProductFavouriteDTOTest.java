package com.paysgift.productservice.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductFavouriteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductFavouriteDTO.class);
        ProductFavouriteDTO productFavouriteDTO1 = new ProductFavouriteDTO();
        productFavouriteDTO1.setId(1L);
        ProductFavouriteDTO productFavouriteDTO2 = new ProductFavouriteDTO();
        assertThat(productFavouriteDTO1).isNotEqualTo(productFavouriteDTO2);
        productFavouriteDTO2.setId(productFavouriteDTO1.getId());
        assertThat(productFavouriteDTO1).isEqualTo(productFavouriteDTO2);
        productFavouriteDTO2.setId(2L);
        assertThat(productFavouriteDTO1).isNotEqualTo(productFavouriteDTO2);
        productFavouriteDTO1.setId(null);
        assertThat(productFavouriteDTO1).isNotEqualTo(productFavouriteDTO2);
    }
}
