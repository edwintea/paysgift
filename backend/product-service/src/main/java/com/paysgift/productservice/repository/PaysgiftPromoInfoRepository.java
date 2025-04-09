package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.PaysgiftPromoInfo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaysgiftPromoInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaysgiftPromoInfoRepository extends JpaRepository<PaysgiftPromoInfo, Long> {}
