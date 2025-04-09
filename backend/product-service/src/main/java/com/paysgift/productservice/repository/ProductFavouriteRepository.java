package com.paysgift.productservice.repository;

import com.paysgift.productservice.domain.ProductFavourite;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProductFavourite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductFavouriteRepository extends JpaRepository<ProductFavourite, Long> {}
