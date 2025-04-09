package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.EvoucherDelivery;
import com.paysgift.productservice.service.dto.EvoucherDeliveryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link EvoucherDelivery} and its DTO {@link EvoucherDeliveryDTO}.
 */
@Mapper(componentModel = "spring")
public interface EvoucherDeliveryMapper extends EntityMapper<EvoucherDeliveryDTO, EvoucherDelivery> {}
