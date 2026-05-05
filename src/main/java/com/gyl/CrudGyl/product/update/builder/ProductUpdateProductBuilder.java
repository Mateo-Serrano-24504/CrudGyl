package com.gyl.CrudGyl.product.update.builder;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.productType.entity.ProductType;

import java.time.Instant;

public interface ProductUpdateProductBuilder {
    Product build(Product original, ProductUpdateRequestDto dto, ProductType productType, Instant time);
}
