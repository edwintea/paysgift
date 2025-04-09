package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.PaymentCampaign;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaymentCampaign entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentCampaignRepository extends JpaRepository<PaymentCampaign, Long> {}
