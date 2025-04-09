package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.Product;
import com.paysgift.productservice.service.dto.ProductDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
