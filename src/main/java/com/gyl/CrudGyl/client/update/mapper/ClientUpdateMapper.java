package com.gyl.CrudGyl.client.update.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class ClientUpdateMapper {
    public Client fromDto(ClientUpdateRequestDto dto) {
        return new Client(
                dto.name(),
                dto.surname(),
                dto.mail(),
                dto.phoneNumber(),
                dto.address()
        );
    }
    public ClientUpdateResponseDto toDto(Client client) {
        return new ClientUpdateResponseDto(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getMail(),
                client.getPhoneNumber(),
                client.getAddress(),
                client.getValidSince().atOffset(ZoneOffset.UTC),
                client.getState(),
                client.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
