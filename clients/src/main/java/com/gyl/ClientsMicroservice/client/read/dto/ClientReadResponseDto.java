package com.gyl.ClientsMicroservice.client.read.dto;

import com.gyl.ClientsMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record ClientReadResponseDto (
        Long id,
        String name,
        String surname,
        String mail,
        String phoneNumber,
        String address,
        OffsetDateTime validSince,
        EntityState state,
        OffsetDateTime createdAt
) {}
