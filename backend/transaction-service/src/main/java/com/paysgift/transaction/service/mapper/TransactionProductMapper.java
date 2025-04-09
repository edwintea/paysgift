package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.TransactionProduct;
import com.paysgift.transaction.service.dto.TransactionProductDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionProduct} and its DTO {@link TransactionProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionProductMapper extends EntityMapper<TransactionProductDTO, TransactionProduct> {}
