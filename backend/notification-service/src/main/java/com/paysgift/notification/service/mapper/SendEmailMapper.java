package com.paysgift.notification.service.mapper;

import com.paysgift.notification.domain.SendEmail;
import com.paysgift.notification.service.dto.SendEmailDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SendEmail} and its DTO {@link SendEmailDTO}.
 */
@Mapper(componentModel = "spring")
public interface SendEmailMapper extends EntityMapper<SendEmailDTO, SendEmail> {}
