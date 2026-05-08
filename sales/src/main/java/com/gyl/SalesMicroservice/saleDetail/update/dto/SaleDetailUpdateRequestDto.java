package com.gyl.SalesMicroservice.saleDetail.update.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleDetailUpdateRequestDto (
        @Positive
        Long amount,

        @Positive
        Long productId,

        @Positive
        Long saleId,

        @NotNull
        EntityState state
) {}
