package com.paysgift.transaction.service;

import com.paysgift.transaction.service.dto.TransactionSendDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.transaction.domain.TransactionSend}.
 */
public interface TransactionSendService {
    /**
     * Save a transactionSend.
     *
     * @param transactionSendDTO the entity to save.
     * @return the persisted entity.
     */
    TransactionSendDTO save(TransactionSendDTO transactionSendDTO);

    /**
     * Updates a transactionSend.
     *
     * @param transactionSendDTO the entity to update.
     * @return the persisted entity.
     */
    TransactionSendDTO update(TransactionSendDTO transactionSendDTO);

    /**
     * Partially updates a transactionSend.
     *
     * @param transactionSendDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TransactionSendDTO> partialUpdate(TransactionSendDTO transactionSendDTO);

    /**
     * Get all the transactionSends.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TransactionSendDTO> findAll(Pageable pageable);

    /**
     * Get the "id" transactionSend.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TransactionSendDTO> findOne(Long id);

    /**
     * Delete the "id" transactionSend.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
