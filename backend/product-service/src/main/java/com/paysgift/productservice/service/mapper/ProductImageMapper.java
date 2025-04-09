package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.ProductImage;
import com.paysgift.productservice.service.dto.ProductImageDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductImage} and its DTO {@link ProductImageDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductImageMapper extends EntityMapper<ProductImageDTO, ProductImage> {}
