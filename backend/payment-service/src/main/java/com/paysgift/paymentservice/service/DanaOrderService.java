package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.DanaOrderDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.DanaOrder}.
 */
public interface DanaOrderService {
    /**
     * Save a danaOrder.
     *
     * @param danaOrderDTO the entity to save.
     * @return the persisted entity.
     */
    DanaOrderDTO save(DanaOrderDTO danaOrderDTO);

    /**
     * Updates a danaOrder.
     *
     * @param danaOrderDTO the entity to update.
     * @return the persisted entity.
     */
    DanaOrderDTO update(DanaOrderDTO danaOrderDTO);

    /**
     * Partially updates a danaOrder.
     *
     * @param danaOrderDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DanaOrderDTO> partialUpdate(DanaOrderDTO danaOrderDTO);

    /**
     * Get all the danaOrders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DanaOrderDTO> findAll(Pageable pageable);

    /**
     * Get the "id" danaOrder.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DanaOrderDTO> findOne(Long id);

    /**
     * Delete the "id" danaOrder.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
