package com.gyl.CrudGyl.productType.read.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductTypeReadRequestDto (
        @NotNull
        @Positive
        Long productTypeId
) {}
