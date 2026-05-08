package com.gyl.SalesMicroservice.sale.update.dto;

import com.gyl.SalesMicroservice.persistence.EntityState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleUpdateRequestDto (
        @NotNull
        EntityState state,

        @Positive
        Long clientId
) {}
