package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.PaymentCampaign;
import com.paysgift.paymentservice.repository.PaymentCampaignRepository;
import com.paysgift.paymentservice.service.PaymentCampaignService;
import com.paysgift.paymentservice.service.dto.PaymentCampaignDTO;
import com.paysgift.paymentservice.service.mapper.PaymentCampaignMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.PaymentCampaign}.
 */
@Service
@Transactional
public class PaymentCampaignServiceImpl implements PaymentCampaignService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentCampaignServiceImpl.class);

    private final PaymentCampaignRepository paymentCampaignRepository;

    private final PaymentCampaignMapper paymentCampaignMapper;

    public PaymentCampaignServiceImpl(PaymentCampaignRepository paymentCampaignRepository, PaymentCampaignMapper paymentCampaignMapper) {
        this.paymentCampaignRepository = paymentCampaignRepository;
        this.paymentCampaignMapper = paymentCampaignMapper;
    }

    @Override
    public PaymentCampaignDTO save(PaymentCampaignDTO paymentCampaignDTO) {
        LOG.debug("Request to save PaymentCampaign : {}", paymentCampaignDTO);
        PaymentCampaign paymentCampaign = paymentCampaignMapper.toEntity(paymentCampaignDTO);
        paymentCampaign = paymentCampaignRepository.save(paymentCampaign);
        return paymentCampaignMapper.toDto(paymentCampaign);
    }

    @Override
    public PaymentCampaignDTO update(PaymentCampaignDTO paymentCampaignDTO) {
        LOG.debug("Request to update PaymentCampaign : {}", paymentCampaignDTO);
        PaymentCampaign paymentCampaign = paymentCampaignMapper.toEntity(paymentCampaignDTO);
        paymentCampaign = paymentCampaignRepository.save(paymentCampaign);
        return paymentCampaignMapper.toDto(paymentCampaign);
    }

    @Override
    public Optional<PaymentCampaignDTO> partialUpdate(PaymentCampaignDTO paymentCampaignDTO) {
        LOG.debug("Request to partially update PaymentCampaign : {}", paymentCampaignDTO);

        return paymentCampaignRepository
            .findById(paymentCampaignDTO.getId())
            .map(existingPaymentCampaign -> {
                paymentCampaignMapper.partialUpdate(existingPaymentCampaign, paymentCampaignDTO);

                return existingPaymentCampaign;
            })
            .map(paymentCampaignRepository::save)
            .map(paymentCampaignMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaymentCampaignDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaymentCampaigns");
        return paymentCampaignRepository.findAll(pageable).map(paymentCampaignMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentCampaignDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentCampaign : {}", id);
        return paymentCampaignRepository.findById(id).map(paymentCampaignMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentCampaign : {}", id);
        paymentCampaignRepository.deleteById(id);
    }
}
