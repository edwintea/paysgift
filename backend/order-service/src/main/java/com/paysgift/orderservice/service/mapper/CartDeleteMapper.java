package com.paysgift.orderservice.service.mapper;

import com.paysgift.orderservice.domain.CartDelete;
import com.paysgift.orderservice.service.dto.CartDeleteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CartDelete} and its DTO {@link CartDeleteDTO}.
 */
@Mapper(componentModel = "spring")
public interface CartDeleteMapper extends EntityMapper<CartDeleteDTO, CartDelete> {}
