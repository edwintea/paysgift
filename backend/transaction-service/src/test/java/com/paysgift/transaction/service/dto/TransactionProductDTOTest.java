package com.paysgift.transaction.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.paysgift.transaction.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TransactionProductDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionProductDTO.class);
        TransactionProductDTO transactionProductDTO1 = new TransactionProductDTO();
        transactionProductDTO1.setId(1L);
        TransactionProductDTO transactionProductDTO2 = new TransactionProductDTO();
        assertThat(transactionProductDTO1).isNotEqualTo(transactionProductDTO2);
        transactionProductDTO2.setId(transactionProductDTO1.getId());
        assertThat(transactionProductDTO1).isEqualTo(transactionProductDTO2);
        transactionProductDTO2.setId(2L);
        assertThat(transactionProductDTO1).isNotEqualTo(transactionProductDTO2);
        transactionProductDTO1.setId(null);
        assertThat(transactionProductDTO1).isNotEqualTo(transactionProductDTO2);
    }
}
