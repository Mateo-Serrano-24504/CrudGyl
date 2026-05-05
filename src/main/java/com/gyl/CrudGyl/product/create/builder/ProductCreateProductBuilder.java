package com.gyl.CrudGyl.product.create.builder;

import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;

import java.time.Instant;

public interface ProductCreateProductBuilder {
    Product build(ProductCreateRequestDto dto, ProductType productType, Instant time);
}
