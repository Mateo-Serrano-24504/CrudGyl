package com.gyl.CrudGyl.sale.create.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaleCreateRequestDto (
        @NotNull
        @Positive
        Double total
) {}
