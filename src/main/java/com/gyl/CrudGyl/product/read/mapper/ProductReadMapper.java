package com.gyl.CrudGyl.product.read.mapper;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductReadMapper {
    public ProductReadResponseDto toDto(Product product){
        return new ProductReadResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getProductType().getId()
        );
    }
}
