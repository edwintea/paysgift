package com.paysgift.transaction.domain;

import static com.paysgift.transaction.domain.TransactionLogTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionLogTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionLog.class);
        TransactionLog transactionLog1 = getTransactionLogSample1();
        TransactionLog transactionLog2 = new TransactionLog();
        assertThat(transactionLog1).isNotEqualTo(transactionLog2);

        transactionLog2.setId(transactionLog1.getId());
        assertThat(transactionLog1).isEqualTo(transactionLog2);

        transactionLog2 = getTransactionLogSample2();
        assertThat(transactionLog1).isNotEqualTo(transactionLog2);
    }
}
