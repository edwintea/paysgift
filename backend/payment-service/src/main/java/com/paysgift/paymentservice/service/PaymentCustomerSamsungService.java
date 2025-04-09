package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentCustomerSamsungDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentCustomerSamsung}.
 */
public interface PaymentCustomerSamsungService {
    /**
     * Save a paymentCustomerSamsung.
     *
     * @param paymentCustomerSamsungDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentCustomerSamsungDTO save(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO);

    /**
     * Updates a paymentCustomerSamsung.
     *
     * @param paymentCustomerSamsungDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentCustomerSamsungDTO update(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO);

    /**
     * Partially updates a paymentCustomerSamsung.
     *
     * @param paymentCustomerSamsungDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentCustomerSamsungDTO> partialUpdate(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO);

    /**
     * Get all the paymentCustomerSamsungs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentCustomerSamsungDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentCustomerSamsung.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentCustomerSamsungDTO> findOne(Long id);

    /**
     * Delete the "id" paymentCustomerSamsung.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
