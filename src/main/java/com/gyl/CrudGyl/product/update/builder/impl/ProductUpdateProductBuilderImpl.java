package com.gyl.CrudGyl.product.update.builder.impl;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.builder.ProductUpdateProductBuilder;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.mapper.ProductUpdateMapper;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProductUpdateProductBuilderImpl implements ProductUpdateProductBuilder {
    private final ProductUpdateMapper mapper;
    public ProductUpdateProductBuilderImpl(ProductUpdateMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Product build(Product original, ProductUpdateRequestDto dto, ProductType productType, Instant time) {
        Product product = this.mapper.fromDto(dto);
        product.setId(original.getId());
        product.setValidSince(time);
        product.setCreatedAt(original.getCreatedAt());
        product.setProductType(productType);
        return product;
    }
}
