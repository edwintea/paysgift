package com.paysgift.orderservice.service.mapper;

import static com.paysgift.orderservice.domain.CartDeleteAsserts.*;
import static com.paysgift.orderservice.domain.CartDeleteTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartDeleteMapperTest {

    private CartDeleteMapper cartDeleteMapper;

    @BeforeEach
    void setUp() {
        cartDeleteMapper = new CartDeleteMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCartDeleteSample1();
        var actual = cartDeleteMapper.toEntity(cartDeleteMapper.toDto(expected));
        assertCartDeleteAllPropertiesEquals(expected, actual);
    }
}
