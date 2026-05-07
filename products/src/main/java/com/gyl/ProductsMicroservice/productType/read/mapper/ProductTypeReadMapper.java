package com.gyl.ProductsMicroservice.productType.read.mapper;

import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import com.gyl.ProductsMicroservice.productType.read.dto.ProductTypeReadResponseDto;
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
