package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.EvoucherDeliveryDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.EvoucherDelivery}.
 */
public interface EvoucherDeliveryService {
    /**
     * Save a evoucherDelivery.
     *
     * @param evoucherDeliveryDTO the entity to save.
     * @return the persisted entity.
     */
    EvoucherDeliveryDTO save(EvoucherDeliveryDTO evoucherDeliveryDTO);

    /**
     * Updates a evoucherDelivery.
     *
     * @param evoucherDeliveryDTO the entity to update.
     * @return the persisted entity.
     */
    EvoucherDeliveryDTO update(EvoucherDeliveryDTO evoucherDeliveryDTO);

    /**
     * Partially updates a evoucherDelivery.
     *
     * @param evoucherDeliveryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<EvoucherDeliveryDTO> partialUpdate(EvoucherDeliveryDTO evoucherDeliveryDTO);

    /**
     * Get all the evoucherDeliveries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EvoucherDeliveryDTO> findAll(Pageable pageable);

    /**
     * Get the "id" evoucherDelivery.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EvoucherDeliveryDTO> findOne(Long id);

    /**
     * Delete the "id" evoucherDelivery.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
