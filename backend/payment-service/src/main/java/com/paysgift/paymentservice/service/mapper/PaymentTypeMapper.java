package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentType;
import com.paysgift.paymentservice.service.dto.PaymentTypeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentType} and its DTO {@link PaymentTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends EntityMapper<PaymentTypeDTO, PaymentType> {}
