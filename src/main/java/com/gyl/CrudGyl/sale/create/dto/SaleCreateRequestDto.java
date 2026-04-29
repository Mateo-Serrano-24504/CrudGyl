package com.gyl.CrudGyl.sale.create.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record SaleCreateRequestDto (
        @NotNull
        @Positive
        Long clientId,

        @NotNull
        @NotEmpty
        List<SaleDetailCreateRequestDto> details
) {}
