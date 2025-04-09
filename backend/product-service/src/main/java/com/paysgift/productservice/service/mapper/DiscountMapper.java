package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.Discount;
import com.paysgift.productservice.service.dto.DiscountDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Discount} and its DTO {@link DiscountDTO}.
 */
@Mapper(componentModel = "spring")
public interface DiscountMapper extends EntityMapper<DiscountDTO, Discount> {}
