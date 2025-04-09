package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.ProductFavourite;
import com.paysgift.productservice.repository.ProductFavouriteRepository;
import com.paysgift.productservice.service.ProductFavouriteService;
import com.paysgift.productservice.service.dto.ProductFavouriteDTO;
import com.paysgift.productservice.service.mapper.ProductFavouriteMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.ProductFavourite}.
 */
@Service
@Transactional
public class ProductFavouriteServiceImpl implements ProductFavouriteService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductFavouriteServiceImpl.class);

    private final ProductFavouriteRepository productFavouriteRepository;

    private final ProductFavouriteMapper productFavouriteMapper;

    public ProductFavouriteServiceImpl(
        ProductFavouriteRepository productFavouriteRepository,
        ProductFavouriteMapper productFavouriteMapper
    ) {
        this.productFavouriteRepository = productFavouriteRepository;
        this.productFavouriteMapper = productFavouriteMapper;
    }

    @Override
    public ProductFavouriteDTO save(ProductFavouriteDTO productFavouriteDTO) {
        LOG.debug("Request to save ProductFavourite : {}", productFavouriteDTO);
        ProductFavourite productFavourite = productFavouriteMapper.toEntity(productFavouriteDTO);
        productFavourite = productFavouriteRepository.save(productFavourite);
        return productFavouriteMapper.toDto(productFavourite);
    }

    @Override
    public ProductFavouriteDTO update(ProductFavouriteDTO productFavouriteDTO) {
        LOG.debug("Request to update ProductFavourite : {}", productFavouriteDTO);
        ProductFavourite productFavourite = productFavouriteMapper.toEntity(productFavouriteDTO);
        productFavourite = productFavouriteRepository.save(productFavourite);
        return productFavouriteMapper.toDto(productFavourite);
    }

    @Override
    public Optional<ProductFavouriteDTO> partialUpdate(ProductFavouriteDTO productFavouriteDTO) {
        LOG.debug("Request to partially update ProductFavourite : {}", productFavouriteDTO);

        return productFavouriteRepository
            .findById(productFavouriteDTO.getId())
            .map(existingProductFavourite -> {
                productFavouriteMapper.partialUpdate(existingProductFavourite, productFavouriteDTO);

                return existingProductFavourite;
            })
            .map(productFavouriteRepository::save)
            .map(productFavouriteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductFavouriteDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all ProductFavourites");
        return productFavouriteRepository.findAll(pageable).map(productFavouriteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductFavouriteDTO> findOne(Long id) {
        LOG.debug("Request to get ProductFavourite : {}", id);
        return productFavouriteRepository.findById(id).map(productFavouriteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ProductFavourite : {}", id);
        productFavouriteRepository.deleteById(id);
    }
}
