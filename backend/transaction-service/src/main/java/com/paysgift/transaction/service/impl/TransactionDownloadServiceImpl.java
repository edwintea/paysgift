package com.paysgift.transaction.service.impl;

import com.paysgift.transaction.domain.TransactionDownload;
import com.paysgift.transaction.repository.TransactionDownloadRepository;
import com.paysgift.transaction.service.TransactionDownloadService;
import com.paysgift.transaction.service.dto.TransactionDownloadDTO;
import com.paysgift.transaction.service.mapper.TransactionDownloadMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.transaction.domain.TransactionDownload}.
 */
@Service
@Transactional
public class TransactionDownloadServiceImpl implements TransactionDownloadService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionDownloadServiceImpl.class);

    private final TransactionDownloadRepository transactionDownloadRepository;

    private final TransactionDownloadMapper transactionDownloadMapper;

    public TransactionDownloadServiceImpl(
        TransactionDownloadRepository transactionDownloadRepository,
        TransactionDownloadMapper transactionDownloadMapper
    ) {
        this.transactionDownloadRepository = transactionDownloadRepository;
        this.transactionDownloadMapper = transactionDownloadMapper;
    }

    @Override
    public TransactionDownloadDTO save(TransactionDownloadDTO transactionDownloadDTO) {
        LOG.debug("Request to save TransactionDownload : {}", transactionDownloadDTO);
        TransactionDownload transactionDownload = transactionDownloadMapper.toEntity(transactionDownloadDTO);
        transactionDownload = transactionDownloadRepository.save(transactionDownload);
        return transactionDownloadMapper.toDto(transactionDownload);
    }

    @Override
    public TransactionDownloadDTO update(TransactionDownloadDTO transactionDownloadDTO) {
        LOG.debug("Request to update TransactionDownload : {}", transactionDownloadDTO);
        TransactionDownload transactionDownload = transactionDownloadMapper.toEntity(transactionDownloadDTO);
        transactionDownload = transactionDownloadRepository.save(transactionDownload);
        return transactionDownloadMapper.toDto(transactionDownload);
    }

    @Override
    public Optional<TransactionDownloadDTO> partialUpdate(TransactionDownloadDTO transactionDownloadDTO) {
        LOG.debug("Request to partially update TransactionDownload : {}", transactionDownloadDTO);

        return transactionDownloadRepository
            .findById(transactionDownloadDTO.getId())
            .map(existingTransactionDownload -> {
                transactionDownloadMapper.partialUpdate(existingTransactionDownload, transactionDownloadDTO);

                return existingTransactionDownload;
            })
            .map(transactionDownloadRepository::save)
            .map(transactionDownloadMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionDownloadDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all TransactionDownloads");
        return transactionDownloadRepository.findAll(pageable).map(transactionDownloadMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TransactionDownloadDTO> findOne(Long id) {
        LOG.debug("Request to get TransactionDownload : {}", id);
        return transactionDownloadRepository.findById(id).map(transactionDownloadMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TransactionDownload : {}", id);
        transactionDownloadRepository.deleteById(id);
    }
}
