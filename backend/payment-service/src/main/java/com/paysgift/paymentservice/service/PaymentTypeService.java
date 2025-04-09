package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentTypeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentType}.
 */
public interface PaymentTypeService {
    /**
     * Save a paymentType.
     *
     * @param paymentTypeDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO);

    /**
     * Updates a paymentType.
     *
     * @param paymentTypeDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTypeDTO update(PaymentTypeDTO paymentTypeDTO);

    /**
     * Partially updates a paymentType.
     *
     * @param paymentTypeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTypeDTO> partialUpdate(PaymentTypeDTO paymentTypeDTO);

    /**
     * Get all the paymentTypes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentTypeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTypeDTO> findOne(Long id);

    /**
     * Delete the "id" paymentType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
