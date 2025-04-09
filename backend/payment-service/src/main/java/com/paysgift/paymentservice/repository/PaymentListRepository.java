package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentList;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Long> {}
