package com.gyl.CrudGyl.client.create.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientCreateRequestDto (
        @NotBlank
        String name,

        @NotBlank
        String surname,

        @NotBlank
        String mail,

        @NotBlank
        String phoneNumber,

        @NotBlank
        String address
) {}
