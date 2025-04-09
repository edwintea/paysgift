package com.paysgift.notification.service.mapper;

import com.paysgift.notification.domain.SendMessage;
import com.paysgift.notification.service.dto.SendMessageDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SendMessage} and its DTO {@link SendMessageDTO}.
 */
@Mapper(componentModel = "spring")
public interface SendMessageMapper extends EntityMapper<SendMessageDTO, SendMessage> {}
