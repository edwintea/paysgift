package com.paysgift.notification.service.mapper;

import com.paysgift.notification.domain.SendWhatsApp;
import com.paysgift.notification.service.dto.SendWhatsAppDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SendWhatsApp} and its DTO {@link SendWhatsAppDTO}.
 */
@Mapper(componentModel = "spring")
public interface SendWhatsAppMapper extends EntityMapper<SendWhatsAppDTO, SendWhatsApp> {}
