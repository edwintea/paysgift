package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.PaysgiftPromo;
import com.paysgift.productservice.service.dto.PaysgiftPromoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaysgiftPromo} and its DTO {@link PaysgiftPromoDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaysgiftPromoMapper extends EntityMapper<PaysgiftPromoDTO, PaysgiftPromo> {}
