package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentTransactionRetryingDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRetrying}.
 */
public interface PaymentTransactionRetryingService {
    /**
     * Save a paymentTransactionRetrying.
     *
     * @param paymentTransactionRetryingDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTransactionRetryingDTO save(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO);

    /**
     * Updates a paymentTransactionRetrying.
     *
     * @param paymentTransactionRetryingDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTransactionRetryingDTO update(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO);

    /**
     * Partially updates a paymentTransactionRetrying.
     *
     * @param paymentTransactionRetryingDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTransactionRetryingDTO> partialUpdate(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO);

    /**
     * Get all the paymentTransactionRetryings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentTransactionRetryingDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentTransactionRetrying.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTransactionRetryingDTO> findOne(Long id);

    /**
     * Delete the "id" paymentTransactionRetrying.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
