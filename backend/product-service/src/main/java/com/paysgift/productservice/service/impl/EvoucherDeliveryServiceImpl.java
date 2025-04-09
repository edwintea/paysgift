package com.paysgift.productservice.service.impl;

import com.paysgift.productservice.domain.EvoucherDelivery;
import com.paysgift.productservice.repository.EvoucherDeliveryRepository;
import com.paysgift.productservice.service.EvoucherDeliveryService;
import com.paysgift.productservice.service.dto.EvoucherDeliveryDTO;
import com.paysgift.productservice.service.mapper.EvoucherDeliveryMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.productservice.domain.EvoucherDelivery}.
 */
@Service
@Transactional
public class EvoucherDeliveryServiceImpl implements EvoucherDeliveryService {

    private static final Logger LOG = LoggerFactory.getLogger(EvoucherDeliveryServiceImpl.class);

    private final EvoucherDeliveryRepository evoucherDeliveryRepository;

    private final EvoucherDeliveryMapper evoucherDeliveryMapper;

    public EvoucherDeliveryServiceImpl(
        EvoucherDeliveryRepository evoucherDeliveryRepository,
        EvoucherDeliveryMapper evoucherDeliveryMapper
    ) {
        this.evoucherDeliveryRepository = evoucherDeliveryRepository;
        this.evoucherDeliveryMapper = evoucherDeliveryMapper;
    }

    @Override
    public EvoucherDeliveryDTO save(EvoucherDeliveryDTO evoucherDeliveryDTO) {
        LOG.debug("Request to save EvoucherDelivery : {}", evoucherDeliveryDTO);
        EvoucherDelivery evoucherDelivery = evoucherDeliveryMapper.toEntity(evoucherDeliveryDTO);
        evoucherDelivery = evoucherDeliveryRepository.save(evoucherDelivery);
        return evoucherDeliveryMapper.toDto(evoucherDelivery);
    }

    @Override
    public EvoucherDeliveryDTO update(EvoucherDeliveryDTO evoucherDeliveryDTO) {
        LOG.debug("Request to update EvoucherDelivery : {}", evoucherDeliveryDTO);
        EvoucherDelivery evoucherDelivery = evoucherDeliveryMapper.toEntity(evoucherDeliveryDTO);
        evoucherDelivery = evoucherDeliveryRepository.save(evoucherDelivery);
        return evoucherDeliveryMapper.toDto(evoucherDelivery);
    }

    @Override
    public Optional<EvoucherDeliveryDTO> partialUpdate(EvoucherDeliveryDTO evoucherDeliveryDTO) {
        LOG.debug("Request to partially update EvoucherDelivery : {}", evoucherDeliveryDTO);

        return evoucherDeliveryRepository
            .findById(evoucherDeliveryDTO.getId())
            .map(existingEvoucherDelivery -> {
                evoucherDeliveryMapper.partialUpdate(existingEvoucherDelivery, evoucherDeliveryDTO);

                return existingEvoucherDelivery;
            })
            .map(evoucherDeliveryRepository::save)
            .map(evoucherDeliveryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EvoucherDeliveryDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all EvoucherDeliveries");
        return evoucherDeliveryRepository.findAll(pageable).map(evoucherDeliveryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EvoucherDeliveryDTO> findOne(Long id) {
        LOG.debug("Request to get EvoucherDelivery : {}", id);
        return evoucherDeliveryRepository.findById(id).map(evoucherDeliveryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete EvoucherDelivery : {}", id);
        evoucherDeliveryRepository.deleteById(id);
    }
}
