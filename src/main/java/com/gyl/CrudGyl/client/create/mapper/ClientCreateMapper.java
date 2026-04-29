package com.gyl.CrudGyl.client.create.mapper;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ClientCreateMapper {
    public Client fromDto(ClientCreateRequestDto dto) {
        return new Client(
                dto.name(),
                dto.surname(),
                dto.mail(),
                dto.phoneNumber(),
                dto.address(),
                EntityState.ACTIVE,
                Instant.now()
        );
    }
    public ClientCreateResponseDto toDto(Client client) {
        return new ClientCreateResponseDto(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getMail(),
                client.getPhoneNumber(),
                client.getAddress()
        );
    }
}
