package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentList;
import com.paysgift.paymentservice.service.dto.PaymentListDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentList} and its DTO {@link PaymentListDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentListMapper extends EntityMapper<PaymentListDTO, PaymentList> {}
