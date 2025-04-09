package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentTransaction;
import com.paysgift.paymentservice.service.dto.PaymentTransactionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentTransaction} and its DTO {@link PaymentTransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper extends EntityMapper<PaymentTransactionDTO, PaymentTransaction> {}
