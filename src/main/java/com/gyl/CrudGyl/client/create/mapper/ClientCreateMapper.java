package com.gyl.CrudGyl.client.create.mapper;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientCreateMapper {
    public Client fromDto(ClientCreateRequestDto dto) {
        return new Client(
                dto.name(),
                dto.surname(),
                dto.mail(),
                dto.phoneNumber(),
                dto.address()
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
