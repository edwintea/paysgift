package com.paysgift.paymentservice.service;

import com.paysgift.paymentservice.service.dto.PaymentCampaignDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.paymentservice.domain.PaymentCampaign}.
 */
public interface PaymentCampaignService {
    /**
     * Save a paymentCampaign.
     *
     * @param paymentCampaignDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentCampaignDTO save(PaymentCampaignDTO paymentCampaignDTO);

    /**
     * Updates a paymentCampaign.
     *
     * @param paymentCampaignDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentCampaignDTO update(PaymentCampaignDTO paymentCampaignDTO);

    /**
     * Partially updates a paymentCampaign.
     *
     * @param paymentCampaignDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentCampaignDTO> partialUpdate(PaymentCampaignDTO paymentCampaignDTO);

    /**
     * Get all the paymentCampaigns.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentCampaignDTO> findAll(Pageable pageable);

    /**
     * Get the "id" paymentCampaign.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentCampaignDTO> findOne(Long id);

    /**
     * Delete the "id" paymentCampaign.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
