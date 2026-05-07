package com.gyl.ProductsMicroservice.productType.update.builder;

import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateRequestDto;

import java.time.Instant;

public interface ProductTypeUpdateProductTypeBuilder {
    ProductType build(ProductType original, ProductTypeUpdateRequestDto dto, Instant time);
}
