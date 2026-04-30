package com.gyl.CrudGyl.client.update.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientUpdateRequestDto (
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
