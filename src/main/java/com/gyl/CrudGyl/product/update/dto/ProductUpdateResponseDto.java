package com.gyl.CrudGyl.product.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;

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
