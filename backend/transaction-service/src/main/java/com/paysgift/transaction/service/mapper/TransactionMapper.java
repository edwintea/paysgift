package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.Transaction;
import com.paysgift.transaction.service.dto.TransactionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Transaction} and its DTO {@link TransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDTO, Transaction> {}
