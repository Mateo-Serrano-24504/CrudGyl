package com.gyl.CrudGyl.saleDetail.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleDetailUpdateResponseDto (
        Long id,
        Long amount,
        Double unitPrice,
        Double subtotal,
        Long productId,
        Long saleId,
        OffsetDateTime createdAt,
        EntityState state,
        OffsetDateTime validSince
) {}
