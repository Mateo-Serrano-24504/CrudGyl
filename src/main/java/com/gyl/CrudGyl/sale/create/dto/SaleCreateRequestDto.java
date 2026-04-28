package com.gyl.CrudGyl.sale.create.dto;

import jakarta.validation.constraints.Positive;

public record SaleCreateRequestDto (
        @Positive
        Double total
) {}
