package com.gyl.ProductsMicroservice.product.create.mapper;

import com.gyl.ProductsMicroservice.mapper.DateMapper;
import com.gyl.ProductsMicroservice.persistence.EntityState;
import com.gyl.ProductsMicroservice.product.create.dto.ProductCreateRequestDto;
import com.gyl.ProductsMicroservice.product.create.dto.ProductCreateResponseDto;
import com.gyl.ProductsMicroservice.product.entity.Product;
import com.gyl.ProductsMicroservice.productType.entity.ProductType;
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

    @Mapping(target = "productTypeId", source = "product.productType.id")
    ProductCreateResponseDto toDto(Product product);
}
