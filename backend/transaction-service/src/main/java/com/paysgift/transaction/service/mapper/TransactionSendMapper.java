package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.TransactionSend;
import com.paysgift.transaction.service.dto.TransactionSendDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionSend} and its DTO {@link TransactionSendDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionSendMapper extends EntityMapper<TransactionSendDTO, TransactionSend> {}
