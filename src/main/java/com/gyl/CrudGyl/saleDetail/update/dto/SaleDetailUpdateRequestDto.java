package com.gyl.CrudGyl.saleDetail.update.dto;

import com.gyl.CrudGyl.persistence.EntityState;
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
