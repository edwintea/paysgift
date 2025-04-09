package com.paysgift.orderservice.repository;

import com.paysgift.orderservice.domain.CartDelete;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CartDelete entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartDeleteRepository extends JpaRepository<CartDelete, Long> {}
