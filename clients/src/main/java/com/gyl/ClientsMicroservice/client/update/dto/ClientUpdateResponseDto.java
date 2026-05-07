package com.gyl.ClientsMicroservice.client.update.dto;

import com.gyl.ClientsMicroservice.persistence.EntityState;

import java.time.OffsetDateTime;

public record ClientUpdateResponseDto (
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
