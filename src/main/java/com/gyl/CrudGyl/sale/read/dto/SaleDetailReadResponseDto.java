package com.gyl.CrudGyl.sale.read.dto;

import com.gyl.CrudGyl.persistence.EntityState;

import java.time.OffsetDateTime;

public record SaleDetailReadResponseDto(
        Long id,
        Long amount,
        Double unitPrice,
        Double subtotal,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
