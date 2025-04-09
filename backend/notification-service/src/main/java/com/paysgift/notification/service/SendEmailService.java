package com.paysgift.notification.service;

import com.paysgift.notification.service.dto.SendEmailDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.notification.domain.SendEmail}.
 */
public interface SendEmailService {
    /**
     * Save a sendEmail.
     *
     * @param sendEmailDTO the entity to save.
     * @return the persisted entity.
     */
    SendEmailDTO save(SendEmailDTO sendEmailDTO);

    /**
     * Updates a sendEmail.
     *
     * @param sendEmailDTO the entity to update.
     * @return the persisted entity.
     */
    SendEmailDTO update(SendEmailDTO sendEmailDTO);

    /**
     * Partially updates a sendEmail.
     *
     * @param sendEmailDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SendEmailDTO> partialUpdate(SendEmailDTO sendEmailDTO);

    /**
     * Get all the sendEmails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SendEmailDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sendEmail.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SendEmailDTO> findOne(Long id);

    /**
     * Delete the "id" sendEmail.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
