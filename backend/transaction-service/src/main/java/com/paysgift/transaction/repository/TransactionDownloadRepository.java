package com.paysgift.transaction.repository;

import com.paysgift.transaction.domain.TransactionDownload;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TransactionDownload entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionDownloadRepository extends JpaRepository<TransactionDownload, Long> {}
