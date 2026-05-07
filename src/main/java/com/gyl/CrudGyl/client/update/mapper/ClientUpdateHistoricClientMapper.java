package com.gyl.CrudGyl.client.update.mapper;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.entity.HistoricClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientUpdateHistoricClientMapper {
    HistoricClient toHistoric(Client client);
}
