package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentProvider;
import com.paysgift.paymentservice.service.dto.PaymentProviderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentProvider} and its DTO {@link PaymentProviderDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentProviderMapper extends EntityMapper<PaymentProviderDTO, PaymentProvider> {}
