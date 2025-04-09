package com.paysgift.transaction.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionManualDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionManualDTO.class);
        TransactionManualDTO transactionManualDTO1 = new TransactionManualDTO();
        transactionManualDTO1.setId(1L);
        TransactionManualDTO transactionManualDTO2 = new TransactionManualDTO();
        assertThat(transactionManualDTO1).isNotEqualTo(transactionManualDTO2);
        transactionManualDTO2.setId(transactionManualDTO1.getId());
        assertThat(transactionManualDTO1).isEqualTo(transactionManualDTO2);
        transactionManualDTO2.setId(2L);
        assertThat(transactionManualDTO1).isNotEqualTo(transactionManualDTO2);
        transactionManualDTO1.setId(null);
        assertThat(transactionManualDTO1).isNotEqualTo(transactionManualDTO2);
    }
}
