package com.paysgift.transaction.service.impl;

import com.paysgift.transaction.domain.TransactionProduct;
import com.paysgift.transaction.repository.TransactionProductRepository;
import com.paysgift.transaction.service.TransactionProductService;
import com.paysgift.transaction.service.dto.TransactionProductDTO;
import com.paysgift.transaction.service.mapper.TransactionProductMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.transaction.domain.TransactionProduct}.
 */
@Service
@Transactional
public class TransactionProductServiceImpl implements TransactionProductService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionProductServiceImpl.class);

    private final TransactionProductRepository transactionProductRepository;

    private final TransactionProductMapper transactionProductMapper;

    public TransactionProductServiceImpl(
        TransactionProductRepository transactionProductRepository,
        TransactionProductMapper transactionProductMapper
    ) {
        this.transactionProductRepository = transactionProductRepository;
        this.transactionProductMapper = transactionProductMapper;
    }

    @Override
    public TransactionProductDTO save(TransactionProductDTO transactionProductDTO) {
        LOG.debug("Request to save TransactionProduct : {}", transactionProductDTO);
        TransactionProduct transactionProduct = transactionProductMapper.toEntity(transactionProductDTO);
        transactionProduct = transactionProductRepository.save(transactionProduct);
        return transactionProductMapper.toDto(transactionProduct);
    }

    @Override
    public TransactionProductDTO update(TransactionProductDTO transactionProductDTO) {
        LOG.debug("Request to update TransactionProduct : {}", transactionProductDTO);
        TransactionProduct transactionProduct = transactionProductMapper.toEntity(transactionProductDTO);
        transactionProduct = transactionProductRepository.save(transactionProduct);
        return transactionProductMapper.toDto(transactionProduct);
    }

    @Override
    public Optional<TransactionProductDTO> partialUpdate(TransactionProductDTO transactionProductDTO) {
        LOG.debug("Request to partially update TransactionProduct : {}", transactionProductDTO);

        return transactionProductRepository
            .findById(transactionProductDTO.getId())
            .map(existingTransactionProduct -> {
                transactionProductMapper.partialUpdate(existingTransactionProduct, transactionProductDTO);

                return existingTransactionProduct;
            })
            .map(transactionProductRepository::save)
            .map(transactionProductMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionProductDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all TransactionProducts");
        return transactionProductRepository.findAll(pageable).map(transactionProductMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TransactionProductDTO> findOne(Long id) {
        LOG.debug("Request to get TransactionProduct : {}", id);
        return transactionProductRepository.findById(id).map(transactionProductMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TransactionProduct : {}", id);
        transactionProductRepository.deleteById(id);
    }
}
