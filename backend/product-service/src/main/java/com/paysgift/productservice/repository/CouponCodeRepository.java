package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.CouponCode;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CouponCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CouponCodeRepository extends JpaRepository<CouponCode, Long> {}
