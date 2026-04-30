package com.gyl.CrudGyl.product.update.mapper;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class ProductUpdateMapper {
    public Product fromDto(ProductUpdateRequestDto dto) {
        return new Product(
                dto.name(),
                dto.price(),
                dto.stock(),
                dto.state()
        );
    }
    public ProductUpdateResponseDto toDto(Product product) {
        return new ProductUpdateResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getProductType().getId(),
                product.getValidSince().atOffset(ZoneOffset.UTC),
                product.getState(),
                product.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
