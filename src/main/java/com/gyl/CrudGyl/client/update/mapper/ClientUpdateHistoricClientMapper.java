package com.gyl.CrudGyl.client.update.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.entity.HistoricClient;
import com.gyl.CrudGyl.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ClientUpdateHistoricClientMapper extends DateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "validTo", source = "time")
    HistoricClient toHistoric(Client client, Instant time);
}
