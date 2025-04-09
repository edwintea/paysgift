package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.PaymentCampaign;
import com.paysgift.paymentservice.service.dto.PaymentCampaignDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentCampaign} and its DTO {@link PaymentCampaignDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentCampaignMapper extends EntityMapper<PaymentCampaignDTO, PaymentCampaign> {}
