package com.gyl.CrudGyl.sale.readPage.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleReadPageResponseDto (
    Long id,
    Double total,
    OffsetDateTime validSince,
    EntityState state,
    OffsetDateTime createdAt,
    Long clientId
) {}
