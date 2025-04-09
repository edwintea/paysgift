package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentTransactionCampaignDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionCampaign}.
 */
public interface PaymentTransactionCampaignService {
    /**
     * Save a paymentTransactionCampaign.
     *
     * @param paymentTransactionCampaignDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTransactionCampaignDTO save(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO);

    /**
     * Updates a paymentTransactionCampaign.
     *
     * @param paymentTransactionCampaignDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTransactionCampaignDTO update(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO);

    /**
     * Partially updates a paymentTransactionCampaign.
     *
     * @param paymentTransactionCampaignDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTransactionCampaignDTO> partialUpdate(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO);

    /**
     * Get all the paymentTransactionCampaigns.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentTransactionCampaignDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentTransactionCampaign.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTransactionCampaignDTO> findOne(Long id);

    /**
     * Delete the "id" paymentTransactionCampaign.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
