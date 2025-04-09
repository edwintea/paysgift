package com.paysgift.transaction.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionSendDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionSendDTO.class);
        TransactionSendDTO transactionSendDTO1 = new TransactionSendDTO();
        transactionSendDTO1.setId(1L);
        TransactionSendDTO transactionSendDTO2 = new TransactionSendDTO();
        assertThat(transactionSendDTO1).isNotEqualTo(transactionSendDTO2);
        transactionSendDTO2.setId(transactionSendDTO1.getId());
        assertThat(transactionSendDTO1).isEqualTo(transactionSendDTO2);
        transactionSendDTO2.setId(2L);
        assertThat(transactionSendDTO1).isNotEqualTo(transactionSendDTO2);
        transactionSendDTO1.setId(null);
        assertThat(transactionSendDTO1).isNotEqualTo(transactionSendDTO2);
    }
}
