package com.paysgift.transaction.domain;

import static com.paysgift.transaction.domain.TransactionSendTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionSendTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionSend.class);
        TransactionSend transactionSend1 = getTransactionSendSample1();
        TransactionSend transactionSend2 = new TransactionSend();
        assertThat(transactionSend1).isNotEqualTo(transactionSend2);

        transactionSend2.setId(transactionSend1.getId());
        assertThat(transactionSend1).isEqualTo(transactionSend2);

        transactionSend2 = getTransactionSendSample2();
        assertThat(transactionSend1).isNotEqualTo(transactionSend2);
    }
}
