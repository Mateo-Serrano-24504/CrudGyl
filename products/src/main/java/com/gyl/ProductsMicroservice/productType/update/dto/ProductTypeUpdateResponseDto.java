package com.gyl.ProductsMicroservice.productType.update.dto;

import com.gyl.ProductsMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record ProductTypeUpdateResponseDto (
        Long id,
        String name,
        String description,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
