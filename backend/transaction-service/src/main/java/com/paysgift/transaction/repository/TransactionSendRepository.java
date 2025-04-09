package com.paysgift.transaction.repository;

import com.paysgift.transaction.domain.TransactionSend;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TransactionSend entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionSendRepository extends JpaRepository<TransactionSend, Long> {}
