package com.paysgift.orderservice.service.mapper;

import com.paysgift.orderservice.domain.Cart;
import com.paysgift.orderservice.service.dto.CartDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDTO, Cart> {}
