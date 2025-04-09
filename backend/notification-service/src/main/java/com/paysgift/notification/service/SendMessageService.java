package com.paysgift.notification.service;

import com.paysgift.notification.service.dto.SendMessageDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.notification.domain.SendMessage}.
 */
public interface SendMessageService {
    /**
     * Save a sendMessage.
     *
     * @param sendMessageDTO the entity to save.
     * @return the persisted entity.
     */
    SendMessageDTO save(SendMessageDTO sendMessageDTO);

    /**
     * Updates a sendMessage.
     *
     * @param sendMessageDTO the entity to update.
     * @return the persisted entity.
     */
    SendMessageDTO update(SendMessageDTO sendMessageDTO);

    /**
     * Partially updates a sendMessage.
     *
     * @param sendMessageDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SendMessageDTO> partialUpdate(SendMessageDTO sendMessageDTO);

    /**
     * Get all the sendMessages.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SendMessageDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sendMessage.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SendMessageDTO> findOne(Long id);

    /**
     * Delete the "id" sendMessage.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
