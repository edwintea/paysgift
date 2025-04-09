package com.paysgift.transaction.service.mapper;

import static com.paysgift.transaction.domain.TransactionProductAsserts.*;
import static com.paysgift.transaction.domain.TransactionProductTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionProductMapperTest {

    private TransactionProductMapper transactionProductMapper;

    @BeforeEach
    void setUp() {
        transactionProductMapper = new TransactionProductMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTransactionProductSample1();
        var actual = transactionProductMapper.toEntity(transactionProductMapper.toDto(expected));
        assertTransactionProductAllPropertiesEquals(expected, actual);
    }
}
