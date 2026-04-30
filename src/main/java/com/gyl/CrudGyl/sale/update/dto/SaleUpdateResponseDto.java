package com.gyl.CrudGyl.sale.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleUpdateResponseDto (
        Long id,
        Double price,
        Long clientId,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
