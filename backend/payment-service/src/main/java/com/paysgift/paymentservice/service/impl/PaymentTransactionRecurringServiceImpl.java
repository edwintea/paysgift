package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentTransactionRecurring;
import com.paysgift.paymentservice.repository.PaymentTransactionRecurringRepository;
import com.paysgift.paymentservice.service.PaymentTransactionRecurringService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRecurringDTO;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionRecurringMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRecurring}.
 */
@Service
@Transactional
public class PaymentTransactionRecurringServiceImpl implements PaymentTransactionRecurringService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionRecurringServiceImpl.class);

    private final PaymentTransactionRecurringRepository paymentTransactionRecurringRepository;

    private final PaymentTransactionRecurringMapper paymentTransactionRecurringMapper;

    public PaymentTransactionRecurringServiceImpl(
        PaymentTransactionRecurringRepository paymentTransactionRecurringRepository,
        PaymentTransactionRecurringMapper paymentTransactionRecurringMapper
    ) {
        this.paymentTransactionRecurringRepository = paymentTransactionRecurringRepository;
        this.paymentTransactionRecurringMapper = paymentTransactionRecurringMapper;
    }

    @Override
    public PaymentTransactionRecurringDTO save(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO) {
        LOG.debug("Request to save PaymentTransactionRecurring : {}", paymentTransactionRecurringDTO);
        PaymentTransactionRecurring paymentTransactionRecurring = paymentTransactionRecurringMapper.toEntity(
            paymentTransactionRecurringDTO
        );
        paymentTransactionRecurring = paymentTransactionRecurringRepository.save(paymentTransactionRecurring);
        return paymentTransactionRecurringMapper.toDto(paymentTransactionRecurring);
    }

    @Override
    public PaymentTransactionRecurringDTO update(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO) {
        LOG.debug("Request to update PaymentTransactionRecurring : {}", paymentTransactionRecurringDTO);
        PaymentTransactionRecurring paymentTransactionRecurring = paymentTransactionRecurringMapper.toEntity(
            paymentTransactionRecurringDTO
        );
        paymentTransactionRecurring = paymentTransactionRecurringRepository.save(paymentTransactionRecurring);
        return paymentTransactionRecurringMapper.toDto(paymentTransactionRecurring);
    }

    @Override
    public Optional<PaymentTransactionRecurringDTO> partialUpdate(PaymentTransactionRecurringDTO paymentTransactionRecurringDTO) {
        LOG.debug("Request to partially update PaymentTransactionRecurring : {}", paymentTransactionRecurringDTO);

        return paymentTransactionRecurringRepository
            .findById(paymentTransactionRecurringDTO.getId())
            .map(existingPaymentTransactionRecurring -> {
                paymentTransactionRecurringMapper.partialUpdate(existingPaymentTransactionRecurring, paymentTransactionRecurringDTO);

                return existingPaymentTransactionRecurring;
            })
            .map(paymentTransactionRecurringRepository::save)
            .map(paymentTransactionRecurringMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentTransactionRecurringDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentTransactionRecurrings");
        return paymentTransactionRecurringRepository.findAll(pageable).map(paymentTransactionRecurringMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionRecurringDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentTransactionRecurring : {}", id);
        return paymentTransactionRecurringRepository.findById(id).map(paymentTransactionRecurringMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentTransactionRecurring : {}", id);
        paymentTransactionRecurringRepository.deleteById(id);
    }
}
