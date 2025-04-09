package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.PaysgiftPromoInfo;
import com.paysgift.productservice.service.dto.PaysgiftPromoInfoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaysgiftPromoInfo} and its DTO {@link PaysgiftPromoInfoDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaysgiftPromoInfoMapper extends EntityMapper<PaysgiftPromoInfoDTO, PaysgiftPromoInfo> {}
