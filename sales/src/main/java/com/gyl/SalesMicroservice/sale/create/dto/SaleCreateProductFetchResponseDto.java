package com.gyl.SalesMicroservice.sale.create.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;

public record SaleCreateProductFetchResponseDto(
        Long id,
        Double price,
        EntityState state
) {}
