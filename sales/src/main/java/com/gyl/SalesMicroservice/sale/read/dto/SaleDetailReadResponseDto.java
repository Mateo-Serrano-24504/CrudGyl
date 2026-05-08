package com.gyl.SalesMicroservice.sale.read.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleDetailReadResponseDto(
        Long id,
        Long amount,
        Double unitPrice,
        Double subtotal,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt,
        Long productId,
        Long saleId
) {}
