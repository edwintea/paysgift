package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentTransactionCampaign;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentTransactionCampaign entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentTransactionCampaignRepository extends JpaRepository<PaymentTransactionCampaign, Long> {}
