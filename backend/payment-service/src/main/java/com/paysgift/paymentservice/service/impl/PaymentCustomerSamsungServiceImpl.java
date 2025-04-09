package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentCustomerSamsung;
import com.paysgift.paymentservice.repository.PaymentCustomerSamsungRepository;
import com.paysgift.paymentservice.service.PaymentCustomerSamsungService;
import com.paysgift.paymentservice.service.dto.PaymentCustomerSamsungDTO;
import com.paysgift.paymentservice.service.mapper.PaymentCustomerSamsungMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentCustomerSamsung}.
 */
@Service
@Transactional
public class PaymentCustomerSamsungServiceImpl implements PaymentCustomerSamsungService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentCustomerSamsungServiceImpl.class);

    private final PaymentCustomerSamsungRepository paymentCustomerSamsungRepository;

    private final PaymentCustomerSamsungMapper paymentCustomerSamsungMapper;

    public PaymentCustomerSamsungServiceImpl(
        PaymentCustomerSamsungRepository paymentCustomerSamsungRepository,
        PaymentCustomerSamsungMapper paymentCustomerSamsungMapper
    ) {
        this.paymentCustomerSamsungRepository = paymentCustomerSamsungRepository;
        this.paymentCustomerSamsungMapper = paymentCustomerSamsungMapper;
    }

    @Override
    public PaymentCustomerSamsungDTO save(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO) {
        LOG.debug("Request to save PaymentCustomerSamsung : {}", paymentCustomerSamsungDTO);
        PaymentCustomerSamsung paymentCustomerSamsung = paymentCustomerSamsungMapper.toEntity(paymentCustomerSamsungDTO);
        paymentCustomerSamsung = paymentCustomerSamsungRepository.save(paymentCustomerSamsung);
        return paymentCustomerSamsungMapper.toDto(paymentCustomerSamsung);
    }

    @Override
    public PaymentCustomerSamsungDTO update(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO) {
        LOG.debug("Request to update PaymentCustomerSamsung : {}", paymentCustomerSamsungDTO);
        PaymentCustomerSamsung paymentCustomerSamsung = paymentCustomerSamsungMapper.toEntity(paymentCustomerSamsungDTO);
        paymentCustomerSamsung = paymentCustomerSamsungRepository.save(paymentCustomerSamsung);
        return paymentCustomerSamsungMapper.toDto(paymentCustomerSamsung);
    }

    @Override
    public Optional<PaymentCustomerSamsungDTO> partialUpdate(PaymentCustomerSamsungDTO paymentCustomerSamsungDTO) {
        LOG.debug("Request to partially update PaymentCustomerSamsung : {}", paymentCustomerSamsungDTO);

        return paymentCustomerSamsungRepository
            .findById(paymentCustomerSamsungDTO.getId())
            .map(existingPaymentCustomerSamsung -> {
                paymentCustomerSamsungMapper.partialUpdate(existingPaymentCustomerSamsung, paymentCustomerSamsungDTO);

                return existingPaymentCustomerSamsung;
            })
            .map(paymentCustomerSamsungRepository::save)
            .map(paymentCustomerSamsungMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentCustomerSamsungDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentCustomerSamsungs");
        return paymentCustomerSamsungRepository.findAll(pageable).map(paymentCustomerSamsungMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentCustomerSamsungDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentCustomerSamsung : {}", id);
        return paymentCustomerSamsungRepository.findById(id).map(paymentCustomerSamsungMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentCustomerSamsung : {}", id);
        paymentCustomerSamsungRepository.deleteById(id);
    }
}
