package com.gyl.ClientsMicroservice.client.read.mapper;

import com.gyl.ClientsMicroservice.client.entity.Client;
import com.gyl.ClientsMicroservice.client.read.dto.ClientReadResponseDto;
import com.gyl.ClientsMicroservice.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientReadMapper extends DateMapper {
    ClientReadResponseDto toDto(Client client);
}
