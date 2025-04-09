package com.paysgift.transaction.service;

import com.paysgift.transaction.service.dto.TransactionManualDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.transaction.domain.TransactionManual}.
 */
public interface TransactionManualService {
    /**
     * Save a transactionManual.
     *
     * @param transactionManualDTO the entity to save.
     * @return the persisted entity.
     */
    TransactionManualDTO save(TransactionManualDTO transactionManualDTO);

    /**
     * Updates a transactionManual.
     *
     * @param transactionManualDTO the entity to update.
     * @return the persisted entity.
     */
    TransactionManualDTO update(TransactionManualDTO transactionManualDTO);

    /**
     * Partially updates a transactionManual.
     *
     * @param transactionManualDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TransactionManualDTO> partialUpdate(TransactionManualDTO transactionManualDTO);

    /**
     * Get all the transactionManuals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TransactionManualDTO> findAll(Pageable pageable);

    /**
     * Get the "id" transactionManual.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TransactionManualDTO> findOne(Long id);

    /**
     * Delete the "id" transactionManual.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
