package com.paysgift.transaction.domain;

import static com.paysgift.transaction.domain.TransactionDownloadTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionDownloadTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionDownload.class);
        TransactionDownload transactionDownload1 = getTransactionDownloadSample1();
        TransactionDownload transactionDownload2 = new TransactionDownload();
        assertThat(transactionDownload1).isNotEqualTo(transactionDownload2);

        transactionDownload2.setId(transactionDownload1.getId());
        assertThat(transactionDownload1).isEqualTo(transactionDownload2);

        transactionDownload2 = getTransactionDownloadSample2();
        assertThat(transactionDownload1).isNotEqualTo(transactionDownload2);
    }
}
