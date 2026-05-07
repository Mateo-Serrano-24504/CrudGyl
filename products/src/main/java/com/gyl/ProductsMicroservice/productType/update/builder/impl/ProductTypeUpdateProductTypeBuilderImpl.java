package com.gyl.ProductsMicroservice.productType.update.builder.impl;

import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import com.gyl.ProductsMicroservice.productType.update.builder.ProductTypeUpdateProductTypeBuilder;
import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.ProductsMicroservice.productType.update.mapper.ProductTypeUpdateMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProductTypeUpdateProductTypeBuilderImpl implements ProductTypeUpdateProductTypeBuilder {
    private final ProductTypeUpdateMapper mapper;
    public ProductTypeUpdateProductTypeBuilderImpl(ProductTypeUpdateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProductType build(ProductType original, ProductTypeUpdateRequestDto dto, Instant time) {
        ProductType productType = this.mapper.fromDto(dto);
        productType.setId(original.getId());
        productType.setValidSince(time);
        productType.setCreatedAt(original.getCreatedAt());
        return productType;
    }
}
