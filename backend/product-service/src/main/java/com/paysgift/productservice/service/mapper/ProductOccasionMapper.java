package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.ProductOccasion;
import com.paysgift.productservice.service.dto.ProductOccasionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductOccasion} and its DTO {@link ProductOccasionDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductOccasionMapper extends EntityMapper<ProductOccasionDTO, ProductOccasion> {}
