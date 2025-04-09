package com.paysgift.transaction.service;

import com.paysgift.transaction.service.dto.TransactionProductDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.transaction.domain.TransactionProduct}.
 */
public interface TransactionProductService {
    /**
     * Save a transactionProduct.
     *
     * @param transactionProductDTO the entity to save.
     * @return the persisted entity.
     */
    TransactionProductDTO save(TransactionProductDTO transactionProductDTO);

    /**
     * Updates a transactionProduct.
     *
     * @param transactionProductDTO the entity to update.
     * @return the persisted entity.
     */
    TransactionProductDTO update(TransactionProductDTO transactionProductDTO);

    /**
     * Partially updates a transactionProduct.
     *
     * @param transactionProductDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TransactionProductDTO> partialUpdate(TransactionProductDTO transactionProductDTO);

    /**
     * Get all the transactionProducts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TransactionProductDTO> findAll(Pageable pageable);

    /**
     * Get the "id" transactionProduct.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TransactionProductDTO> findOne(Long id);

    /**
     * Delete the "id" transactionProduct.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
