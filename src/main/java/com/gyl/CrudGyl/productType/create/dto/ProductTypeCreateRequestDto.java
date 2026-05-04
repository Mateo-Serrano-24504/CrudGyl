package com.gyl.CrudGyl.productType.create.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductTypeCreateRequestDto (
        @NotBlank
        String name,

        String description
) {}
