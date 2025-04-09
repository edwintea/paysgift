package com.paysgift.transaction.service.mapper;

import static com.paysgift.transaction.domain.TransactionDownloadAsserts.*;
import static com.paysgift.transaction.domain.TransactionDownloadTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionDownloadMapperTest {

    private TransactionDownloadMapper transactionDownloadMapper;

    @BeforeEach
    void setUp() {
        transactionDownloadMapper = new TransactionDownloadMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTransactionDownloadSample1();
        var actual = transactionDownloadMapper.toEntity(transactionDownloadMapper.toDto(expected));
        assertTransactionDownloadAllPropertiesEquals(expected, actual);
    }
}
