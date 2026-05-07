package com.gyl.ProductsMicroservice.product.read.mapper;

import com.gyl.ProductsMicroservice.mapper.DateMapper;
import com.gyl.ProductsMicroservice.product.entity.Product;
import com.gyl.ProductsMicroservice.product.read.dto.ProductReadResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductReadMapper extends DateMapper {
    @Mapping(target = "productTypeId", source = "product.productType.id")
    ProductReadResponseDto toDto(Product product);
}
