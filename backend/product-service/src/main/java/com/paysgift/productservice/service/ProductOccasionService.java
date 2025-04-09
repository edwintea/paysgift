package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.ProductOccasionDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.ProductOccasion}.
 */
public interface ProductOccasionService {
    /**
     * Save a productOccasion.
     *
     * @param productOccasionDTO the entity to save.
     * @return the persisted entity.
     */
    ProductOccasionDTO save(ProductOccasionDTO productOccasionDTO);

    /**
     * Updates a productOccasion.
     *
     * @param productOccasionDTO the entity to update.
     * @return the persisted entity.
     */
    ProductOccasionDTO update(ProductOccasionDTO productOccasionDTO);

    /**
     * Partially updates a productOccasion.
     *
     * @param productOccasionDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ProductOccasionDTO> partialUpdate(ProductOccasionDTO productOccasionDTO);

    /**
     * Get all the productOccasions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProductOccasionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" productOccasion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductOccasionDTO> findOne(Long id);

    /**
     * Delete the "id" productOccasion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
