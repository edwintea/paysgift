package com.paysgift.orderservice.service.mapper;

import static com.paysgift.orderservice.domain.CartAsserts.*;
import static com.paysgift.orderservice.domain.CartTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartMapperTest {

    private CartMapper cartMapper;

    @BeforeEach
    void setUp() {
        cartMapper = new CartMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCartSample1();
        var actual = cartMapper.toEntity(cartMapper.toDto(expected));
        assertCartAllPropertiesEquals(expected, actual);
    }
}
