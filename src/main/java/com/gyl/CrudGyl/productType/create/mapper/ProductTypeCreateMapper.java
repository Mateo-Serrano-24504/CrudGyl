package com.gyl.CrudGyl.productType.create.mapper;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.CrudGyl.productType.entity.ProductType;

public class ProductTypeCreateMapper {
    ProductType fromDto(ProductTypeCreateDto dto) {
        return new ProductType(dto.name(), dto.description());
    }
    ProductTypeCreateResponseDto toDto(ProductType productType) {
        return new ProductTypeCreateResponseDto(
                productType.getId(), productType.getName(), productType.getDescription()
        );
    }
}
