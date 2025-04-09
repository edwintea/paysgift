package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentList;
import com.paysgift.paymentservice.repository.PaymentListRepository;
import com.paysgift.paymentservice.service.PaymentListService;
import com.paysgift.paymentservice.service.dto.PaymentListDTO;
import com.paysgift.paymentservice.service.mapper.PaymentListMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentList}.
 */
@Service
@Transactional
public class PaymentListServiceImpl implements PaymentListService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentListServiceImpl.class);

    private final PaymentListRepository paymentListRepository;

    private final PaymentListMapper paymentListMapper;

    public PaymentListServiceImpl(PaymentListRepository paymentListRepository, PaymentListMapper paymentListMapper) {
        this.paymentListRepository = paymentListRepository;
        this.paymentListMapper = paymentListMapper;
    }

    @Override
    public PaymentListDTO save(PaymentListDTO paymentListDTO) {
        LOG.debug("Request to save PaymentList : {}", paymentListDTO);
        PaymentList paymentList = paymentListMapper.toEntity(paymentListDTO);
        paymentList = paymentListRepository.save(paymentList);
        return paymentListMapper.toDto(paymentList);
    }

    @Override
    public PaymentListDTO update(PaymentListDTO paymentListDTO) {
        LOG.debug("Request to update PaymentList : {}", paymentListDTO);
        PaymentList paymentList = paymentListMapper.toEntity(paymentListDTO);
        paymentList = paymentListRepository.save(paymentList);
        return paymentListMapper.toDto(paymentList);
    }

    @Override
    public Optional<PaymentListDTO> partialUpdate(PaymentListDTO paymentListDTO) {
        LOG.debug("Request to partially update PaymentList : {}", paymentListDTO);

        return paymentListRepository
            .findById(paymentListDTO.getId())
            .map(existingPaymentList -> {
                paymentListMapper.partialUpdate(existingPaymentList, paymentListDTO);

                return existingPaymentList;
            })
            .map(paymentListRepository::save)
            .map(paymentListMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentListDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentLists");
        return paymentListRepository.findAll(pageable).map(paymentListMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentListDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentList : {}", id);
        return paymentListRepository.findById(id).map(paymentListMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentList : {}", id);
        paymentListRepository.deleteById(id);
    }
}
