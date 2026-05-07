package com.gyl.ProductsMicroservice.productType.create.mapper;

import com.gyl.ProductsMicroservice.mapper.DateMapper;
import com.gyl.ProductsMicroservice.persistence.EntityState;
import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductTypeCreateMapper extends DateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "state", source = "state")
    @Mapping(target = "createdAt", source = "time")
    @Mapping(target = "validSince", source = "time")
    ProductType fromDto(ProductTypeCreateRequestDto dto, EntityState state, Instant time);
    ProductTypeCreateResponseDto toDto(ProductType productType);
}
