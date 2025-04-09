package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.TransactionManual;
import com.paysgift.transaction.service.dto.TransactionManualDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionManual} and its DTO {@link TransactionManualDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionManualMapper extends EntityMapper<TransactionManualDTO, TransactionManual> {}
