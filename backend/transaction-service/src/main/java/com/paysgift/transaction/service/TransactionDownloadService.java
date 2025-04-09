package com.paysgift.transaction.service;

import com.paysgift.transaction.service.dto.TransactionDownloadDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.transaction.domain.TransactionDownload}.
 */
public interface TransactionDownloadService {
    /**
     * Save a transactionDownload.
     *
     * @param transactionDownloadDTO the entity to save.
     * @return the persisted entity.
     */
    TransactionDownloadDTO save(TransactionDownloadDTO transactionDownloadDTO);

    /**
     * Updates a transactionDownload.
     *
     * @param transactionDownloadDTO the entity to update.
     * @return the persisted entity.
     */
    TransactionDownloadDTO update(TransactionDownloadDTO transactionDownloadDTO);

    /**
     * Partially updates a transactionDownload.
     *
     * @param transactionDownloadDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TransactionDownloadDTO> partialUpdate(TransactionDownloadDTO transactionDownloadDTO);

    /**
     * Get all the transactionDownloads.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TransactionDownloadDTO> findAll(Pageable pageable);

    /**
     * Get the "id" transactionDownload.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TransactionDownloadDTO> findOne(Long id);

    /**
     * Delete the "id" transactionDownload.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
