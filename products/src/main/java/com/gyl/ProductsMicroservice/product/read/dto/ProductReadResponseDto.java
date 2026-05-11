package com.gyl.ProductsMicroservice.product.read.dto;

import com.gyl.ProductsMicroservice.persistence.EntityState;

public record ProductReadResponseDto (
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId,
        EntityState state
) {}
