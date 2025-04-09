package com.paysgift.notification.service.impl;

import com.paysgift.notification.domain.SendMessage;
import com.paysgift.notification.repository.SendMessageRepository;
import com.paysgift.notification.service.SendMessageService;
import com.paysgift.notification.service.dto.SendMessageDTO;
import com.paysgift.notification.service.mapper.SendMessageMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.notification.domain.SendMessage}.
 */
@Service
@Transactional
public class SendMessageServiceImpl implements SendMessageService {

    private static final Logger LOG = LoggerFactory.getLogger(SendMessageServiceImpl.class);

    private final SendMessageRepository sendMessageRepository;

    private final SendMessageMapper sendMessageMapper;

    public SendMessageServiceImpl(SendMessageRepository sendMessageRepository, SendMessageMapper sendMessageMapper) {
        this.sendMessageRepository = sendMessageRepository;
        this.sendMessageMapper = sendMessageMapper;
    }

    @Override
    public SendMessageDTO save(SendMessageDTO sendMessageDTO) {
        LOG.debug("Request to save SendMessage : {}", sendMessageDTO);
        SendMessage sendMessage = sendMessageMapper.toEntity(sendMessageDTO);
        sendMessage = sendMessageRepository.save(sendMessage);
        return sendMessageMapper.toDto(sendMessage);
    }

    @Override
    public SendMessageDTO update(SendMessageDTO sendMessageDTO) {
        LOG.debug("Request to update SendMessage : {}", sendMessageDTO);
        SendMessage sendMessage = sendMessageMapper.toEntity(sendMessageDTO);
        sendMessage = sendMessageRepository.save(sendMessage);
        return sendMessageMapper.toDto(sendMessage);
    }

    @Override
    public Optional<SendMessageDTO> partialUpdate(SendMessageDTO sendMessageDTO) {
        LOG.debug("Request to partially update SendMessage : {}", sendMessageDTO);

        return sendMessageRepository
            .findById(sendMessageDTO.getId())
            .map(existingSendMessage -> {
                sendMessageMapper.partialUpdate(existingSendMessage, sendMessageDTO);

                return existingSendMessage;
            })
            .map(sendMessageRepository::save)
            .map(sendMessageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SendMessageDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all SendMessages");
        return sendMessageRepository.findAll(pageable).map(sendMessageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SendMessageDTO> findOne(Long id) {
        LOG.debug("Request to get SendMessage : {}", id);
        return sendMessageRepository.findById(id).map(sendMessageMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SendMessage : {}", id);
        sendMessageRepository.deleteById(id);
    }
}
