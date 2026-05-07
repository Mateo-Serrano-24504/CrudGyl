package com.gyl.CrudGyl.product.read.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductReadMapper extends DateMapper {
    @Mapping(target = "productTypeId", source = "product.productType.id")
    ProductReadResponseDto toDto(Product product);
}
