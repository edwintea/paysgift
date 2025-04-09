package com.paysgift.transaction.service.mapper;

import static com.paysgift.transaction.domain.TransactionLogAsserts.*;
import static com.paysgift.transaction.domain.TransactionLogTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionLogMapperTest {

    private TransactionLogMapper transactionLogMapper;

    @BeforeEach
    void setUp() {
        transactionLogMapper = new TransactionLogMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTransactionLogSample1();
        var actual = transactionLogMapper.toEntity(transactionLogMapper.toDto(expected));
        assertTransactionLogAllPropertiesEquals(expected, actual);
    }
}
