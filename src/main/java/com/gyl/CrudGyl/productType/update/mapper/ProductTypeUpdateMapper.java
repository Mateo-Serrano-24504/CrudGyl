package com.gyl.CrudGyl.productType.update.mapper;

import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class ProductTypeUpdateMapper {
    public ProductType fromDto(ProductTypeUpdateRequestDto dto) {
        return new ProductType(
                dto.name(),
                dto.description(),
                dto.state()
        );
    }
    public ProductTypeUpdateResponseDto toDto(ProductType productType) {
        return new ProductTypeUpdateResponseDto(
                productType.getId(),
                productType.getName(),
                productType.getDescription(),
                productType.getValidSince().atOffset(ZoneOffset.UTC),
                productType.getState(),
                productType.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
