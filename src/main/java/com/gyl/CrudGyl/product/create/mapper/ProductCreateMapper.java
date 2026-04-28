package com.gyl.CrudGyl.product.create.mapper;

import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateMapper {
    public Product fromDto(ProductCreateRequestDto dto) {
        return new Product(
                dto.name(),
                dto.price(),
                dto.stock()
        );
    }
    public ProductCreateResponseDto toDto(Product product) {
        return new ProductCreateResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getProductType().getId()
        );
    }
}
