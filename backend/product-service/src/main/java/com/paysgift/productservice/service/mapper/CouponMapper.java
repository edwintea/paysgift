package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.Coupon;
import com.paysgift.productservice.service.dto.CouponDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Coupon} and its DTO {@link CouponDTO}.
 */
@Mapper(componentModel = "spring")
public interface CouponMapper extends EntityMapper<CouponDTO, Coupon> {}
