package com.gyl.CrudGyl.productType.update.builder;

import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;

import java.time.Instant;

public interface ProductTypeUpdateProductTypeBuilder {
    ProductType build(ProductType original, ProductTypeUpdateRequestDto dto, Instant time);
}
