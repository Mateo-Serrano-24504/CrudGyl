package com.gyl.CrudGyl.saleDetail.create.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleDetailCreateRequestDto (
        @NotNull
        @Positive
        Long amount,

        @NotNull
        @Positive
        Long productId
) {}
