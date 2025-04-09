package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.PaysgiftPromoInfo;
import com.paysgift.productservice.repository.PaysgiftPromoInfoRepository;
import com.paysgift.productservice.service.PaysgiftPromoInfoService;
import com.paysgift.productservice.service.dto.PaysgiftPromoInfoDTO;
import com.paysgift.productservice.service.mapper.PaysgiftPromoInfoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.PaysgiftPromoInfo}.
 */
@Service
@Transactional
public class PaysgiftPromoInfoServiceImpl implements PaysgiftPromoInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(PaysgiftPromoInfoServiceImpl.class);

    private final PaysgiftPromoInfoRepository paysgiftPromoInfoRepository;

    private final PaysgiftPromoInfoMapper paysgiftPromoInfoMapper;

    public PaysgiftPromoInfoServiceImpl(
        PaysgiftPromoInfoRepository paysgiftPromoInfoRepository,
        PaysgiftPromoInfoMapper paysgiftPromoInfoMapper
    ) {
        this.paysgiftPromoInfoRepository = paysgiftPromoInfoRepository;
        this.paysgiftPromoInfoMapper = paysgiftPromoInfoMapper;
    }

    @Override
    public PaysgiftPromoInfoDTO save(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO) {
        LOG.debug("Request to save PaysgiftPromoInfo : {}", paysgiftPromoInfoDTO);
        PaysgiftPromoInfo paysgiftPromoInfo = paysgiftPromoInfoMapper.toEntity(paysgiftPromoInfoDTO);
        paysgiftPromoInfo = paysgiftPromoInfoRepository.save(paysgiftPromoInfo);
        return paysgiftPromoInfoMapper.toDto(paysgiftPromoInfo);
    }

    @Override
    public PaysgiftPromoInfoDTO update(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO) {
        LOG.debug("Request to update PaysgiftPromoInfo : {}", paysgiftPromoInfoDTO);
        PaysgiftPromoInfo paysgiftPromoInfo = paysgiftPromoInfoMapper.toEntity(paysgiftPromoInfoDTO);
        paysgiftPromoInfo = paysgiftPromoInfoRepository.save(paysgiftPromoInfo);
        return paysgiftPromoInfoMapper.toDto(paysgiftPromoInfo);
    }

    @Override
    public Optional<PaysgiftPromoInfoDTO> partialUpdate(PaysgiftPromoInfoDTO paysgiftPromoInfoDTO) {
        LOG.debug("Request to partially update PaysgiftPromoInfo : {}", paysgiftPromoInfoDTO);

        return paysgiftPromoInfoRepository
            .findById(paysgiftPromoInfoDTO.getId())
            .map(existingPaysgiftPromoInfo -> {
                paysgiftPromoInfoMapper.partialUpdate(existingPaysgiftPromoInfo, paysgiftPromoInfoDTO);

                return existingPaysgiftPromoInfo;
            })
            .map(paysgiftPromoInfoRepository::save)
            .map(paysgiftPromoInfoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaysgiftPromoInfoDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all PaysgiftPromoInfos");
        return paysgiftPromoInfoRepository.findAll(pageable).map(paysgiftPromoInfoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaysgiftPromoInfoDTO> findOne(Long id) {
        LOG.debug("Request to get PaysgiftPromoInfo : {}", id);
        return paysgiftPromoInfoRepository.findById(id).map(paysgiftPromoInfoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaysgiftPromoInfo : {}", id);
        paysgiftPromoInfoRepository.deleteById(id);
    }
}
