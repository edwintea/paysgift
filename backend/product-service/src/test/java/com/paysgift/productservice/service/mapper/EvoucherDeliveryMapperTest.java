package com.paysgift.productservice.service.mapper;

import static com.paysgift.productservice.domain.EvoucherDeliveryAsserts.*;
import static com.paysgift.productservice.domain.EvoucherDeliveryTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvoucherDeliveryMapperTest {

    private EvoucherDeliveryMapper evoucherDeliveryMapper;

    @BeforeEach
    void setUp() {
        evoucherDeliveryMapper = new EvoucherDeliveryMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getEvoucherDeliverySample1();
        var actual = evoucherDeliveryMapper.toEntity(evoucherDeliveryMapper.toDto(expected));
        assertEvoucherDeliveryAllPropertiesEquals(expected, actual);
    }
}
