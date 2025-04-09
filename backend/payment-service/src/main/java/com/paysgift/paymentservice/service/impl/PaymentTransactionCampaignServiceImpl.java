package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentTransactionCampaign;
import com.paysgift.paymentservice.repository.PaymentTransactionCampaignRepository;
import com.paysgift.paymentservice.service.PaymentTransactionCampaignService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionCampaignDTO;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionCampaignMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionCampaign}.
 */
@Service
@Transactional
public class PaymentTransactionCampaignServiceImpl implements PaymentTransactionCampaignService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionCampaignServiceImpl.class);

    private final PaymentTransactionCampaignRepository paymentTransactionCampaignRepository;

    private final PaymentTransactionCampaignMapper paymentTransactionCampaignMapper;

    public PaymentTransactionCampaignServiceImpl(
        PaymentTransactionCampaignRepository paymentTransactionCampaignRepository,
        PaymentTransactionCampaignMapper paymentTransactionCampaignMapper
    ) {
        this.paymentTransactionCampaignRepository = paymentTransactionCampaignRepository;
        this.paymentTransactionCampaignMapper = paymentTransactionCampaignMapper;
    }

    @Override
    public PaymentTransactionCampaignDTO save(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO) {
        LOG.debug("Request to save PaymentTransactionCampaign : {}", paymentTransactionCampaignDTO);
        PaymentTransactionCampaign paymentTransactionCampaign = paymentTransactionCampaignMapper.toEntity(paymentTransactionCampaignDTO);
        paymentTransactionCampaign = paymentTransactionCampaignRepository.save(paymentTransactionCampaign);
        return paymentTransactionCampaignMapper.toDto(paymentTransactionCampaign);
    }

    @Override
    public PaymentTransactionCampaignDTO update(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO) {
        LOG.debug("Request to update PaymentTransactionCampaign : {}", paymentTransactionCampaignDTO);
        PaymentTransactionCampaign paymentTransactionCampaign = paymentTransactionCampaignMapper.toEntity(paymentTransactionCampaignDTO);
        paymentTransactionCampaign = paymentTransactionCampaignRepository.save(paymentTransactionCampaign);
        return paymentTransactionCampaignMapper.toDto(paymentTransactionCampaign);
    }

    @Override
    public Optional<PaymentTransactionCampaignDTO> partialUpdate(PaymentTransactionCampaignDTO paymentTransactionCampaignDTO) {
        LOG.debug("Request to partially update PaymentTransactionCampaign : {}", paymentTransactionCampaignDTO);

        return paymentTransactionCampaignRepository
            .findById(paymentTransactionCampaignDTO.getId())
            .map(existingPaymentTransactionCampaign -> {
                paymentTransactionCampaignMapper.partialUpdate(existingPaymentTransactionCampaign, paymentTransactionCampaignDTO);

                return existingPaymentTransactionCampaign;
            })
            .map(paymentTransactionCampaignRepository::save)
            .map(paymentTransactionCampaignMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentTransactionCampaignDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentTransactionCampaigns");
        return paymentTransactionCampaignRepository.findAll(pageable).map(paymentTransactionCampaignMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionCampaignDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentTransactionCampaign : {}", id);
        return paymentTransactionCampaignRepository.findById(id).map(paymentTransactionCampaignMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentTransactionCampaign : {}", id);
        paymentTransactionCampaignRepository.deleteById(id);
    }
}
