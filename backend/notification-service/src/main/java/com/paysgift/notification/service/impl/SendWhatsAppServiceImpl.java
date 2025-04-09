package com.paysgift.notification.service.impl;

import com.paysgift.notification.domain.SendWhatsApp;
import com.paysgift.notification.repository.SendWhatsAppRepository;
import com.paysgift.notification.service.SendWhatsAppService;
import com.paysgift.notification.service.dto.SendWhatsAppDTO;
import com.paysgift.notification.service.mapper.SendWhatsAppMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.notification.domain.SendWhatsApp}.
 */
@Service
@Transactional
public class SendWhatsAppServiceImpl implements SendWhatsAppService {

    private static final Logger LOG = LoggerFactory.getLogger(SendWhatsAppServiceImpl.class);

    private final SendWhatsAppRepository sendWhatsAppRepository;

    private final SendWhatsAppMapper sendWhatsAppMapper;

    public SendWhatsAppServiceImpl(SendWhatsAppRepository sendWhatsAppRepository, SendWhatsAppMapper sendWhatsAppMapper) {
        this.sendWhatsAppRepository = sendWhatsAppRepository;
        this.sendWhatsAppMapper = sendWhatsAppMapper;
    }

    @Override
    public SendWhatsAppDTO save(SendWhatsAppDTO sendWhatsAppDTO) {
        LOG.debug("Request to save SendWhatsApp : {}", sendWhatsAppDTO);
        SendWhatsApp sendWhatsApp = sendWhatsAppMapper.toEntity(sendWhatsAppDTO);
        sendWhatsApp = sendWhatsAppRepository.save(sendWhatsApp);
        return sendWhatsAppMapper.toDto(sendWhatsApp);
    }

    @Override
    public SendWhatsAppDTO update(SendWhatsAppDTO sendWhatsAppDTO) {
        LOG.debug("Request to update SendWhatsApp : {}", sendWhatsAppDTO);
        SendWhatsApp sendWhatsApp = sendWhatsAppMapper.toEntity(sendWhatsAppDTO);
        sendWhatsApp = sendWhatsAppRepository.save(sendWhatsApp);
        return sendWhatsAppMapper.toDto(sendWhatsApp);
    }

    @Override
    public Optional<SendWhatsAppDTO> partialUpdate(SendWhatsAppDTO sendWhatsAppDTO) {
        LOG.debug("Request to partially update SendWhatsApp : {}", sendWhatsAppDTO);

        return sendWhatsAppRepository
            .findById(sendWhatsAppDTO.getId())
            .map(existingSendWhatsApp -> {
                sendWhatsAppMapper.partialUpdate(existingSendWhatsApp, sendWhatsAppDTO);

                return existingSendWhatsApp;
            })
            .map(sendWhatsAppRepository::save)
            .map(sendWhatsAppMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SendWhatsAppDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all SendWhatsApps");
        return sendWhatsAppRepository.findAll(pageable).map(sendWhatsAppMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SendWhatsAppDTO> findOne(Long id) {
        LOG.debug("Request to get SendWhatsApp : {}", id);
        return sendWhatsAppRepository.findById(id).map(sendWhatsAppMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SendWhatsApp : {}", id);
        sendWhatsAppRepository.deleteById(id);
    }
}
