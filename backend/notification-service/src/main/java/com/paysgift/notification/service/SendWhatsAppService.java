package com.paysgift.notification.service;

import com.paysgift.notification.service.dto.SendWhatsAppDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.notification.domain.SendWhatsApp}.
 */
public interface SendWhatsAppService {
    /**
     * Save a sendWhatsApp.
     *
     * @param sendWhatsAppDTO the entity to save.
     * @return the persisted entity.
     */
    SendWhatsAppDTO save(SendWhatsAppDTO sendWhatsAppDTO);

    /**
     * Updates a sendWhatsApp.
     *
     * @param sendWhatsAppDTO the entity to update.
     * @return the persisted entity.
     */
    SendWhatsAppDTO update(SendWhatsAppDTO sendWhatsAppDTO);

    /**
     * Partially updates a sendWhatsApp.
     *
     * @param sendWhatsAppDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SendWhatsAppDTO> partialUpdate(SendWhatsAppDTO sendWhatsAppDTO);

    /**
     * Get all the sendWhatsApps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SendWhatsAppDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sendWhatsApp.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SendWhatsAppDTO> findOne(Long id);

    /**
     * Delete the "id" sendWhatsApp.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
