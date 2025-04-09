package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentTransactionRetrying;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentTransactionRetrying entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentTransactionRetryingRepository extends JpaRepository<PaymentTransactionRetrying, Long> {}
