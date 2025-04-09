package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.ProductFavouriteAsserts.*;
import static com.paysgift.productservice.domain.ProductFavouriteTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductFavouriteMapperTest {

    private ProductFavouriteMapper productFavouriteMapper;

    @BeforeEach
    void setUp() {
        productFavouriteMapper = new ProductFavouriteMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getProductFavouriteSample1();
        var actual = productFavouriteMapper.toEntity(productFavouriteMapper.toDto(expected));
        assertProductFavouriteAllPropertiesEquals(expected, actual);
    }
}
