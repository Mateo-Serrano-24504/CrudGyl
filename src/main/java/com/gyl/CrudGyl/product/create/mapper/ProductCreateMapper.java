package com.gyl.CrudGyl.product.create.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductCreateMapper extends DateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "createdAt", source = "time")
    @Mapping(target = "validSince", source = "time")
    Product fromDto(ProductCreateRequestDto dto, EntityState state, ProductType productType, Instant time);
    ProductCreateResponseDto toDto(Product product);
}
