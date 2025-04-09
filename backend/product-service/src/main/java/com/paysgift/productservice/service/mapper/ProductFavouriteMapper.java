package com.paysgift.productservice.service.mapper;

import com.paysgift.productservice.domain.ProductFavourite;
import com.paysgift.productservice.service.dto.ProductFavouriteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductFavourite} and its DTO {@link ProductFavouriteDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductFavouriteMapper extends EntityMapper<ProductFavouriteDTO, ProductFavourite> {}
