package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentTransactionRecurringDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRecurring}.
 */
public interface PaymentTransactionRecurringService {
    /**
     * Save a paymentTransactionRecurring.
     *
     * @param paymentTransactionRecurringDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTransactionRecurringDTO save(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO);

    /**
     * Updates a paymentTransactionRecurring.
     *
     * @param paymentTransactionRecurringDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTransactionRecurringDTO update(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO);

    /**
     * Partially updates a paymentTransactionRecurring.
     *
     * @param paymentTransactionRecurringDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTransactionRecurringDTO> partialUpdate(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO);

    /**
     * Get all the paymentTransactionRecurrings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentTransactionRecurringDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentTransactionRecurring.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTransactionRecurringDTO> findOne(Long id);

    /**
     * Delete the "id" paymentTransactionRecurring.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
