package com.paysgift.paymentservice.repository;

import com.paysgift.paymentservice.domain.DanaOrder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the DanaOrder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DanaOrderRepository extends JpaRepository<DanaOrder, Long> {}
