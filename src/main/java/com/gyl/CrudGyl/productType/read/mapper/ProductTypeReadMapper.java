package com.gyl.CrudGyl.productType.read.mapper;

import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.read.dto.ProductTypeReadResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeReadMapper {
    public ProductTypeReadResponseDto toDto(ProductType productType){
        return new ProductTypeReadResponseDto(
                productType.getId(),
                productType.getName(),
                productType.getDescription()
        );
    }
}
