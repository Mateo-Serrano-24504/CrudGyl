package com.gyl.ClientsMicroservice.client.update.updater;

import com.gyl.ClientsMicroservice.client.entity.Client;
import com.gyl.ClientsMicroservice.client.update.dto.ClientUpdateRequestDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ClientUpdateClientUpdater {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Client original, ClientUpdateRequestDto dto);
}
