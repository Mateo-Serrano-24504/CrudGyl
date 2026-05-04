package com.gyl.CrudGyl.saleDetail.readPage.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleDetailReadPageResponseDto (
        Long id,
        Long amount,
        Double unitPrice,
        Double subtotal,
        Long productId,
        OffsetDateTime createdAt,
        EntityState state,
        OffsetDateTime validSince
) {}
