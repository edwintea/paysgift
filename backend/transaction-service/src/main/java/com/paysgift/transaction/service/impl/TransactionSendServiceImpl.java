package com.paysgift.transaction.service.impl;

import com.paysgift.transaction.domain.TransactionSend;
import com.paysgift.transaction.repository.TransactionSendRepository;
import com.paysgift.transaction.service.TransactionSendService;
import com.paysgift.transaction.service.dto.TransactionSendDTO;
import com.paysgift.transaction.service.mapper.TransactionSendMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.transaction.domain.TransactionSend}.
 */
@Service
@Transactional
public class TransactionSendServiceImpl implements TransactionSendService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionSendServiceImpl.class);

    private final TransactionSendRepository transactionSendRepository;

    private final TransactionSendMapper transactionSendMapper;

    public TransactionSendServiceImpl(TransactionSendRepository transactionSendRepository, TransactionSendMapper transactionSendMapper) {
        this.transactionSendRepository = transactionSendRepository;
        this.transactionSendMapper = transactionSendMapper;
    }

    @Override
    public TransactionSendDTO save(TransactionSendDTO transactionSendDTO) {
        LOG.debug("Request to save TransactionSend : {}", transactionSendDTO);
        TransactionSend transactionSend = transactionSendMapper.toEntity(transactionSendDTO);
        transactionSend = transactionSendRepository.save(transactionSend);
        return transactionSendMapper.toDto(transactionSend);
    }

    @Override
    public TransactionSendDTO update(TransactionSendDTO transactionSendDTO) {
        LOG.debug("Request to update TransactionSend : {}", transactionSendDTO);
        TransactionSend transactionSend = transactionSendMapper.toEntity(transactionSendDTO);
        transactionSend = transactionSendRepository.save(transactionSend);
        return transactionSendMapper.toDto(transactionSend);
    }

    @Override
    public Optional<TransactionSendDTO> partialUpdate(TransactionSendDTO transactionSendDTO) {
        LOG.debug("Request to partially update TransactionSend : {}", transactionSendDTO);

        return transactionSendRepository
            .findById(transactionSendDTO.getId())
            .map(existingTransactionSend -> {
                transactionSendMapper.partialUpdate(existingTransactionSend, transactionSendDTO);

                return existingTransactionSend;
            })
            .map(transactionSendRepository::save)
            .map(transactionSendMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionSendDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all TransactionSends");
        return transactionSendRepository.findAll(pageable).map(transactionSendMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TransactionSendDTO> findOne(Long id) {
        LOG.debug("Request to get TransactionSend : {}", id);
        return transactionSendRepository.findById(id).map(transactionSendMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TransactionSend : {}", id);
        transactionSendRepository.deleteById(id);
    }
}
