package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentType;
import com.paysgift.paymentservice.repository.PaymentTypeRepository;
import com.paysgift.paymentservice.service.PaymentTypeService;
import com.paysgift.paymentservice.service.dto.PaymentTypeDTO;
import com.paysgift.paymentservice.service.mapper.PaymentTypeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentType}.
 */
@Service
@Transactional
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTypeServiceImpl.class);

    private final PaymentTypeRepository paymentTypeRepository;

    private final PaymentTypeMapper paymentTypeMapper;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository, PaymentTypeMapper paymentTypeMapper) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.paymentTypeMapper = paymentTypeMapper;
    }

    @Override
    public PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO) {
        LOG.debug("Request to save PaymentType : {}", paymentTypeDTO);
        PaymentType paymentType = paymentTypeMapper.toEntity(paymentTypeDTO);
        paymentType = paymentTypeRepository.save(paymentType);
        return paymentTypeMapper.toDto(paymentType);
    }

    @Override
    public PaymentTypeDTO update(PaymentTypeDTO paymentTypeDTO) {
        LOG.debug("Request to update PaymentType : {}", paymentTypeDTO);
        PaymentType paymentType = paymentTypeMapper.toEntity(paymentTypeDTO);
        paymentType = paymentTypeRepository.save(paymentType);
        return paymentTypeMapper.toDto(paymentType);
    }

    @Override
    public Optional<PaymentTypeDTO> partialUpdate(PaymentTypeDTO paymentTypeDTO) {
        LOG.debug("Request to partially update PaymentType : {}", paymentTypeDTO);

        return paymentTypeRepository
            .findById(paymentTypeDTO.getId())
            .map(existingPaymentType -> {
                paymentTypeMapper.partialUpdate(existingPaymentType, paymentTypeDTO);

                return existingPaymentType;
            })
            .map(paymentTypeRepository::save)
            .map(paymentTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentTypeDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentTypes");
        return paymentTypeRepository.findAll(pageable).map(paymentTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTypeDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentType : {}", id);
        return paymentTypeRepository.findById(id).map(paymentTypeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentType : {}", id);
        paymentTypeRepository.deleteById(id);
    }
}
