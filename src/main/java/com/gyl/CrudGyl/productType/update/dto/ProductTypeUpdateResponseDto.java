package com.gyl.CrudGyl.productType.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record ProductTypeUpdateResponseDto (
        Long id,
        String name,
        String description,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
