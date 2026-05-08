package com.gyl.SalesMicroservice.saleDetail.readPage.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

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
