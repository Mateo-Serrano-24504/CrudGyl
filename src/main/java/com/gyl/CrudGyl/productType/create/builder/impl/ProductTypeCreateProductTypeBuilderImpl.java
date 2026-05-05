package com.gyl.CrudGyl.productType.create.builder.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.productType.create.builder.ProductTypeCreateProductTypeBuilder;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.create.mapper.ProductTypeCreateMapper;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProductTypeCreateProductTypeBuilderImpl implements ProductTypeCreateProductTypeBuilder {
    private final ProductTypeCreateMapper mapper;
    public ProductTypeCreateProductTypeBuilderImpl(ProductTypeCreateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProductType build(ProductTypeCreateRequestDto dto, Instant time) {
        ProductType productType = this.mapper.fromDto(dto);
        productType.setValidSince(time);
        productType.setState(EntityState.ACTIVE);
        productType.setCreatedAt(time);
        return productType;
    }
}
