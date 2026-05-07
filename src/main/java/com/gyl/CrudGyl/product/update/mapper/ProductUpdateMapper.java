package com.gyl.CrudGyl.product.update.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductUpdateMapper extends DateMapper {
    Product fromDto(ProductUpdateRequestDto dto);

    @Mapping(target = "productTypeId", source = "productType.id")
    ProductUpdateResponseDto toDto(Product product);
}
