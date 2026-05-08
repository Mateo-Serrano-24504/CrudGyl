package com.gyl.SalesMicroservice.sale.update.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleUpdateResponseDto (
        Long id,
        Double total,
        Long clientId,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
