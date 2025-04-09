package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.PaysgiftPromoInfoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.PaysgiftPromoInfo}.
 */
public interface PaysgiftPromoInfoService {
    /**
     * Save a paysgiftPromoInfo.
     *
     * @param paysgiftPromoInfoDTO the entity to save.
     * @return the persisted entity.
     */
    PaysgiftPromoInfoDTO save(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO);

    /**
     * Updates a paysgiftPromoInfo.
     *
     * @param paysgiftPromoInfoDTO the entity to update.
     * @return the persisted entity.
     */
    PaysgiftPromoInfoDTO update(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO);

    /**
     * Partially updates a paysgiftPromoInfo.
     *
     * @param paysgiftPromoInfoDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaysgiftPromoInfoDTO> partialUpdate(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO);

    /**
     * Get all the paysgiftPromoInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaysgiftPromoInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paysgiftPromoInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaysgiftPromoInfoDTO> findOne(Long id);

    /**
     * Delete the "id" paysgiftPromoInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
