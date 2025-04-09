package com.paysgift.productservice.domain;

import static com.paysgift.productservice.domain.ProductImageTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.productservice.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductImageTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductImage.class);
        ProductImage productImage1 = getProductImageSample1();
        ProductImage productImage2 = new ProductImage();
        assertThat(productImage1).isNotEqualTo(productImage2);

        productImage2.setId(productImage1.getId());
        assertThat(productImage1).isEqualTo(productImage2);

        productImage2 = getProductImageSample2();
        assertThat(productImage1).isNotEqualTo(productImage2);
    }
}
