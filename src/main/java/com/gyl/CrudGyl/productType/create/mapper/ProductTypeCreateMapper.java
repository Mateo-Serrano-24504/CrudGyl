package com.gyl.CrudGyl.productType.create.mapper;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeCreateMapper {
    public ProductType fromDto(ProductTypeCreateRequestDto dto) {
        return new ProductType(dto.name(), dto.description());
    }
    public ProductTypeCreateResponseDto toDto(ProductType productType) {
        return new ProductTypeCreateResponseDto(
                productType.getId(), productType.getName(), productType.getDescription()
        );
    }
}
