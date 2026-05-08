package com.gyl.SalesMicroservice.sale.create.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

public record SaleCreateClientFetchResponseDto(
        Long id,
        EntityState state
) {}
