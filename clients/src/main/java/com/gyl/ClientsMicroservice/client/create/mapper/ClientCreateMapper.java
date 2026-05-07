package com.gyl.ClientsMicroservice.client.create.mapper;

import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateResponseDto;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;
import com.gyl.ClientsMicroservice.client.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientCreateMapper {
    Client fromDto(ClientCreateRequestDto dto);
    ClientCreateResponseDto toDto(Client client);
}
