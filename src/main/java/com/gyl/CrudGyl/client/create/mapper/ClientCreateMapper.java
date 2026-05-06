package com.gyl.CrudGyl.client.create.mapper;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientCreateMapper {
    Client fromDto(ClientCreateRequestDto dto);
    ClientCreateResponseDto toDto(Client client);
}
