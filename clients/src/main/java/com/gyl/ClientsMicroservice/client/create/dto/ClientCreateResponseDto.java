package com.gyl.ClientsMicroservice.client.create.dto;

public record ClientCreateResponseDto(
        Long id,
        String name,
        String surname,
        String mail,
        String phoneNumber,
        String address
) {}
