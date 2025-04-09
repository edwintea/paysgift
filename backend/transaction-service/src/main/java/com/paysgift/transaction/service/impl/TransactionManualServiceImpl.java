package com.paysgift.transaction.service.impl;

import com.paysgift.transaction.domain.TransactionManual;
import com.paysgift.transaction.repository.TransactionManualRepository;
import com.paysgift.transaction.service.TransactionManualService;
import com.paysgift.transaction.service.dto.TransactionManualDTO;
import com.paysgift.transaction.service.mapper.TransactionManualMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.transaction.domain.TransactionManual}.
 */
@Service
@Transactional
public class TransactionManualServiceImpl implements TransactionManualService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionManualServiceImpl.class);

    private final TransactionManualRepository transactionManualRepository;

    private final TransactionManualMapper transactionManualMapper;

    public TransactionManualServiceImpl(
        TransactionManualRepository transactionManualRepository,
        TransactionManualMapper transactionManualMapper
    ) {
        this.transactionManualRepository = transactionManualRepository;
        this.transactionManualMapper = transactionManualMapper;
    }

    @Override
    public TransactionManualDTO save(TransactionManualDTO transactionManualDTO) {
        LOG.debug("Request to save TransactionManual : {}", transactionManualDTO);
        TransactionManual transactionManual = transactionManualMapper.toEntity(transactionManualDTO);
        transactionManual = transactionManualRepository.save(transactionManual);
        return transactionManualMapper.toDto(transactionManual);
    }

    @Override
    public TransactionManualDTO update(TransactionManualDTO transactionManualDTO) {
        LOG.debug("Request to update TransactionManual : {}", transactionManualDTO);
        TransactionManual transactionManual = transactionManualMapper.toEntity(transactionManualDTO);
        transactionManual = transactionManualRepository.save(transactionManual);
        return transactionManualMapper.toDto(transactionManual);
    }

    @Override
    public Optional<TransactionManualDTO> partialUpdate(TransactionManualDTO transactionManualDTO) {
        LOG.debug("Request to partially update TransactionManual : {}", transactionManualDTO);

        return transactionManualRepository
            .findById(transactionManualDTO.getId())
            .map(existingTransactionManual -> {
                transactionManualMapper.partialUpdate(existingTransactionManual, transactionManualDTO);

                return existingTransactionManual;
            })
            .map(transactionManualRepository::save)
            .map(transactionManualMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionManualDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all TransactionManuals");
        return transactionManualRepository.findAll(pageable).map(transactionManualMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TransactionManualDTO> findOne(Long id) {
        LOG.debug("Request to get TransactionManual : {}", id);
        return transactionManualRepository.findById(id).map(transactionManualMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TransactionManual : {}", id);
        transactionManualRepository.deleteById(id);
    }
}
