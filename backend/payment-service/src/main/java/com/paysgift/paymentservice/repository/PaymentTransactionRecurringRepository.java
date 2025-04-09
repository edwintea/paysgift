package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentTransactionRecurring;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentTransactionRecurring entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentTransactionRecurringRepository extends JpaRepository<PaymentTransactionRecurring, Long> {}
