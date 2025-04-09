package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.ProductFavouriteTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductFavouriteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductFavourite.class);
        ProductFavourite productFavourite1 = getProductFavouriteSample1();
        ProductFavourite productFavourite2 = new ProductFavourite();
        assertThat(productFavourite1).isNotEqualTo(productFavourite2);

        productFavourite2.setId(productFavourite1.getId());
        assertThat(productFavourite1).isEqualTo(productFavourite2);

        productFavourite2 = getProductFavouriteSample2();
        assertThat(productFavourite1).isNotEqualTo(productFavourite2);
    }
}
