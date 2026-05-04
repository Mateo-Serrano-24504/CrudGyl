package com.gyl.CrudGyl.client.update.builder;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;

import java.time.Instant;

public interface ClientUpdateClientBuilder {
    Client build(Client original, ClientUpdateRequestDto dto, Instant time);
}
