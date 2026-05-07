package com.gyl.CrudGyl.product.read.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductReadMapper extends DateMapper {
    ProductReadResponseDto toDto(Product product);
}
