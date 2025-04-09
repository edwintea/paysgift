package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.ProductOccasion;
import com.paysgift.productservice.repository.ProductOccasionRepository;
import com.paysgift.productservice.service.ProductOccasionService;
import com.paysgift.productservice.service.dto.ProductOccasionDTO;
import com.paysgift.productservice.service.mapper.ProductOccasionMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.ProductOccasion}.
 */
@Service
@Transactional
public class ProductOccasionServiceImpl implements ProductOccasionService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductOccasionServiceImpl.class);

    private final ProductOccasionRepository productOccasionRepository;

    private final ProductOccasionMapper productOccasionMapper;

    public ProductOccasionServiceImpl(ProductOccasionRepository productOccasionRepository, ProductOccasionMapper productOccasionMapper) {
        this.productOccasionRepository = productOccasionRepository;
        this.productOccasionMapper = productOccasionMapper;
    }

    @Override
    public ProductOccasionDTO save(ProductOccasionDTO productOccasionDTO) {
        LOG.debug("Request to save ProductOccasion : {}", productOccasionDTO);
        ProductOccasion productOccasion = productOccasionMapper.toEntity(productOccasionDTO);
        productOccasion = productOccasionRepository.save(productOccasion);
        return productOccasionMapper.toDto(productOccasion);
    }

    @Override
    public ProductOccasionDTO update(ProductOccasionDTO productOccasionDTO) {
        LOG.debug("Request to update ProductOccasion : {}", productOccasionDTO);
        ProductOccasion productOccasion = productOccasionMapper.toEntity(productOccasionDTO);
        productOccasion = productOccasionRepository.save(productOccasion);
        return productOccasionMapper.toDto(productOccasion);
    }

    @Override
    public Optional<ProductOccasionDTO> partialUpdate(ProductOccasionDTO productOccasionDTO) {
        LOG.debug("Request to partially update ProductOccasion : {}", productOccasionDTO);

        return productOccasionRepository
            .findById(productOccasionDTO.getId())
            .map(existingProductOccasion -> {
                productOccasionMapper.partialUpdate(existingProductOccasion, productOccasionDTO);

                return existingProductOccasion;
            })
            .map(productOccasionRepository::save)
            .map(productOccasionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductOccasionDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all ProductOccasions");
        return productOccasionRepository.findAll(pageable).map(productOccasionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductOccasionDTO> findOne(Long id) {
        LOG.debug("Request to get ProductOccasion : {}", id);
        return productOccasionRepository.findById(id).map(productOccasionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ProductOccasion : {}", id);
        productOccasionRepository.deleteById(id);
    }
}
