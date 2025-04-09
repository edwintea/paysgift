package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.ProductOccasion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProductOccasion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductOccasionRepository extends JpaRepository<ProductOccasion, Long> {}
