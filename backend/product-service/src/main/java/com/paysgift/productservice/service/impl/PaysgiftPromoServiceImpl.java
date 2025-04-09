package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.PaysgiftPromo;
import com.paysgift.productservice.repository.PaysgiftPromoRepository;
import com.paysgift.productservice.service.PaysgiftPromoService;
import com.paysgift.productservice.service.dto.PaysgiftPromoDTO;
import com.paysgift.productservice.service.mapper.PaysgiftPromoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.PaysgiftPromo}.
 */
@Service
@Transactional
public class PaysgiftPromoServiceImpl implements PaysgiftPromoService {

    private static final Logger LOG = LoggerFactory.getLogger(PaysgiftPromoServiceImpl.class);

    private final PaysgiftPromoRepository paysgiftPromoRepository;

    private final PaysgiftPromoMapper paysgiftPromoMapper;

    public PaysgiftPromoServiceImpl(PaysgiftPromoRepository paysgiftPromoRepository, PaysgiftPromoMapper paysgiftPromoMapper) {
        this.paysgiftPromoRepository = paysgiftPromoRepository;
        this.paysgiftPromoMapper = paysgiftPromoMapper;
    }

    @Override
    public PaysgiftPromoDTO save(PaysgiftPromoDTO paysgiftPromoDTO) {
        LOG.debug("Request to save PaysgiftPromo : {}", paysgiftPromoDTO);
        PaysgiftPromo paysgiftPromo = paysgiftPromoMapper.toEntity(paysgiftPromoDTO);
        paysgiftPromo = paysgiftPromoRepository.save(paysgiftPromo);
        return paysgiftPromoMapper.toDto(paysgiftPromo);
    }

    @Override
    public PaysgiftPromoDTO update(PaysgiftPromoDTO paysgiftPromoDTO) {
        LOG.debug("Request to update PaysgiftPromo : {}", paysgiftPromoDTO);
        PaysgiftPromo paysgiftPromo = paysgiftPromoMapper.toEntity(paysgiftPromoDTO);
        paysgiftPromo = paysgiftPromoRepository.save(paysgiftPromo);
        return paysgiftPromoMapper.toDto(paysgiftPromo);
    }

    @Override
    public Optional<PaysgiftPromoDTO> partialUpdate(PaysgiftPromoDTO paysgiftPromoDTO) {
        LOG.debug("Request to partially update PaysgiftPromo : {}", paysgiftPromoDTO);

        return paysgiftPromoRepository
            .findById(paysgiftPromoDTO.getId())
            .map(existingPaysgiftPromo -> {
                paysgiftPromoMapper.partialUpdate(existingPaysgiftPromo, paysgiftPromoDTO);

                return existingPaysgiftPromo;
            })
            .map(paysgiftPromoRepository::save)
            .map(paysgiftPromoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaysgiftPromoDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaysgiftPromos");
        return paysgiftPromoRepository.findAll(pageable).map(paysgiftPromoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaysgiftPromoDTO> findOne(Long id) {
        LOG.debug("Request to get PaysgiftPromo : {}", id);
        return paysgiftPromoRepository.findById(id).map(paysgiftPromoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaysgiftPromo : {}", id);
        paysgiftPromoRepository.deleteById(id);
    }
}
