package com.paysgift.orderservice.service;

import com.paysgift.orderservice.service.dto.CartDeleteDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.orderservice.domain.CartDelete}.
 */
public interface CartDeleteService {
    /**
     * Save a cartDelete.
     *
     * @param cartDeleteDTO the entity to save.
     * @return the persisted entity.
     */
    CartDeleteDTO save(CartDeleteDTO cartDeleteDTO);

    /**
     * Updates a cartDelete.
     *
     * @param cartDeleteDTO the entity to update.
     * @return the persisted entity.
     */
    CartDeleteDTO update(CartDeleteDTO cartDeleteDTO);

    /**
     * Partially updates a cartDelete.
     *
     * @param cartDeleteDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CartDeleteDTO> partialUpdate(CartDeleteDTO cartDeleteDTO);

    /**
     * Get all the cartDeletes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CartDeleteDTO> findAll(Pageable pageable);

    /**
     * Get the "id" cartDelete.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CartDeleteDTO> findOne(Long id);

    /**
     * Delete the "id" cartDelete.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
