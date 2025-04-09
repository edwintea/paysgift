package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.PaysgiftPromoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.PaysgiftPromo}.
 */
public interface PaysgiftPromoService {
    /**
     * Save a paysgiftPromo.
     *
     * @param paysgiftPromoDTO the entity to save.
     * @return the persisted entity.
     */
    PaysgiftPromoDTO save(PaysgiftPromoDTO paysgiftPromoDTO);

    /**
     * Updates a paysgiftPromo.
     *
     * @param paysgiftPromoDTO the entity to update.
     * @return the persisted entity.
     */
    PaysgiftPromoDTO update(PaysgiftPromoDTO paysgiftPromoDTO);

    /**
     * Partially updates a paysgiftPromo.
     *
     * @param paysgiftPromoDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaysgiftPromoDTO> partialUpdate(PaysgiftPromoDTO paysgiftPromoDTO);

    /**
     * Get all the paysgiftPromos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaysgiftPromoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paysgiftPromo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaysgiftPromoDTO> findOne(Long id);

    /**
     * Delete the "id" paysgiftPromo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
