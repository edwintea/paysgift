package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.CouponCode;
import com.paysgift.productservice.service.dto.CouponCodeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CouponCode} and its DTO {@link CouponCodeDTO}.
 */
@Mapper(componentModel = "spring")
public interface CouponCodeMapper extends EntityMapper<CouponCodeDTO, CouponCode> {}
