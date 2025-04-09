package com.paysgift.transaction.domain;

import static com.paysgift.transaction.domain.TransactionManualTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionManualTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionManual.class);
        TransactionManual transactionManual1 = getTransactionManualSample1();
        TransactionManual transactionManual2 = new TransactionManual();
        assertThat(transactionManual1).isNotEqualTo(transactionManual2);

        transactionManual2.setId(transactionManual1.getId());
        assertThat(transactionManual1).isEqualTo(transactionManual2);

        transactionManual2 = getTransactionManualSample2();
        assertThat(transactionManual1).isNotEqualTo(transactionManual2);
    }
}
