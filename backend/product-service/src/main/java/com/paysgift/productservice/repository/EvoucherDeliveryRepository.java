package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.EvoucherDelivery;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the EvoucherDelivery entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EvoucherDeliveryRepository extends JpaRepository<EvoucherDelivery, Long> {}
