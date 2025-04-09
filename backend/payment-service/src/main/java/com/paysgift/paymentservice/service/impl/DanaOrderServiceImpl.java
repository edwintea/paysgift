package com.paysgift.paymentservice.service.impl;

import com.paysgift.paymentservice.domain.DanaOrder;
import com.paysgift.paymentservice.repository.DanaOrderRepository;
import com.paysgift.paymentservice.service.DanaOrderService;
import com.paysgift.paymentservice.service.dto.DanaOrderDTO;
import com.paysgift.paymentservice.service.mapper.DanaOrderMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.paymentservice.domain.DanaOrder}.
 */
@Service
@Transactional
public class DanaOrderServiceImpl implements DanaOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(DanaOrderServiceImpl.class);

    private final DanaOrderRepository danaOrderRepository;

    private final DanaOrderMapper danaOrderMapper;

    public DanaOrderServiceImpl(DanaOrderRepository danaOrderRepository, DanaOrderMapper danaOrderMapper) {
        this.danaOrderRepository = danaOrderRepository;
        this.danaOrderMapper = danaOrderMapper;
    }

    @Override
    public DanaOrderDTO save(DanaOrderDTO danaOrderDTO) {
        LOG.debug("Request to save DanaOrder : {}", danaOrderDTO);
        DanaOrder danaOrder = danaOrderMapper.toEntity(danaOrderDTO);
        danaOrder = danaOrderRepository.save(danaOrder);
        return danaOrderMapper.toDto(danaOrder);
    }

    @Override
    public DanaOrderDTO update(DanaOrderDTO danaOrderDTO) {
        LOG.debug("Request to update DanaOrder : {}", danaOrderDTO);
        DanaOrder danaOrder = danaOrderMapper.toEntity(danaOrderDTO);
        danaOrder = danaOrderRepository.save(danaOrder);
        return danaOrderMapper.toDto(danaOrder);
    }

    @Override
    public Optional<DanaOrderDTO> partialUpdate(DanaOrderDTO danaOrderDTO) {
        LOG.debug("Request to partially update DanaOrder : {}", danaOrderDTO);

        return danaOrderRepository
            .findById(danaOrderDTO.getId())
            .map(existingDanaOrder -> {
                danaOrderMapper.partialUpdate(existingDanaOrder, danaOrderDTO);

                return existingDanaOrder;
            })
            .map(danaOrderRepository::save)
            .map(danaOrderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DanaOrderDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all DanaOrders");
        return danaOrderRepository.findAll(pageable).map(danaOrderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DanaOrderDTO> findOne(Long id) {
        LOG.debug("Request to get DanaOrder : {}", id);
        return danaOrderRepository.findById(id).map(danaOrderMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete DanaOrder : {}", id);
        danaOrderRepository.deleteById(id);
    }
}
