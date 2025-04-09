package com.paysgift.transaction.service.mapper;

import static com.paysgift.transaction.domain.TransactionSendAsserts.*;
import static com.paysgift.transaction.domain.TransactionSendTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionSendMapperTest {

    private TransactionSendMapper transactionSendMapper;

    @BeforeEach
    void setUp() {
        transactionSendMapper = new TransactionSendMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTransactionSendSample1();
        var actual = transactionSendMapper.toEntity(transactionSendMapper.toDto(expected));
        assertTransactionSendAllPropertiesEquals(expected, actual);
    }
}
