package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentCustomerSamsung;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentCustomerSamsung entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentCustomerSamsungRepository extends JpaRepository<PaymentCustomerSamsung, Long> {}
