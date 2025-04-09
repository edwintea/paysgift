package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.PaysgiftPromo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PaysgiftPromo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaysgiftPromoRepository extends JpaRepository<PaysgiftPromo, Long> {}
