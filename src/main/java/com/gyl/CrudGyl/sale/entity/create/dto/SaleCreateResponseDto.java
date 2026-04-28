package com.gyl.CrudGyl.sale.entity.create.dto;

import java.time.OffsetDateTime;

public record SaleCreateResponseDto (
        Long id,
        OffsetDateTime createdAt,
        Double total
) {}
