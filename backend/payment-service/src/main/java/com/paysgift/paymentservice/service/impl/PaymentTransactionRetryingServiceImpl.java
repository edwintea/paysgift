package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentTransactionRetrying;
import com.paysgift.paymentservice.repository.PaymentTransactionRetryingRepository;
import com.paysgift.paymentservice.service.PaymentTransactionRetryingService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRetryingDTO;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionRetryingMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRetrying}.
 */
@Service
@Transactional
public class PaymentTransactionRetryingServiceImpl implements PaymentTransactionRetryingService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionRetryingServiceImpl.class);

    private final PaymentTransactionRetryingRepository paymentTransactionRetryingRepository;

    private final PaymentTransactionRetryingMapper paymentTransactionRetryingMapper;

    public PaymentTransactionRetryingServiceImpl(
        PaymentTransactionRetryingRepository paymentTransactionRetryingRepository,
        PaymentTransactionRetryingMapper paymentTransactionRetryingMapper
    ) {
        this.paymentTransactionRetryingRepository = paymentTransactionRetryingRepository;
        this.paymentTransactionRetryingMapper = paymentTransactionRetryingMapper;
    }

    @Override
    public PaymentTransactionRetryingDTO save(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO) {
        LOG.debug("Request to save PaymentTransactionRetrying : {}", paymentTransactionRetryingDTO);
        PaymentTransactionRetrying paymentTransactionRetrying = paymentTransactionRetryingMapper.toEntity(paymentTransactionRetryingDTO);
        paymentTransactionRetrying = paymentTransactionRetryingRepository.save(paymentTransactionRetrying);
        return paymentTransactionRetryingMapper.toDto(paymentTransactionRetrying);
    }

    @Override
    public PaymentTransactionRetryingDTO update(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO) {
        LOG.debug("Request to update PaymentTransactionRetrying : {}", paymentTransactionRetryingDTO);
        PaymentTransactionRetrying paymentTransactionRetrying = paymentTransactionRetryingMapper.toEntity(paymentTransactionRetryingDTO);
        paymentTransactionRetrying = paymentTransactionRetryingRepository.save(paymentTransactionRetrying);
        return paymentTransactionRetryingMapper.toDto(paymentTransactionRetrying);
    }

    @Override
    public Optional<PaymentTransactionRetryingDTO> partialUpdate(PaymentTransactionRetryingDTO paymentTransactionRetryingDTO) {
        LOG.debug("Request to partially update PaymentTransactionRetrying : {}", paymentTransactionRetryingDTO);

        return paymentTransactionRetryingRepository
            .findById(paymentTransactionRetryingDTO.getId())
            .map(existingPaymentTransactionRetrying -> {
                paymentTransactionRetryingMapper.partialUpdate(existingPaymentTransactionRetrying, paymentTransactionRetryingDTO);

                return existingPaymentTransactionRetrying;
            })
            .map(paymentTransactionRetryingRepository::save)
            .map(paymentTransactionRetryingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentTransactionRetryingDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentTransactionRetryings");
        return paymentTransactionRetryingRepository.findAll(pageable).map(paymentTransactionRetryingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionRetryingDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentTransactionRetrying : {}", id);
        return paymentTransactionRetryingRepository.findById(id).map(paymentTransactionRetryingMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentTransactionRetrying : {}", id);
        paymentTransactionRetryingRepository.deleteById(id);
    }
}
