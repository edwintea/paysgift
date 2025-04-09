package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.ProductOccasionAsserts.*;
import static com.paysgift.productservice.domain.ProductOccasionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductOccasionMapperTest {

    private ProductOccasionMapper productOccasionMapper;

    @BeforeEach
    void setUp() {
        productOccasionMapper = new ProductOccasionMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getProductOccasionSample1();
        var actual = productOccasionMapper.toEntity(productOccasionMapper.toDto(expected));
        assertProductOccasionAllPropertiesEquals(expected, actual);
    }
}
