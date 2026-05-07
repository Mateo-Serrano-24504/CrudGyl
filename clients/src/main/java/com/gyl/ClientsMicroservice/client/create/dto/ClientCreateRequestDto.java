package com.gyl.ClientsMicroservice.client.create.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record ClientCreateRequestDto (
        @Length(min = 1, max = 126)
        String name,

        String surname,

        @Email
        @Length(min = 1, max = 126)
        String mail,

        @Pattern(regexp = "^\\d{8}$")
        String phoneNumber,

        @Length(min = 1, max = 126)
        String address
) {}
