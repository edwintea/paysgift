package com.paysgift.notification.service.impl;

import com.paysgift.notification.domain.SendEmail;
import com.paysgift.notification.repository.SendEmailRepository;
import com.paysgift.notification.service.SendEmailService;
import com.paysgift.notification.service.dto.SendEmailDTO;
import com.paysgift.notification.service.mapper.SendEmailMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.notification.domain.SendEmail}.
 */
@Service
@Transactional
public class SendEmailServiceImpl implements SendEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    private final SendEmailRepository sendEmailRepository;

    private final SendEmailMapper sendEmailMapper;

    public SendEmailServiceImpl(SendEmailRepository sendEmailRepository, SendEmailMapper sendEmailMapper) {
        this.sendEmailRepository = sendEmailRepository;
        this.sendEmailMapper = sendEmailMapper;
    }

    @Override
    public SendEmailDTO save(SendEmailDTO sendEmailDTO) {
        LOG.debug("Request to save SendEmail : {}", sendEmailDTO);
        SendEmail sendEmail = sendEmailMapper.toEntity(sendEmailDTO);
        sendEmail = sendEmailRepository.save(sendEmail);
        return sendEmailMapper.toDto(sendEmail);
    }

    @Override
    public SendEmailDTO update(SendEmailDTO sendEmailDTO) {
        LOG.debug("Request to update SendEmail : {}", sendEmailDTO);
        SendEmail sendEmail = sendEmailMapper.toEntity(sendEmailDTO);
        sendEmail = sendEmailRepository.save(sendEmail);
        return sendEmailMapper.toDto(sendEmail);
    }

    @Override
    public Optional<SendEmailDTO> partialUpdate(SendEmailDTO sendEmailDTO) {
        LOG.debug("Request to partially update SendEmail : {}", sendEmailDTO);

        return sendEmailRepository
            .findById(sendEmailDTO.getId())
            .map(existingSendEmail -> {
                sendEmailMapper.partialUpdate(existingSendEmail, sendEmailDTO);

                return existingSendEmail;
            })
            .map(sendEmailRepository::save)
            .map(sendEmailMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SendEmailDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all SendEmails");
        return sendEmailRepository.findAll(pageable).map(sendEmailMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SendEmailDTO> findOne(Long id) {
        LOG.debug("Request to get SendEmail : {}", id);
        return sendEmailRepository.findById(id).map(sendEmailMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SendEmail : {}", id);
        sendEmailRepository.deleteById(id);
    }
}
