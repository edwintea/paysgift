package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentCustomerSamsung;
import com.paysgift.paymentservice.service.dto.PaymentCustomerSamsungDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentCustomerSamsung} and its DTO {@link PaymentCustomerSamsungDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentCustomerSamsungMapper extends EntityMapper<PaymentCustomerSamsungDTO, PaymentCustomerSamsung> {}
