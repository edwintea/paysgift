package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.TransactionLog;
import com.paysgift.transaction.service.dto.TransactionLogDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionLog} and its DTO {@link TransactionLogDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionLogMapper extends EntityMapper<TransactionLogDTO, TransactionLog> {}
