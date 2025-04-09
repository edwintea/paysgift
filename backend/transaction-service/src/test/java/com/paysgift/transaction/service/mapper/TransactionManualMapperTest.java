package com.paysgift.transaction.service.mapper;

import static com.paysgift.transaction.domain.TransactionManualAsserts.*;
import static com.paysgift.transaction.domain.TransactionManualTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionManualMapperTest {

    private TransactionManualMapper transactionManualMapper;

    @BeforeEach
    void setUp() {
        transactionManualMapper = new TransactionManualMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTransactionManualSample1();
        var actual = transactionManualMapper.toEntity(transactionManualMapper.toDto(expected));
        assertTransactionManualAllPropertiesEquals(expected, actual);
    }
}
