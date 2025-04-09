package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.Payment;
import com.paysgift.paymentservice.service.dto.PaymentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Payment} and its DTO {@link PaymentDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {}
