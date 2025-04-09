package com.paysgift.transaction.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionDownloadDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionDownloadDTO.class);
        TransactionDownloadDTO transactionDownloadDTO1 = new TransactionDownloadDTO();
        transactionDownloadDTO1.setId(1L);
        TransactionDownloadDTO transactionDownloadDTO2 = new TransactionDownloadDTO();
        assertThat(transactionDownloadDTO1).isNotEqualTo(transactionDownloadDTO2);
        transactionDownloadDTO2.setId(transactionDownloadDTO1.getId());
        assertThat(transactionDownloadDTO1).isEqualTo(transactionDownloadDTO2);
        transactionDownloadDTO2.setId(2L);
        assertThat(transactionDownloadDTO1).isNotEqualTo(transactionDownloadDTO2);
        transactionDownloadDTO1.setId(null);
        assertThat(transactionDownloadDTO1).isNotEqualTo(transactionDownloadDTO2);
    }
}
