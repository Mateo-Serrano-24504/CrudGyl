package com.gyl.CrudGyl.product.create.dto;

import com.gyl.CrudGyl.productType.entity.ProductType;

public record ProductCreateResponseDto(
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId
) {}
