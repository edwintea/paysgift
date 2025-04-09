package com.paysgift.transaction.repository;

import com.paysgift.transaction.domain.TransactionManual;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TransactionManual entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionManualRepository extends JpaRepository<TransactionManual, Long> {}
