package com.gyl.SalesMicroservice.sale.read.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;
import java.util.List;

public record SaleReadResponseDto(
        Long id,
        Double total,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt,
        Long clientId,
        List<SaleDetailReadResponseDto> details
) {}
