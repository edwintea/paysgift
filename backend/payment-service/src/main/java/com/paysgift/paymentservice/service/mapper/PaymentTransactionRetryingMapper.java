package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentTransactionRetrying;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRetryingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentTransactionRetrying} and its DTO {@link PaymentTransactionRetryingDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionRetryingMapper extends EntityMapper<PaymentTransactionRetryingDTO, PaymentTransactionRetrying> {}
