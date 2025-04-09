package com.paysgift.paymentservice.service.mapper;

import com.paysgift.paymentservice.domain.DanaOrder;
import com.paysgift.paymentservice.service.dto.DanaOrderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link DanaOrder} and its DTO {@link DanaOrderDTO}.
 */
@Mapper(componentModel = "spring")
public interface DanaOrderMapper extends EntityMapper<DanaOrderDTO, DanaOrder> {}
