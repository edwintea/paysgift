package com.paysgift.transaction.domain;

import static com.paysgift.transaction.domain.TransactionProductTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionProductTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionProduct.class);
        TransactionProduct transactionProduct1 = getTransactionProductSample1();
        TransactionProduct transactionProduct2 = new TransactionProduct();
        assertThat(transactionProduct1).isNotEqualTo(transactionProduct2);

        transactionProduct2.setId(transactionProduct1.getId());
        assertThat(transactionProduct1).isEqualTo(transactionProduct2);

        transactionProduct2 = getTransactionProductSample2();
        assertThat(transactionProduct1).isNotEqualTo(transactionProduct2);
    }
}
