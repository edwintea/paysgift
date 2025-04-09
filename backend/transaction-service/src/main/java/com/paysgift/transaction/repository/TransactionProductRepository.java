package com.paysgift.transaction.repository;

import com.paysgift.transaction.domain.TransactionProduct;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TransactionProduct entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionProductRepository extends JpaRepository<TransactionProduct, Long> {}
