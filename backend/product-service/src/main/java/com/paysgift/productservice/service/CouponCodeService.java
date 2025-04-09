package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.CouponCodeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.CouponCode}.
 */
public interface CouponCodeService {
    /**
     * Save a couponCode.
     *
     * @param couponCodeDTO the entity to save.
     * @return the persisted entity.
     */
    CouponCodeDTO save(CouponCodeDTO couponCodeDTO);

    /**
     * Updates a couponCode.
     *
     * @param couponCodeDTO the entity to update.
     * @return the persisted entity.
     */
    CouponCodeDTO update(CouponCodeDTO couponCodeDTO);

    /**
     * Partially updates a couponCode.
     *
     * @param couponCodeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CouponCodeDTO> partialUpdate(CouponCodeDTO couponCodeDTO);

    /**
     * Get all the couponCodes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CouponCodeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" couponCode.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CouponCodeDTO> findOne(Long id);

    /**
     * Delete the "id" couponCode.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
