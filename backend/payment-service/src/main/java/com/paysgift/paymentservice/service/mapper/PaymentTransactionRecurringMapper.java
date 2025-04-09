package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentTransactionRecurring;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRecurringDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentTransactionRecurring} and its DTO {@link PaymentTransactionRecurringDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionRecurringMapper extends EntityMapper<PaymentTransactionRecurringDTO, PaymentTransactionRecurring> {}
