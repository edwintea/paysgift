package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentProvider;
import com.paysgift.paymentservice.repository.PaymentProviderRepository;
import com.paysgift.paymentservice.service.PaymentProviderService;
import com.paysgift.paymentservice.service.dto.PaymentProviderDTO;
import com.paysgift.paymentservice.service.mapper.PaymentProviderMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentProvider}.
 */
@Service
@Transactional
public class PaymentProviderServiceImpl implements PaymentProviderService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentProviderServiceImpl.class);

    private final PaymentProviderRepository paymentProviderRepository;

    private final PaymentProviderMapper paymentProviderMapper;

    public PaymentProviderServiceImpl(PaymentProviderRepository paymentProviderRepository, PaymentProviderMapper paymentProviderMapper) {
        this.paymentProviderRepository = paymentProviderRepository;
        this.paymentProviderMapper = paymentProviderMapper;
    }

    @Override
    public PaymentProviderDTO save(PaymentProviderDTO paymentProviderDTO) {
        LOG.debug("Request to save PaymentProvider : {}", paymentProviderDTO);
        PaymentProvider paymentProvider = paymentProviderMapper.toEntity(paymentProviderDTO);
        paymentProvider = paymentProviderRepository.save(paymentProvider);
        return paymentProviderMapper.toDto(paymentProvider);
    }

    @Override
    public PaymentProviderDTO update(PaymentProviderDTO paymentProviderDTO) {
        LOG.debug("Request to update PaymentProvider : {}", paymentProviderDTO);
        PaymentProvider paymentProvider = paymentProviderMapper.toEntity(paymentProviderDTO);
        paymentProvider = paymentProviderRepository.save(paymentProvider);
        return paymentProviderMapper.toDto(paymentProvider);
    }

    @Override
    public Optional<PaymentProviderDTO> partialUpdate(PaymentProviderDTO paymentProviderDTO) {
        LOG.debug("Request to partially update PaymentProvider : {}", paymentProviderDTO);

        return paymentProviderRepository
            .findById(paymentProviderDTO.getId())
            .map(existingPaymentProvider -> {
                paymentProviderMapper.partialUpdate(existingPaymentProvider, paymentProviderDTO);

                return existingPaymentProvider;
            })
            .map(paymentProviderRepository::save)
            .map(paymentProviderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentProviderDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentProviders");
        return paymentProviderRepository.findAll(pageable).map(paymentProviderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentProviderDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentProvider : {}", id);
        return paymentProviderRepository.findById(id).map(paymentProviderMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentProvider : {}", id);
        paymentProviderRepository.deleteById(id);
    }
}
