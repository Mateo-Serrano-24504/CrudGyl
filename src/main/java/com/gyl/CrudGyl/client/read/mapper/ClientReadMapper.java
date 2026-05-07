package com.gyl.CrudGyl.client.read.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import com.gyl.CrudGyl.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientReadMapper extends DateMapper {
    ClientReadResponseDto toDto(Client client);
}
