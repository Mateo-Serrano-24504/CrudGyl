package com.gyl.ProductsMicroservice.product.update.dto;

import com.gyl.ProductsMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record ProductUpdateResponseDto (
        Long id,
        String name,
        Double price,
        Long stock,
        Long productTypeId,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
