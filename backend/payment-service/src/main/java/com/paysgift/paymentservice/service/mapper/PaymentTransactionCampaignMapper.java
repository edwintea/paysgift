package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentTransactionCampaign;
import com.paysgift.paymentservice.service.dto.PaymentTransactionCampaignDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentTransactionCampaign} and its DTO {@link PaymentTransactionCampaignDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentTransactionCampaignMapper extends EntityMapper<PaymentTransactionCampaignDTO, PaymentTransactionCampaign> {}
