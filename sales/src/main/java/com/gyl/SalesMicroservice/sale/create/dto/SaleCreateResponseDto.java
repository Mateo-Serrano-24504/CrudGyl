package com.gyl.SalesMicroservice.sale.create.dto;

import java.time.OffsetDateTime;

public record SaleCreateResponseDto (
        Long id,
        OffsetDateTime createdAt,
        Double total
) {}
