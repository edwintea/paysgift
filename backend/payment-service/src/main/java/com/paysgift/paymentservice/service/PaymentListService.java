package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentListDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentList}.
 */
public interface PaymentListService {
    /**
     * Save a paymentList.
     *
     * @param paymentListDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentListDTO save(PaymentListDTO paymentListDTO);

    /**
     * Updates a paymentList.
     *
     * @param paymentListDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentListDTO update(PaymentListDTO paymentListDTO);

    /**
     * Partially updates a paymentList.
     *
     * @param paymentListDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentListDTO> partialUpdate(PaymentListDTO paymentListDTO);

    /**
     * Get all the paymentLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentListDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentList.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentListDTO> findOne(Long id);

    /**
     * Delete the "id" paymentList.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
