package com.gyl.CrudGyl.product.create.builder.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.create.builder.ProductCreateProductBuilder;
import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.mapper.ProductCreateMapper;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProductCreateProductBuilderImpl implements ProductCreateProductBuilder {
    private final ProductCreateMapper mapper;
    public ProductCreateProductBuilderImpl(ProductCreateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Product build(ProductCreateRequestDto dto, ProductType productType, Instant time) {
        Product product = this.mapper.fromDto(dto);
        product.setProductType(productType);
        product.setValidSince(time);
        product.setState(EntityState.ACTIVE);
        product.setCreatedAt(time);
        return product;
    }
}
