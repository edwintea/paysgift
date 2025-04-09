package com.paysgift.productservice.service;

import com.paysgift.productservice.service.dto.ProductFavouriteDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.productservice.domain.ProductFavourite}.
 */
public interface ProductFavouriteService {
    /**
     * Save a productFavourite.
     *
     * @param productFavouriteDTO the entity to save.
     * @return the persisted entity.
     */
    ProductFavouriteDTO save(ProductFavouriteDTO productFavouriteDTO);

    /**
     * Updates a productFavourite.
     *
     * @param productFavouriteDTO the entity to update.
     * @return the persisted entity.
     */
    ProductFavouriteDTO update(ProductFavouriteDTO productFavouriteDTO);

    /**
     * Partially updates a productFavourite.
     *
     * @param productFavouriteDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ProductFavouriteDTO> partialUpdate(ProductFavouriteDTO productFavouriteDTO);

    /**
     * Get all the productFavourites.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProductFavouriteDTO> findAll(Pageable pageable);

    /**
     * Get the "id" productFavourite.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductFavouriteDTO> findOne(Long id);

    /**
     * Delete the "id" productFavourite.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
