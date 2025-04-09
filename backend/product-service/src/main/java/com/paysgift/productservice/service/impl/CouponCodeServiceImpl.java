package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.CouponCode;
import com.paysgift.productservice.repository.CouponCodeRepository;
import com.paysgift.productservice.service.CouponCodeService;
import com.paysgift.productservice.service.dto.CouponCodeDTO;
import com.paysgift.productservice.service.mapper.CouponCodeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.CouponCode}.
 */
@Service
@Transactional
public class CouponCodeServiceImpl implements CouponCodeService {

    private static final Logger LOG = LoggerFactory.getLogger(CouponCodeServiceImpl.class);

    private final CouponCodeRepository couponCodeRepository;

    private final CouponCodeMapper couponCodeMapper;

    public CouponCodeServiceImpl(CouponCodeRepository couponCodeRepository, CouponCodeMapper couponCodeMapper) {
        this.couponCodeRepository = couponCodeRepository;
        this.couponCodeMapper = couponCodeMapper;
    }

    @Override
    public CouponCodeDTO save(CouponCodeDTO couponCodeDTO) {
        LOG.debug("Request to save CouponCode : {}", couponCodeDTO);
        CouponCode couponCode = couponCodeMapper.toEntity(couponCodeDTO);
        couponCode = couponCodeRepository.save(couponCode);
        return couponCodeMapper.toDto(couponCode);
    }

    @Override
    public CouponCodeDTO update(CouponCodeDTO couponCodeDTO) {
        LOG.debug("Request to update CouponCode : {}", couponCodeDTO);
        CouponCode couponCode = couponCodeMapper.toEntity(couponCodeDTO);
        couponCode = couponCodeRepository.save(couponCode);
        return couponCodeMapper.toDto(couponCode);
    }

    @Override
    public Optional<CouponCodeDTO> partialUpdate(CouponCodeDTO couponCodeDTO) {
        LOG.debug("Request to partially update CouponCode : {}", couponCodeDTO);

        return couponCodeRepository
            .findById(couponCodeDTO.getId())
            .map(existingCouponCode -> {
                couponCodeMapper.partialUpdate(existingCouponCode, couponCodeDTO);

                return existingCouponCode;
            })
            .map(couponCodeRepository::save)
            .map(couponCodeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CouponCodeDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all CouponCodes");
        return couponCodeRepository.findAll(pageable).map(couponCodeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CouponCodeDTO> findOne(Long id) {
        LOG.debug("Request to get CouponCode : {}", id);
        return couponCodeRepository.findById(id).map(couponCodeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete CouponCode : {}", id);
        couponCodeRepository.deleteById(id);
    }
}
