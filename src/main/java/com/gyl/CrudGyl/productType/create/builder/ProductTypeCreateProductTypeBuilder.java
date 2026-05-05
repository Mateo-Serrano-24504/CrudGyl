package com.gyl.CrudGyl.productType.create.builder;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.entity.ProductType;

import java.time.Instant;

public interface ProductTypeCreateProductTypeBuilder {
    ProductType build(ProductTypeCreateRequestDto dto, Instant time);
}
